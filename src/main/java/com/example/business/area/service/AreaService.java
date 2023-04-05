package com.example.business.area.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.area.dto.request.AddAreaRequest;
import com.example.business.area.dto.request.QueryAreaRequest;
import com.example.business.area.dto.response.QueryAreaResponse;
import com.example.business.area.entity.Area;
import com.example.business.area.entity.AreaIcon;
import com.example.business.area.mapper.AreaMapper;
import com.example.business.user.entity.ApiResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/2
 */
@Service
public class AreaService extends ServiceImpl<AreaMapper, Area> {

    @Resource
    private AreaMapper areaMapper;

    @Resource
    private AreaIconService areaIconService;

    @Resource
    private OrderService orderService;

    @Resource
    private MessageService messageService;

    public Boolean is_not_null(String string){
        return string != null && !string.equals("");
    }

    @Transactional
    public ApiResult<?> addArea(AddAreaRequest request) {
        //判断场馆是否存在
        LambdaQueryWrapper<Area> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Area::getName, request.getName());
        if (this.list(wrapper).size() > 0) return ApiResult.fail("场馆已存在");

        //保存场馆信息
        Area area = new Area();
        area.setName(request.getName());
        area.setIsEnable(request.getIs_enable());
        area.setRemark(request.getRemark());
        area.setNum(request.getNum());
        this.save(area);

        //保存场馆图片信息
        if (request.getIcons() != null && request.getIcons().size() > 0) {
            List<AreaIcon> areaIconList = new ArrayList<>();
            int i = 1;
            for (String icon : request.getIcons()) {
                AreaIcon areaIcon = new AreaIcon();
                areaIcon.setIcon(icon);
                areaIcon.setAreaId(area.getId());
                areaIcon.setSort(i);
                areaIconList.add(areaIcon);
                i++;
            }
            if (!areaIconList.isEmpty()) {
                areaIconService.saveBatch(areaIconList);
            }
        }
        return ApiResult.ok("添加场馆信息成功");
    }

    @Transactional
    public ApiResult<?> deleteArea(Long id) {
        //删除场馆图片信息
        LambdaQueryWrapper<AreaIcon> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AreaIcon::getAreaId, id);
        areaIconService.remove(wrapper);
        //删除场馆信息
        LambdaQueryWrapper<Area> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(Area::getId, id);
        this.remove(wrapper1);
        return ApiResult.ok("删除场馆信息成功");
    }

    @Transactional
    public ApiResult<?> updateArea(AddAreaRequest request) {
        //判断场馆是否存在
        LambdaQueryWrapper<Area> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Area::getId, request.getId());
        if (this.list(wrapper).size() != 1) return ApiResult.fail("场馆不存在");

        //保存场馆信息
        Area area = this.getOne(wrapper);
        if (request.getName() != null) area.setName(request.getName());
        if (request.getIs_enable() != null) area.setIsEnable(request.getIs_enable());
        if (request.getRemark() != null) area.setRemark(request.getRemark());
        if (request.getNum() != null) area.setNum(request.getNum());
        this.updateById(area);

        if (request.getIcons() != null && request.getIcons().size() > 0) {
            //保存场馆图片信息
            LambdaQueryWrapper<AreaIcon> wrapper1 = new LambdaQueryWrapper<>();
            wrapper1.eq(AreaIcon::getAreaId, request.getId());
            areaIconService.remove(wrapper1);

            List<AreaIcon> areaIconList = new ArrayList<>();
            int i = 1;
            for (String icon : request.getIcons()) {
                AreaIcon areaIcon = new AreaIcon();
                areaIcon.setIcon(icon);
                areaIcon.setAreaId(area.getId());
                areaIcon.setSort(i);
                areaIconList.add(areaIcon);
                i++;
            }
            if (!areaIconList.isEmpty()) {
                areaIconService.saveBatch(areaIconList);
            }
        }

        return ApiResult.ok("修改场馆信息成功");
    }

    public ApiResult<?> queryArea(QueryAreaRequest request) {
        LambdaQueryWrapper<Area> wrapper = new LambdaQueryWrapper<>();
        if (this.is_not_null(request.getName())) {
            wrapper.like(Area::getName, request.getName());
        }
        if (request.getMax() != null) {
            wrapper.lt(Area::getNum, request.getMax());
        }
        if (request.getMin() != null) {
            wrapper.gt(Area::getNum, request.getMin());
        }
        if (request.getIs_enable() != null) {
            wrapper.eq(Area::getIsEnable, request.getIs_enable());
        }
        Page<Area> page = PageHelper.startPage(request.getPage(), request.getPage_size());
        PageInfo<Area> list = PageInfo.of(this.list(wrapper));
        page.close();
        List<QueryAreaResponse> responses = new ArrayList<>();
        for (Area area : list.getList()) {
            QueryAreaResponse response = new QueryAreaResponse();
            response.setId(area.getId());
            response.setName(area.getName());
            response.setNum(area.getNum());
            response.setIs_enable(area.getIsEnable());
            response.setIcons(areaMapper.findIcon(area.getId()));
            responses.add(response);
        }
        return ApiResult.ok(responses, String.valueOf(list.getTotal()));
    }
}
