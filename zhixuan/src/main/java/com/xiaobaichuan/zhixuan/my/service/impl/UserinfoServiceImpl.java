package com.xiaobaichuan.zhixuan.my.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xiaobaichuan.zhixuan.my.entity.Userinfo;
import com.xiaobaichuan.zhixuan.my.mapper.UserinfoMapper;
import com.xiaobaichuan.zhixuan.my.service.IUserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements IUserinfoService {

    @Override
    public Userinfo SignIn(String account, String nickname, String image) {
        QueryWrapper<Userinfo>user = new QueryWrapper<>();
        user.eq("openid",account);
        if(getOne(user) == null){
            Userinfo newuser = new Userinfo();
            newuser.setOpenid(account);
            newuser.setNickname(nickname);
            newuser.setImage(image);
            save(newuser);
            return newuser;
        }else {
            return null;
        }
    }

    @Override
    public Userinfo ModifyNickname(String openid, String nickname) {
        QueryWrapper<Userinfo>priuser = new QueryWrapper<>();
        priuser.eq("openid",openid);
        if(getOne(priuser).getNickname().equals(nickname)) {
            return null;
        }
        else{
            UpdateWrapper<Userinfo>newuser = new UpdateWrapper<>();
            newuser.eq("openid",openid).set("nickname",nickname);
            update(newuser);
            QueryWrapper<Userinfo>newnickname = new QueryWrapper<>();
            newnickname.eq("openid",openid);
            Userinfo result = getOne(newnickname);
            return result;
        }
    }


}
