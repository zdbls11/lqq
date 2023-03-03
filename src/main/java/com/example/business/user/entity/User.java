package com.example.business.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mysql.cj.jdbc.Blob;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: liuwenpeng
 * @Date : 2023/2/28
 */
@TableName("`user`")
@Getter
@Setter
public class User implements Serializable {
    @TableId(value = "`id`", type = IdType.ASSIGN_ID)
    private Long id;
    @TableField("`username`")
    private String username;
    @TableField("`password`")
    private String password;
    @TableField("`is_enable`")
    private Boolean isEnable = true;
    @TableField("`role`")
    private Integer role = 1;
    @TableField("`name`")
    private String name;
    @TableField("`mobile`")
    private String mobile;
    @TableField("`icon`")
    private Blob icon;
}
