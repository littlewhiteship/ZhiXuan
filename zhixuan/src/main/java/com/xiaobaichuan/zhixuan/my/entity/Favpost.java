package com.xiaobaichuan.zhixuan.my.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("t_favpost")
public class Favpost implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "favpostid", type = IdType.AUTO)
    private Integer favpostid;

    private Integer postid;

    private String openid;

    private LocalDateTime time;

    private String posttitle;


}
