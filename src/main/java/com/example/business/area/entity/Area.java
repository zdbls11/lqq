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
    /**
     * 是否启用
     */
    @TableField("`is_enable`")
    private Boolean isEnable = true;
    /**
     * 场馆姓名
     */
    @TableField("`name`")
    private String name;
    /**
     * 备注
     */
    @TableField("`remark`")
    private String remark;
    /**
     * 可用人数
     */
    @TableField("`num`")
    private Integer num;
}
