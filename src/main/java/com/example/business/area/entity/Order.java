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
     * 预约日期
     */
    @TableField("`order_date`")
    private Date orderDate;
    /**
     * 预约时间段
     */
    @TableField("`time`")
    private Integer time;
    /**
     * 预约人数
     */
    @TableField("`num`")
    private Integer num;
}
