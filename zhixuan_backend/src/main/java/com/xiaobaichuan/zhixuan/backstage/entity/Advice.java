package com.xiaobaichuan.zhixuan.backstage.entity;

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
@TableName("t_advice")
public class Advice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "adviceid", type = IdType.AUTO)
    private Integer adviceid;

    private String nickname;

    private String content;

    private LocalDateTime time;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAdviceid() {
        return adviceid;
    }

    public void setAdviceid(Integer adviceid) {
        this.adviceid = adviceid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
