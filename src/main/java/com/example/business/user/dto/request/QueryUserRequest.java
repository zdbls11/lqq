package com.example.business.user.dto.request;

import lombok.Data;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/1
 */
@Data
public class  QueryUserRequest {
    /**
     * 页码
     */
    private Integer page;
    /**
     * 页大小
     */
    private Integer page_size;
    /**
     * 用户名
     */
    private String username;

    private Long id;
}
