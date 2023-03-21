package com.example.business.user.controller;

import com.example.business.user.service.UserService;
import com.example.business.user.dto.request.LoginRequest;
import com.example.business.user.dto.request.QueryUserRequest;
import com.example.business.user.entity.ApiResult;
import com.example.business.user.entity.User;
import com.example.business.user.mapper.UserMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * @Author: liuwenpeng
 * @Date : 2023/2/28
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
    //登录
    @RequestMapping("/login")
    public ApiResult<?> login(@Valid @RequestBody LoginRequest request){
        String salt = "lqq";
        List<User> list = userMapper.find(request.getUsername());
        if(list.size()==0){
            return ApiResult.fail("用户名不存在");
        }
        if(Objects.equals(list.get(0).getPassword(), DigestUtils.sha256Hex(request.getPassword()+ salt))){
            if(!list.get(0).getIsEnable()){
                return ApiResult.fail("用户已禁用");
            }
//            list.get(0).setPassword("****");
            return ApiResult.ok(list.get(0),"登录成功");
        }else {
            return ApiResult.fail("密码错误");
        }
    }
    //添加用户
    @RequestMapping("/add_user")
    public ApiResult<?> addUser(@Valid @RequestBody LoginRequest request){
        return userService.addUser(request);
    }
    //删除用户
    @RequestMapping("/delete_user/{id}")
    public ApiResult<?> deleteUser(@PathVariable String id){
        return userService.deleteUser(id);
    }
    //用户分页查询
    @RequestMapping("/query_user")
    public ApiResult<?> queryUser(@Valid @RequestBody QueryUserRequest request){
        return userService.queryUser(request);
    }
}
