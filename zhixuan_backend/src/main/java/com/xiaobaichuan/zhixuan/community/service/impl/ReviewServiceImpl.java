package com.xiaobaichuan.zhixuan.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobaichuan.zhixuan.community.entity.Review;
import com.xiaobaichuan.zhixuan.community.mapper.ReviewMapper;
import com.xiaobaichuan.zhixuan.community.service.IReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobaichuan.zhixuan.my.entity.Userinfo;
import com.xiaobaichuan.zhixuan.my.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements IReviewService {

    @Autowired
    private IUserinfoService iUserinfoService;

    @Override
    public List<Review> getreview(Integer postid) {
        QueryWrapper<Review>reviewQueryWrapper = new QueryWrapper<>();
        reviewQueryWrapper.eq("postid",postid).orderByDesc("reviewid");
        return list(reviewQueryWrapper);
    }

    @Override
    public Review addreview(String reopenid, Integer postid, String content) {
        Review newreview = new Review();
        newreview.setContent(content);
        newreview.setPostid(postid);
        newreview.setReopenid(reopenid);
        QueryWrapper<Userinfo>userinfoQueryWrapper = new QueryWrapper<>();
        userinfoQueryWrapper.eq("openid",reopenid);
        newreview.setRenickname(iUserinfoService.getOne(userinfoQueryWrapper).getNickname());
        newreview.setRetype("评论");
        save(newreview);
        return newreview;
    }

    @Override
    public Review addreply(String reopenid, Integer postid, String content, String prinickname) {
        Review newreply = new Review();
        newreply.setRetype("回复");
        QueryWrapper<Userinfo>userinfoQueryWrapper = new QueryWrapper<>();
        userinfoQueryWrapper.eq("openid",reopenid);
        newreply.setRenickname(iUserinfoService.getOne(userinfoQueryWrapper).getNickname());
        newreply.setReopenid(reopenid);
        newreply.setPostid(postid);
        newreply.setPrinickname(prinickname);
        newreply.setContent(content);
        save(newreply);
        return newreply;
    }
}
