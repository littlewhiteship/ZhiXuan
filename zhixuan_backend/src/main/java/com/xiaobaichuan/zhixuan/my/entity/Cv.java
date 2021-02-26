package com.xiaobaichuan.zhixuan.my.entity;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCvid() {
        return cvid;
    }

    public void setCvid(Integer cvid) {
        this.cvid = cvid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEdubg() {
        return edubg;
    }

    public void setEdubg(String edubg) {
        this.edubg = edubg;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getInternship() {
        return internship;
    }

    public void setInternship(Integer internship) {
        this.internship = internship;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPractime() {
        return practime;
    }

    public void setPractime(String practime) {
        this.practime = practime;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getFsttarget() {
        return fsttarget;
    }

    public void setFsttarget(String fsttarget) {
        this.fsttarget = fsttarget;
    }

    public String getSndtarget() {
        return sndtarget;
    }

    public void setSndtarget(String sndtarget) {
        this.sndtarget = sndtarget;
    }
}
