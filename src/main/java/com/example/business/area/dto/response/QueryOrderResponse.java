package com.example.business.area.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
@Getter
@Setter
public class QueryOrderResponse {
    private Long order_id;

    private String area;

    private Long area_id;

    private String user;

    private Long user_id;

    private String time;

    private String day;
}
