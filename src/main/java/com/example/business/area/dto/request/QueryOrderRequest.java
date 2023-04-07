package com.example.business.area.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
@Getter
@Setter
public class QueryOrderRequest {
    private String area;

    private Integer time;

    private String day;

    private String user;

    private Integer page;

    private Integer page_size;

    private Integer role;

    private Long user_id;

    //true 为查历史，false为查当天以及之后的预约信息
    private Boolean is_history = false;
}
