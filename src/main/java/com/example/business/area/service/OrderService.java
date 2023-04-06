package com.example.business.area.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.area.dto.request.OrderAreaRequest;
import com.example.business.area.dto.request.QueryOrderRequest;
import com.example.business.area.dto.request.SelectLeaveNumRequest;
import com.example.business.area.dto.response.QueryOrderResponse;
import com.example.business.area.dto.response.SelectLeaveNumResponse;
import com.example.business.area.entity.Area;
import com.example.business.area.entity.Order;
import com.example.business.area.mapper.OrderMapper;
import com.example.business.user.entity.ApiResult;
import com.example.business.user.entity.User;
import com.example.business.user.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private AreaService areaService;

    @Resource
    private UserService userService;

    /**
     * 时间段划分（1-8）
     */
    public static HashMap<Integer, String> time_map = new HashMap<Integer, String>() {
        {
            put(1, "8:00-9:00");
            put(2, "9:00-10:00");
            put(3, "10:00-11:00");
            put(4, "11:00-12:00");
            put(5, "14:00-15:00");
            put(6, "15:00-16:00");
            put(7, "16:00-17:00");
            put(8, "17:00-18:00");
        }
    };
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    @Transactional
    public ApiResult<?> orderArea(OrderAreaRequest request) {
        //判断场馆是否存在
        LambdaQueryWrapper<Area> areaLambdaQueryWrapper = new LambdaQueryWrapper<>();
        areaLambdaQueryWrapper.eq(Area::getId, request.getArea_id());
        if (areaService.list(areaLambdaQueryWrapper).size() != 1) return ApiResult.fail("场馆不存在");

        Area area = areaService.getOne(areaLambdaQueryWrapper);
        for (Integer time : request.getTimes()) {
            if (time < 1 || time > 8) return ApiResult.fail("预约时间有误，请联系管理员");
            //判断场馆当前时间内容纳人数是否满足
            LambdaQueryWrapper<Order> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Order::getAreaId, request.getArea_id());
            wrapper.eq(Order::getTime, time);
            wrapper.like(Order::getOrderDate,sdf.format(request.getOrder_date()));
            List<Order> orders = this.list(wrapper);
            //该场地在此时间段内已预约人数
            int all = 0;
            for (Order order1 : orders) {
                all += order1.getNum();
            }
            //如果剩余可容纳人数小于当前预约人数，则预约失败
            if (area.getNum() - all < request.getNum()) {
                return ApiResult.fail(area.getName() + " 在" + sdf.format(request.getOrder_date()) + "的" + time_map.get(time) + "可容纳人数不足");
            }

            Order order = new Order();
            order.setOrderDate(request.getOrder_date());
            order.setAreaId(request.getArea_id());
            order.setNum(request.getNum());
            order.setTime(time);
            order.setUserId(request.getUser_id());
            this.save(order);
        }
        return ApiResult.ok();
    }

    @Transactional
    public ApiResult<?> deleteOrderArea(OrderAreaRequest request) {
        for (Integer time : request.getTimes()) {
            LambdaQueryWrapper<Order> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Order::getAreaId, request.getArea_id());
            wrapper.eq(Order::getTime, time);
            wrapper.eq(Order::getUserId, request.getUser_id());
            this.remove(wrapper);
        }
        return ApiResult.ok("取消成功");
    }

    @Transactional
    public ApiResult<?> deleteOrder(Long id) {
        LambdaQueryWrapper<Order> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Order::getId, id);
        this.remove(wrapper);
        return ApiResult.ok("取消成功");
    }

    public ApiResult<?> queryOrder(QueryOrderRequest request) {
        List<QueryOrderResponse> responses = new ArrayList<>();
        Page<Order> page = PageHelper.startPage(request.getPage(), request.getPage_size());
        PageInfo<Order> orders = PageInfo.of(orderMapper.queryOrder(request));
        page.close();
        Map<Long, String> area_map = areaService.list().stream().collect(Collectors.toMap(Area::getId, Area::getName));
        Map<Long, String> user_map = userService.list().stream().collect(Collectors.toMap(User::getId, User::getName));
        for (Order order : orders.getList()) {
            QueryOrderResponse response = new QueryOrderResponse();
            response.setOrder_id(order.getId());
            response.setArea(area_map.get(order.getAreaId()));
            response.setArea_id(order.getAreaId());
            response.setUser(user_map.get(order.getUserId()));
            response.setUser_id(order.getUserId());
            response.setTime(time_map.get(order.getTime()));
            response.setDay(sdf.format(order.getOrderDate()));
            responses.add(response);
        }
        return ApiResult.ok(responses, String.valueOf(orders.getTotal()));

    }

    public ApiResult<?> selectLeaveNum(SelectLeaveNumRequest request) {
        List<SelectLeaveNumResponse> responses = new ArrayList<>();
        Area area = areaService.getById(request.getArea_id());
        for (int i = 1; i <= 8; i++) {
            LambdaQueryWrapper<Order> wrapper = new LambdaQueryWrapper<>();
            wrapper.like(Order::getOrderDate, request.getDate());
            wrapper.eq(Order::getAreaId, request.getArea_id());
            wrapper.eq(Order::getTime, i);
            List<Order> list = this.list(wrapper);
            Integer num = 0;
            for (Order order : list) {
                num += order.getNum();
            }
            SelectLeaveNumResponse response = new SelectLeaveNumResponse();
            response.setLeave_num(area.getNum() - num);
            response.setTime(i + "");
            responses.add(response);
        }
        return ApiResult.ok(responses);
    }
}
