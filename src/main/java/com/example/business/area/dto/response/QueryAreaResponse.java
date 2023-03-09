package com.example.business.area.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
@Getter
@Setter
public class QueryAreaResponse{
    private Long id;

    private String name;

    private String remark;

    private Integer num;

    private List<String> icons;

    private Boolean is_enable;

}
