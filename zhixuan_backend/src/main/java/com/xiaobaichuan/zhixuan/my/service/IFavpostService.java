package com.xiaobaichuan.zhixuan.my.service;

import com.xiaobaichuan.zhixuan.community.entity.Post;
import com.xiaobaichuan.zhixuan.my.entity.Favpost;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface IFavpostService extends IService<Favpost> {

    List<Post> getfavpost(String openid);

    List<Post> cancelfavpost(String openid, Integer postid);

    List<Favpost> addfavpost(String openid, Integer postid);

    boolean ifaddfav(String openid, Integer postid);

}
