package com.xiaobaichuan.zhixuan.my.service;

import com.xiaobaichuan.zhixuan.my.entity.Userinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songyifan
 * @since 2020-08-16
 */
public interface IUserinfoService extends IService<Userinfo> {

    Userinfo SignIn(String account, String nickname, String image);

    Userinfo ModifyNickname(String openid, String nickname);
}
