package com.xiaobaichuan.zhixuan.community.entity;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getReviewid() {
        return reviewid;
    }

    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public String getReopenid() {
        return reopenid;
    }

    public void setReopenid(String reopenid) {
        this.reopenid = reopenid;
    }

    public String getRenickname() {
        return renickname;
    }

    public void setRenickname(String renickname) {
        this.renickname = renickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRetype() {
        return retype;
    }

    public void setRetype(String retype) {
        this.retype = retype;
    }

    public String getPrinickname() {
        return prinickname;
    }

    public void setPrinickname(String prinickname) {
        this.prinickname = prinickname;
    }
}
