package com.example.business.area.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.area.dto.request.MessageRequest;
import com.example.business.area.entity.Message;
import com.example.business.area.mapper.MessageMapper;
import com.example.business.user.entity.ApiResult;
import org.springframework.stereotype.Service;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
@Service
public class MessageService extends ServiceImpl<MessageMapper, Message> {
    public ApiResult<?> selectMessage() {
        Message message = this.getById(1L);
        if (message == null) {
            message = new Message();
            message.setId(1L);
            message.setMessage("暂无公告");
            this.save(message);
        }
        return ApiResult.ok(message);
    }

    public void updateMessage(MessageRequest request) {
        Message byId = this.getById(1L);
        byId.setMessage(request.getMessage());
        this.updateById(byId);
        ApiResult.ok();
    }
}
