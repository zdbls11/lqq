package com.example.business.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.business.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * @Author: liuwenpeng
 * @Date : 2023/2/28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from `user` where username = #{username} ")
    List<User> find(String username);
}
