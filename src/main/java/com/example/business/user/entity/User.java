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
    /**
     * 用户名
     */
    @TableField("`username`")
    private String username;
    /**
     * 密码
     */
    @TableField("`password`")
    private String password;
    /**
     * 是否启用
     */
    @TableField("`is_enable`")
    private Boolean isEnable = true;
    /**
     * 角色类型： 0：管理员；1：普通用户
     */
    @TableField("`role`")
    private Integer role = 1;
    /**
     * 姓名
     */
    @TableField("`name`")
    private String name;
    /**
     * 电话
     */
    @TableField("`mobile`")
    private String mobile;
    /**
     * 头像
     */
    @TableField("`icon`")
    private Setter icon;
}
