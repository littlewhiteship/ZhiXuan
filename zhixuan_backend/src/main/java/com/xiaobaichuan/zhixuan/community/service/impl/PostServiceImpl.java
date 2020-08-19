package com.xiaobaichuan.zhixuan.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobaichuan.zhixuan.community.entity.Post;
import com.xiaobaichuan.zhixuan.community.mapper.PostMapper;
import com.xiaobaichuan.zhixuan.community.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobaichuan.zhixuan.my.entity.Userinfo;
import com.xiaobaichuan.zhixuan.my.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songyifan
 * @since 2020-08-16
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

    @Autowired
    private IUserinfoService iUserinfoService;

    @Override
    public List<Post> getpostlist() {
        QueryWrapper<Post> postQueryWrapper = new QueryWrapper<>();
        postQueryWrapper.orderByDesc("postid");
        return list(postQueryWrapper);
    }

    @Override
    public Post posting(String openid,String title,String content){
        Post newpost = new Post();
        QueryWrapper<Userinfo> userinfoQueryWrapper = new QueryWrapper<>();
        userinfoQueryWrapper.eq("openid",openid);
        newpost.setOpenid(openid);
        newpost.setNickname(iUserinfoService.getOne(userinfoQueryWrapper).getNickname());
        newpost.setImage(iUserinfoService.getOne(userinfoQueryWrapper).getImage());
        newpost.setTitle(title);
        newpost.setContent(content);
        save(newpost);
        return newpost;
    }

    @Override
    public Post getpostdetail(Integer postid) {
        return getById(postid);
    }


}