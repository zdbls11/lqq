package com.example.business.area.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.area.entity.Area;
import com.example.business.area.mapper.AreaMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/2
 */
@Service
public class AreaService extends ServiceImpl<AreaMapper, Area> {

    @Resource
    private AreaMapper areaMapper;


}
