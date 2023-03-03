package com.example.business.user.dto.request;
import com.mysql.cj.jdbc.Blob;
import lombok.Data;

/**
 * @Author: liuwenpeng
 * @Date : 2023/2/28
 */
@Data
public class LoginRequest {
    private String username;

    private String password;

    private String name;

    private String mobile;

    private Blob icon;
}
