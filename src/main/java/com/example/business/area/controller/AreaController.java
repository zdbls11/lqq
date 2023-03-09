package com.example.business.area.controller;

import com.example.business.area.dto.request.AddAreaRequest;
import com.example.business.area.dto.request.QueryAreaRequest;
import com.example.business.area.mapper.AreaMapper;
import com.example.business.area.service.AreaService;
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
    private AreaMapper areaMapper;

    @RequestMapping("/area/add")
    public ApiResult<?> addArea(@RequestBody @Valid AddAreaRequest request) {
        return areaService.addArea(request);
    }

    @RequestMapping("/area/delete/#{id}")
    public ApiResult<?> deleteArea(@PathVariable Long id) {
        return areaService.deleteArea(id);
    }

    @RequestMapping("/area/update")
    public ApiResult<?> updateArea(@RequestBody @Valid AddAreaRequest request) {
        return areaService.updateArea(request);
    }

    //场馆分页查询
    @RequestMapping("/area/query")
    public ApiResult<?> queryArea(@Valid @RequestBody QueryAreaRequest request){
        return areaService.queryArea(request);
    }
}
