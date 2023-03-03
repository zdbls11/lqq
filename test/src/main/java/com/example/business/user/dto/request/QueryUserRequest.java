package com.example.business.user.dto.request;

import lombok.Data;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/1
 */
@Data
public class QueryUserRequest {
    private Integer page;
    private Integer page_size;
    private String username;
}
