package com.example.business.user.dto.request;
import com.mysql.cj.jdbc.Blob;
import lombok.Data;

/**
 * @Author: liuwenpeng
 * @Date : 2023/2/28
 */
@Data
public class LoginRequest {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 真实姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 图片地址
     */
    private String icon;
}
