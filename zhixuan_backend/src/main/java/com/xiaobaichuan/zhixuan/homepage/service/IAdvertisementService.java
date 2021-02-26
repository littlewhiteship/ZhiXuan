package com.xiaobaichuan.zhixuan.homepage.service;

import com.xiaobaichuan.zhixuan.homepage.entity.Advertisement;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IAdvertisementService extends IService<Advertisement> {
    boolean addadver(String adverurl);
    List<Advertisement> getalladver();
}
