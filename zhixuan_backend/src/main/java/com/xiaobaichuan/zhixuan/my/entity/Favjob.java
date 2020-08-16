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
@TableName("t_favjob")
public class Favjob implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "favjobid", type = IdType.AUTO)
    private Integer favjobid;

    private Integer positionid;

    private String openid;

    private LocalDateTime time;

    private String positiontype;


}
