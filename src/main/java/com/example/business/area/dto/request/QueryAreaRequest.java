package com.example.business.area.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
@Getter
@Setter
public class QueryAreaRequest {
    private String name;

    private Integer max;

    private Integer min;

    private Integer is_enable;

    private Integer page;

    private Integer page_size;
}
