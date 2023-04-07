package com.example.business.area.controller;

import com.example.business.area.dto.request.*;
import com.example.business.area.service.AreaService;
import com.example.business.area.service.MessageService;
import com.example.business.area.service.OrderService;
import com.example.business.user.entity.ApiResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.ParseException;

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

    @Resource
    private MessageService messageService;

    //场馆增删改查 Post Get Put Patch Delete
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
    public ApiResult<?> orderArea(@RequestBody @Valid OrderAreaRequest request) throws ParseException {
        return orderService.orderArea(request);
    }

    //取消预约
    @RequestMapping("/delete_order_area")
    public ApiResult<?> deleteOrderArea(@RequestBody @Valid OrderAreaRequest request) {
        return orderService.deleteOrderArea(request);
    }
    //取消预约
    @RequestMapping("/delete_order/{id}")
    public ApiResult<?> deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
    //预约信息分页查询
    @RequestMapping("/query_order")
    public ApiResult<?> queryOrder(@Valid @RequestBody QueryOrderRequest request){
        return orderService.queryOrder(request);
    }

    //查询场馆当前可预约人数
    @RequestMapping("/select_leave_num")
    public ApiResult<?> selectLeaveNum(@Valid @RequestBody SelectLeaveNumRequest request){
        return orderService.selectLeaveNum(request);
    }

    //查询公告
    @RequestMapping("/select_message")
    public ApiResult<?> selectMessage(){
        return messageService.selectMessage();
    }

    //修改公告
    @RequestMapping("/update_message")
    public ApiResult<?> updateMessage(@Valid @RequestBody MessageRequest request){
        messageService.updateMessage(request);
         return ApiResult.ok();
    }
}
