package com.xiaobaichuan.zhixuan.community.service.impl;

import com.xiaobaichuan.zhixuan.community.entity.Post;
import com.xiaobaichuan.zhixuan.community.mapper.PostMapper;
import com.xiaobaichuan.zhixuan.community.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}