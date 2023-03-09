package com.example.business.user.service;
import com.example.business.user.dto.response.QueryUserResponse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.user.dto.request.LoginRequest;
import com.example.business.user.dto.request.QueryUserRequest;
import com.example.business.user.entity.ApiResult;
import com.example.business.user.entity.User;
import com.example.business.user.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuwenpeng
 * @Date : 2023/2/28
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Resource
    private UserMapper userMapper;


    public ApiResult<?> addUser(LoginRequest request){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,request.getUsername());
        List<User> list = this.list(wrapper);
        if(!list.isEmpty()) return ApiResult.fail("用户名已存在");
        User user = new User();
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        user.setName(request.getName());
        user.setMobile(request.getMobile());
        user.setIcon(request.getIcon());
        this.save(user);
//        userMapper.insert(user);
        return ApiResult.ok("创建用户成功");
    }

    public ApiResult<?> deleteUser(Integer id){
        this.removeById(id);
        return ApiResult.ok("删除用户成功");
    }

    public ApiResult<?> queryUser(QueryUserRequest request){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if(request.getUsername()!=null){
            wrapper.like(User::getUsername,request.getUsername());
        }
        long count = this.count(wrapper);
        Page<User> page = PageHelper.startPage(request.getPage(),request.getPage_size());
        List<User> users = this.list(wrapper);
        page.close();
        List<QueryUserResponse> responses = new ArrayList<>();
        for(User user:users){
            QueryUserResponse response = new QueryUserResponse();
            response.setMobile(user.getMobile());
            response.setName(user.getName());
            response.setRole(user.getRole());
            response.setUsername(user.getUsername());
            responses.add(response);
        }
        return ApiResult.ok(responses,String.valueOf(count));
    }
}
