package com.example.business.user.dto.response;

import lombok.Data;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/1
 */
@Data
public class QueryUserResponse {
    private String name;
    private String mobile;
    private Integer role;
    private String username;
}
