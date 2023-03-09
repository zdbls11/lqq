package com.example.business.area.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.area.entity.Message;
import com.example.business.area.mapper.MessageMapper;
import org.springframework.stereotype.Service;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
@Service
public class MessageService extends ServiceImpl<MessageMapper, Message> {
}
