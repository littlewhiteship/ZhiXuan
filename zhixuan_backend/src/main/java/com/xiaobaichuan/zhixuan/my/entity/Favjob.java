package com.xiaobaichuan.zhixuan.my.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_favjob")
public class Favjob implements Serializable {

    public Favjob(Integer positionid, String openid, LocalDateTime time, String positiontype) {
        this.positionid = positionid;
        this.openid = openid;
        this.time = time;
        this.positiontype = positiontype;
    }

    private static final long serialVersionUID = 1L;

    @TableId(value = "favjobid", type = IdType.AUTO)
    private Integer favjobid;

    private Integer positionid;

    private String openid;

    private LocalDateTime time;

    private String positiontype;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getFavjobid() {
        return favjobid;
    }

    public void setFavjobid(Integer favjobid) {
        this.favjobid = favjobid;
    }

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getPositiontype() {
        return positiontype;
    }

    public void setPositiontype(String positiontype) {
        this.positiontype = positiontype;
    }
}
