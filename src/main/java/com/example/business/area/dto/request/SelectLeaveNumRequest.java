package com.example.business.area.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/11
 */
@Getter
@Setter
public class SelectLeaveNumRequest {
    private Long area_id;

    private String date;
}
