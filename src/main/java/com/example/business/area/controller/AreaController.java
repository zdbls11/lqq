package com.example.business.area.controller;

import com.example.business.area.dto.request.AddAreaRequest;
import com.example.business.area.dto.request.OrderAreaRequest;
import com.example.business.area.dto.request.QueryAreaRequest;
import com.example.business.area.dto.request.QueryOrderRequest;
import com.example.business.area.mapper.AreaMapper;
import com.example.business.area.service.AreaService;
import com.example.business.area.service.OrderService;
import com.example.business.user.dto.request.QueryUserRequest;
import com.example.business.user.entity.ApiResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/2
 */
@RestController
public class AreaController {
    @Resource
    private AreaService areaService;

    @Resource
    private OrderService orderService;

    //场馆增删改查
    @RequestMapping("/area/add")
    public ApiResult<?> addArea(@RequestBody @Valid AddAreaRequest request) {
        return areaService.addArea(request);
    }

    @RequestMapping("/area/delete/{id}")
    public ApiResult<?> deleteArea(@PathVariable Long id) {
        return areaService.deleteArea(id);
    }

    @RequestMapping("/area/update")
    public ApiResult<?> updateArea(@RequestBody @Valid AddAreaRequest request) {
        return areaService.updateArea(request);
    }

    @RequestMapping("/area/query")
    public ApiResult<?> queryArea(@Valid @RequestBody QueryAreaRequest request){
        return areaService.queryArea(request);
    }

    //场馆预约操作
    @RequestMapping("/order_area")
    public ApiResult<?> orderArea(@RequestBody @Valid OrderAreaRequest request) {
        return orderService.orderArea(request);
    }

    //取消预约
    @RequestMapping("/delete_order_area")
    public ApiResult<?> deleteOrderArea(@RequestBody @Valid OrderAreaRequest request) {
        return orderService.deleteOrderArea(request);
    }

    //预约信息分页查询
    @RequestMapping("/query_order")
    public ApiResult<?> queryOrder(@Valid @RequestBody QueryOrderRequest request){
        return orderService.queryOrder(request);
    }
}
