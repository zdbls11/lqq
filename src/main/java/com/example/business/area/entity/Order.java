package com.example.business.area.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/9
 */
@TableName("`order`")
@Getter
@Setter
public class Order implements Serializable {

    @TableId(value = "`id`", type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 预约人id
     */
    @TableField("`user_id`")
    private Long userId ;
    /**
     * 场馆id
     */
    @TableField("`area_id`")
    private Long areaId;
    /**
     * 预约开始时间
     */
    @TableField("`begin_date`")
    private Date beginDate;
    /**
     * 预约结束时间
     */
    @TableField("`end_date`")
    private Date endDate;
    /**
     * 预约人数
     */
    @TableField("`num`")
    private Integer num;
}
