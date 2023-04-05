package com.example.business.user.dto.request;
import lombok.Data;

/**
 * @Author: liuwenpeng
 * @Date : 2023/2/28
 */
@Data
public class UpdateRequest {
    /**
     * id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 当前密码
     */
    private String old_password;
    /**
     * 新密码
     */
    private String new_password;

    //头像
    private String icon;

    //姓名
    private String name;

    //手机号
    private String mobile;

}
