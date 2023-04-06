package com.example.business.area.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
@Getter
@Setter
public class QueryOrderResponse {
    @JsonSerialize(using= ToStringSerializer.class)
    private Long order_id;

    private String area;
    @JsonSerialize(using= ToStringSerializer.class)
    private Long area_id;

    private String user;
    @JsonSerialize(using= ToStringSerializer.class)
    private Long user_id;

    private String time;

    private String day;

    private Integer num;
}
