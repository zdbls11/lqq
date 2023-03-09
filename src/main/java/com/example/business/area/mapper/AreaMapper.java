package com.example.business.area.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.business.area.entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @Author: liuwenpeng
 * @Date : 2023/3/2
 */
@Mapper
public interface AreaMapper extends BaseMapper<Area> {
    @Select("select area_icon.icon from area_icon,area where area_icon.area_id = area.id and area.id = #{id}")
    List<String> findIcon(Long id);
}
