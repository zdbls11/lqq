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
 * @Date : 2023/3/8
 */
@TableName("`area_icon`")
@Getter
@Setter
public class AreaIcon implements Serializable {

    @TableId(value = "`id`", type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 是否启用
     */
    @TableField("`area_id`")
    private Boolean isEnable = true;
    /**
     * 场馆图片路径
     */
    @TableField("`icon`")
    private String icon;
    /**
     * 排序
     */
    @TableField("`sort`")
    private String sort;
}
