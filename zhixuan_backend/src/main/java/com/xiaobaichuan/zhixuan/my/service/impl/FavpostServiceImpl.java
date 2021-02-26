package com.xiaobaichuan.zhixuan.my.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobaichuan.zhixuan.community.entity.Post;
import com.xiaobaichuan.zhixuan.community.service.IPostService;
import com.xiaobaichuan.zhixuan.my.entity.Favpost;
import com.xiaobaichuan.zhixuan.my.mapper.FavpostMapper;
import com.xiaobaichuan.zhixuan.my.service.IFavpostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class FavpostServiceImpl extends ServiceImpl<FavpostMapper, Favpost> implements IFavpostService {

    @Autowired
    private IPostService iPostService;

    @Override
    public List<Post> getfavpost(String openid) {
        QueryWrapper<Favpost>favpostQueryWrapper = new QueryWrapper<>();
        favpostQueryWrapper.eq("openid",openid).orderByDesc("favpostid");
        int num = list(favpostQueryWrapper).size();
        List<Favpost>favpost = list(favpostQueryWrapper);
        List<Post>result = new ArrayList<>();
        if(num != 0) {
            Post temp = new Post();
            for (int i = 0; i < num; i++) {
                temp = iPostService.getById(favpost.get(i).getPostid());
                result.add(temp);
            }
        }
        return result;
    }

    @Override
    public List<Post> cancelfavpost(String openid, Integer postid) {
        QueryWrapper<Favpost>favpostQueryWrapper = new QueryWrapper<>();
        favpostQueryWrapper.eq("openid",openid).eq("postid",postid);
        remove(favpostQueryWrapper);
        return getfavpost(openid);
    }

    @Override
    public List<Favpost> addfavpost(String openid, Integer postid) {
        Favpost newfavpost = new Favpost();
        newfavpost.setOpenid(openid);
        newfavpost.setPostid(postid);
        newfavpost.setPosttitle(iPostService.getById(postid).getTitle());
        newfavpost.setTime(LocalDateTime.now());
        save(newfavpost);
        QueryWrapper<Favpost> favpostQueryWrapper = new QueryWrapper<>();
        favpostQueryWrapper.eq("openid",openid).orderByDesc("favpostid");
        return list(favpostQueryWrapper);
    }

    @Override
    public boolean ifaddfav(String openid, Integer postid) {
        QueryWrapper<Favpost>favpostQueryWrapper = new QueryWrapper<>();
        favpostQueryWrapper.eq("openid",openid).eq("postid",postid);
        int num = list(favpostQueryWrapper).size();
        if (num == 0)
        {
            return false;
        }else{
            return true;
        }
    }
}