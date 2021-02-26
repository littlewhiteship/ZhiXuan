package com.xiaobaichuan.zhixuan.my.service;

//import com.xiaobaichuan.zhixuan.homepage.entity.Positioninfo;
import com.xiaobaichuan.zhixuan.homepage.entity.Positioninfo;
import com.xiaobaichuan.zhixuan.my.entity.Favjob;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface IFavjobService extends IService<Favjob> {


    List<Positioninfo> getfavjob(String openid);

    List<Positioninfo> cancelfavjob(String openid, Integer positionid);

    Favjob addfavpos(int positionid, String openid, String positiontype);

    boolean isExist(int positionid,String openid);
    //true表示未存过可存，false表示已经存过
}
