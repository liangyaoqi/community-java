package com.lyq.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 帖子表
 *
 * @TableName sys_post
 */
@TableName(value = "sys_post")
@Data
@EqualsAndHashCode
public class Post implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 发帖人ID，外键关联用户表
     */
    private String userId;

    /**
     * 发帖时间
     */
    private Date createdAt;

    /**
     * 外部关联属性
     * 用户信息
     */
    @TableField(exist = false)
    private UserInfo userInfo;


    /**
     * 外部关联属性
     * 评论信息
     */
    @TableField(exist = false)
    private List<Comment> comments;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}