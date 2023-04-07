package com.example.business.user.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
    private Boolean is_enable;
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;
}
