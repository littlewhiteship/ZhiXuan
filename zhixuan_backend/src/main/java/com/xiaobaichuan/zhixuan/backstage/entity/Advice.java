package com.xiaobaichuan.zhixuan.backstage.entity;

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
 * @since 2020-08-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_advice")
public class Advice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "adviceid", type = IdType.AUTO)
    private Integer adviceid;

    private String nickname;

    private String content;

    private LocalDateTime time;


}
