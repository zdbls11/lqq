package com.example.business.area.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.area.entity.Order;
import com.example.business.area.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {
}
