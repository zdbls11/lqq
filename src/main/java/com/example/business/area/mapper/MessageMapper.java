package com.example.business.area.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.business.area.entity.Message;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}
