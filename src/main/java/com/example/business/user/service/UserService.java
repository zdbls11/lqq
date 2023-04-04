package com.example.business.user.service;
import com.example.business.user.dto.request.UpdateRequest;
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
import com.github.pagehelper.PageInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: liuwenpeng
 * @Date : 2023/2/28
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Resource
    private UserMapper userMapper;
    String salt = "lqq";

    public ApiResult<?> addUser(LoginRequest request){
        //mybatis plus的使用
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,request.getUsername());//select xxx from user where username = #{username}
        List<User> list = this.list(wrapper);//select xxx from user  where username = #{username}
        if(!list.isEmpty()) return ApiResult.fail("用户名已存在");
        User user = new User();
        //通过盐值对密码进行加密处理

        user.setPassword(DigestUtils.sha256Hex(request.getPassword()+ this.salt));
        user.setUsername(request.getUsername());
        user.setName(request.getName());
        user.setMobile(request.getMobile());
        user.setIcon(request.getIcon());
        this.save(user);
        return ApiResult.ok("创建用户成功");
    }

    public ApiResult<?> deleteUser(String id){
        this.removeById(id);
        return ApiResult.ok("删除用户成功");
    }

    public ApiResult<?> queryUser(QueryUserRequest request){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if(request.getUsername()!=null){
            wrapper.like(User::getUsername,request.getUsername());
        }
        if(request.getId()!=null){
            wrapper.like(User::getId,request.getId());
        }
        Page<User> page = PageHelper.startPage(request.getPage(),request.getPage_size());
        PageInfo<User> users =PageInfo.of( this.list(wrapper));
        page.close();
        List<QueryUserResponse> responses = new ArrayList<>();
        for(User user:users.getList()){
            QueryUserResponse response = new QueryUserResponse();
            response.setMobile(user.getMobile());
            response.setName(user.getName());
            response.setRole(user.getRole());
            response.setUsername(user.getUsername());
            response.setId(user.getId());
            responses.add(response);
        }
        return ApiResult.ok(responses,String.valueOf(users.getTotal()));
    }

    public ApiResult<?> updateUser(UpdateRequest request){
        User user = this.getById(request.getId());
        //修改密码
        if(request.getOld_password()!=null&&request.getNew_password()!=null){
            if(!Objects.equals(user.getPassword(), DigestUtils.sha256Hex(request.getOld_password() + this.salt))){
                return ApiResult.fail("旧密码输入错误");
            }
            if(Objects.equals(request.getOld_password(), request.getNew_password())){
                return ApiResult.fail("新旧密码不能相同");
            }
            user.setPassword(DigestUtils.sha256Hex(request.getNew_password() + this.salt));
        }
        //修改头像
        if(request.getIcon()!=null){
            user.setIcon(request.getIcon());
        }

        this.updateById(user);
        return ApiResult.ok("修改成功");
    }
}
