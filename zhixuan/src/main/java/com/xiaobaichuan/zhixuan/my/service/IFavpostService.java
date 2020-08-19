package com.xiaobaichuan.zhixuan.my.service;

import com.xiaobaichuan.zhixuan.community.entity.Post;
import com.xiaobaichuan.zhixuan.my.entity.Favpost;
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
public interface IFavpostService extends IService<Favpost> {

    List<Post> getfavpost(String openid);

    List<Post> cancelfavpost(String openid, Integer postid);

}
