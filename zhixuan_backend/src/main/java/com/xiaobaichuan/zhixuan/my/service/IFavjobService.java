package com.xiaobaichuan.zhixuan.my.service;

import com.xiaobaichuan.zhixuan.homepage.entity.Positioninfo;
import com.xiaobaichuan.zhixuan.my.entity.Favjob;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songyifan
 * @since 2020-08-16
 */
public interface IFavjobService extends IService<Favjob> {

    List<Positioninfo> getfavjob(String openid);

    List<Positioninfo> cancelfavjob(String openid, Integer positionid);

}
