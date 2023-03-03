package com.example.business.area.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/2
 */
@TableName("`area`")
@Getter
@Setter
public class Area implements Serializable {
    @TableId(value = "`id`", type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("`is_enable`")
    private Boolean isEnable = true;

    @TableField("`name`")
    private String name;

    @TableField("`remark`")
    private String remark;
}
