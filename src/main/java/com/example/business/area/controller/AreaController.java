package com.example.business.area.controller;

import com.example.business.area.entity.Area;
import com.example.business.area.mapper.AreaMapper;
import com.example.business.area.service.AreaService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/2
 */
@RestController
public class AreaController {
//好诶
    @Resource
    private AreaService areaService;

    @Resource
    private AreaMapper areaMapper;


}
