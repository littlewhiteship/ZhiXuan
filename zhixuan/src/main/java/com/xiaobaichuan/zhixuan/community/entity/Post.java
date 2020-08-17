package com.xiaobaichuan.zhixuan.community.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author songyifan
 * @since 2020-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "postid", type = IdType.AUTO)
    private Integer postid;

    private String openid;

    private String image;

    private String nickname;

    private String title;

    private String content;


}
