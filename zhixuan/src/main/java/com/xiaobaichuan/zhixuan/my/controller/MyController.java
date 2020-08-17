package com.xiaobaichuan.zhixuan.my.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobaichuan.zhixuan.my.entity.Userinfo;
import com.xiaobaichuan.zhixuan.my.service.IUserinfoService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author songyifan
 * @since 2020-08-16
 */
@RestController
@RequestMapping("/my")
public class MyController {

    @Autowired
    private IUserinfoService iUserinfoService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public JSONObject register(String account,String nickname,String image){
        JSONObject jsonObject = new JSONObject();
        try{
            if(account == null || account.equals("")){
                jsonObject.put("errcode","10001");
                jsonObject.put("errmsg","数据传输错误，账号为空");
                return jsonObject;
            }
            if(nickname == null || nickname.equals("")){
                jsonObject.put("errcode","10002");
                jsonObject.put("errmsg","数据传输错误，昵称为空");
                return jsonObject;
            }
            if(image == null || image.equals("")){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","数据传输错误，头像为空");
                return jsonObject;
            }
            Userinfo user = iUserinfoService.SignIn(account,nickname,image);
            if(user==null){
                jsonObject.put("errcode","10005");
                jsonObject.put("errmsg","用户已注册");
                return jsonObject;
            }else{
                jsonObject.put("errcode","0");
                jsonObject.put("data",user);
                return jsonObject;
            }
        }catch (Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","请求失败，发生未知错误");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JSONObject login(String openid){
        JSONObject jsonObject = new JSONObject();
        try{
            if(openid == null || openid.equals("")){
                jsonObject.put("errcode","10001");
                jsonObject.put("errmsg","数据传输错误，账号为空");
                return jsonObject;
            }
            QueryWrapper<Userinfo>user = new QueryWrapper<>();
            user.eq("openid",openid);
            Userinfo newuser =iUserinfoService.getOne(user);
            if (newuser == null){
                jsonObject.put("errcode","10006");
                jsonObject.put("errmsg","登陆失败，该用户尚未注册");
                return jsonObject;
            }
            jsonObject.put("errcode","0");
            jsonObject.put("data",newuser);
        }catch (Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","登陆失败，发生未知错误");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/modifynickname",method = RequestMethod.POST)
    public JSONObject modifynickname(String openid, String nickname) {
        JSONObject jsonObject = new JSONObject();
        try{
            if(openid == null || openid.equals("")){
                jsonObject.put("errcode","10001");
                jsonObject.put("errmsg","数据传输错误，账号为空");
                return jsonObject;
            }
            if(nickname == null || nickname.equals("")){
                jsonObject.put("errcode","10002");
                jsonObject.put("errmsg","修改失败，修改后昵称不能为空。");
                return jsonObject;
            }
            Userinfo newUser = iUserinfoService.ModifyNickname(openid,nickname);
            if(newUser == null){
                jsonObject.put("errcode","10007");
                jsonObject.put("errmsg","改后昵称和原昵称相同，修改失败。");
                return jsonObject;
            }else{
                jsonObject.put("errcode","0");
                jsonObject.put("data",newUser);
            }
        }catch (Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","请求失败，发生未知错误。");
        }
        return jsonObject;
    }


}
