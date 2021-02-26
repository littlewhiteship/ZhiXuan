package com.xiaobaichuan.zhixuan.my.service;

import com.xiaobaichuan.zhixuan.my.entity.Cv;
import com.baomidou.mybatisplus.extension.service.IService;


public interface ICvService extends IService<Cv> {

    Cv addcv(String openid, String uname, String gender, String edubg, String major, Integer internship, String grade, String practime, String worktime, String fsttarget, String sndtarget);

    Cv getcv(String openid);
}
