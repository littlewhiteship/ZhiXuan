package com.xiaobaichuan.zhixuan.my.entity;

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
@TableName("t_cv")
public class Cv implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cvid", type = IdType.AUTO)
    private Integer cvid;

    private String openid;

    private String uname;

    private String gender;

    private String edubg;

    private String major;

    private Integer internship;

    private String grade;

    private String practime;

    private String worktime;

    private String fsttarget;

    private String sndtarget;


}
