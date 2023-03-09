package com.example.business.area.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.business.area.dto.request.QueryOrderRequest;
import com.example.business.area.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    @SelectProvider(value = SqlProvideOrder.class,method = "queryOrder")
    List<Order>queryOrder(QueryOrderRequest request);

}
