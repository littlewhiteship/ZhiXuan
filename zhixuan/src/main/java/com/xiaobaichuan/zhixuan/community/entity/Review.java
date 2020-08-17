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
@TableName("t_review")
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "reviewid", type = IdType.AUTO)
    private Integer reviewid;

    private Integer postid;

    private String reopenid;

    private String renickname;

    private String content;

    private String retype;

    private String prinickname;


}
