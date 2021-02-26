package com.xiaobaichuan.zhixuan.community.service;

import com.xiaobaichuan.zhixuan.community.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface IPostService extends IService<Post> {

    List<Post> getpostlist();

    Post posting(String openid, String title, String content);

    Post getpostdetail(Integer postid);

}
