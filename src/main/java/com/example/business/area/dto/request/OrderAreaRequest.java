package com.example.business.area.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
@Getter
@Setter
public class OrderAreaRequest {
    private Long user_id;

    private Long area_id;

    private List<Integer> times;

    private String order_date;

    private Integer num;
}
