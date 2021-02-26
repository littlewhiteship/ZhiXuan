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
@TableName("t_favpost")
public class Favpost implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "favpostid", type = IdType.AUTO)
    private Integer favpostid;

    private Integer postid;

    private String openid;

    private LocalDateTime time;

    private String posttitle;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getFavpostid() {
        return favpostid;
    }

    public void setFavpostid(Integer favpostid) {
        this.favpostid = favpostid;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
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

    public String getPosttitle() {
        return posttitle;
    }

    public void setPosttitle(String posttitle) {
        this.posttitle = posttitle;
    }
}
