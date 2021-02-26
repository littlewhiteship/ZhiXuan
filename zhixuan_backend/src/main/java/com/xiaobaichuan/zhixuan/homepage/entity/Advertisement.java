package com.xiaobaichuan.zhixuan.homepage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_advertisement")
public class Advertisement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "adverid", type = IdType.AUTO)
    private Integer adverid;

    private String adverurl;

    public Advertisement(String adverurl) {
        this.adverurl = adverurl;
    }
}
