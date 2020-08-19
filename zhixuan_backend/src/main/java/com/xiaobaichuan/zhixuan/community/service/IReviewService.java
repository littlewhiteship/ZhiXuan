package com.xiaobaichuan.zhixuan.community.service;

import com.xiaobaichuan.zhixuan.community.entity.Review;
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
public interface IReviewService extends IService<Review> {

    List<Review> getreview(Integer postid);

    Review addreview(String reopenid, Integer postid, String content);

    Review addreply(String reopenid, Integer postid, String content, String prinickname);

}
