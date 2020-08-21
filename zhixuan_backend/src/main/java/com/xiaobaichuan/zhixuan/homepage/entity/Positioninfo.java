package com.xiaobaichuan.zhixuan.homepage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
 * @since 2020-08-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_positioninfo")
public class Positioninfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "listid", type = IdType.AUTO)
    private Integer listid;

    private String time;

    private String academic;

    private String position;

    private String officehour;

    private String company;

    private Integer salary;

    private String introduction;

    private String major;

    private String location;

    private LocalDate starttime;

    private String duty;

    private String command;

    private String email;


}
