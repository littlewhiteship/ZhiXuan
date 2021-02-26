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
@TableName("t_positioninfo")
public class Positioninfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "listid", type = IdType.AUTO)
    private Integer listid;

    private String search;

    private String position;

    private String time;

    private String academic;

    private String major;

    private String officehour;

    private String salary;

    private String company;

    private String introduction;

    private String relativeinfo;

    private String detailedinfo;

    private String application;

    public Positioninfo() {

    }

    public Positioninfo(String search, String position, String time, String academic, String major, String officehour, String salary, String company, String introduction, String relativeinfo, String detailedinfo, String application) {
        this.search = search;
        this.position = position;
        this.time = time;
        this.academic = academic;
        this.major = major;
        this.officehour = officehour;
        this.salary = salary;
        this.company = company;
        this.introduction = introduction;
        this.relativeinfo = relativeinfo;
        this.detailedinfo = detailedinfo;
        this.application = application;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getListid() {
        return listid;
    }

    public void setListid(Integer listid) {
        this.listid = listid;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAcademic() {
        return academic;
    }

    public void setAcademic(String academic) {
        this.academic = academic;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getOfficehour() {
        return officehour;
    }

    public void setOfficehour(String officehour) {
        this.officehour = officehour;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getRelativeinfo() {
        return relativeinfo;
    }

    public void setRelativeinfo(String relativeinfo) {
        this.relativeinfo = relativeinfo;
    }

    public String getDetailedinfo() {
        return detailedinfo;
    }

    public void setDetailedinfo(String detailedinfo) {
        this.detailedinfo = detailedinfo;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }
}
