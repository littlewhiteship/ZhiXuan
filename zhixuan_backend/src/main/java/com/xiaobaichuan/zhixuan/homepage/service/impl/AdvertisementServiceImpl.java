package com.xiaobaichuan.zhixuan.homepage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobaichuan.zhixuan.homepage.entity.Advertisement;
import com.xiaobaichuan.zhixuan.homepage.mapper.AdvertisementMapper;
import com.xiaobaichuan.zhixuan.homepage.service.IAdvertisementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdvertisementServiceImpl extends ServiceImpl<AdvertisementMapper, Advertisement> implements IAdvertisementService {
    @Override
    public boolean addadver(String adverurl) {

        return true;
    }

    @Override
    public List<Advertisement> getalladver() {
        QueryWrapper<Advertisement> queryWrapper = new QueryWrapper<>();
        List<Advertisement> advertisementList = list(queryWrapper);
        return advertisementList;
    }
}
