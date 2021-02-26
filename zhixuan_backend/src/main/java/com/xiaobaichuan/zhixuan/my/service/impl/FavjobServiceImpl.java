package com.xiaobaichuan.zhixuan.my.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.xiaobaichuan.zhixuan.homepage.entity.Positioninfo;
import com.xiaobaichuan.zhixuan.homepage.service.IPositioninfoService;
import com.xiaobaichuan.zhixuan.my.entity.Favjob;
import com.xiaobaichuan.zhixuan.my.mapper.FavjobMapper;
import com.xiaobaichuan.zhixuan.my.service.IFavjobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class FavjobServiceImpl extends ServiceImpl<FavjobMapper, Favjob> implements IFavjobService {


    @Autowired
    private IPositioninfoService iPositioninfoService;

    @Override
    public List<Positioninfo> getfavjob(String openid) {
        QueryWrapper<Favjob>favjobQueryWrapper = new QueryWrapper<>();
        favjobQueryWrapper.eq("openid",openid);
        List<Favjob> favjobs = list(favjobQueryWrapper);
        int num = favjobs.size();
        List<Positioninfo>result = new ArrayList<>();
        if(num != 0) {
            for (int i = 0; i < num; i++) {
                Positioninfo temp = iPositioninfoService.getById(favjobs.get(i).getPositionid());
                result.add(temp);
            }
        }
        return result;
    }

    @Override
    public List<Positioninfo> cancelfavjob(String openid, Integer positionid) {
        QueryWrapper<Favjob>favjobQueryWrapper = new QueryWrapper<>();
        favjobQueryWrapper.eq("openid",openid).eq("positionid",positionid);
        remove(favjobQueryWrapper);
        return getfavjob(openid);
    }

    @Override
    public Favjob addfavpos(int positionid, String openid, String positiontype) {

        LocalDateTime localDateTime = LocalDateTime.now();
        Favjob favjob = new Favjob(positionid,openid,localDateTime,positiontype);
        save(favjob);
        return favjob;
    }

    @Override
    public boolean isExist(int positionid,String openid) {
        QueryWrapper<Favjob> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("openid",openid).eq("positionid",positionid);
        List<Favjob> favjobList = list(queryWrapper);
        if (favjobList==null){
            //未存入
            return true;
        }
        return false;
    }


}
