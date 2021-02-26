package com.xiaobaichuan.zhixuan.community.service;

import com.xiaobaichuan.zhixuan.community.entity.Review;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface IReviewService extends IService<Review> {

    List<Review> getreview(Integer postid);

    Review addreview(String reopenid, Integer postid, String content);

    Review addreply(String reopenid, Integer postid, String content, String prinickname);

}
