package com.example.business.area.dto.request;

import com.mysql.cj.jdbc.Blob;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
@Getter
@Setter
public class AddAreaRequest {
    private Long id;

    private String name;

    private String remark;

    private Integer num;

    private Boolean is_enable;

    private List<String> icons;
}
