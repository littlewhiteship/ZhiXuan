package com.xiaobaichuan.zhixuan.my.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobaichuan.zhixuan.community.entity.Post;
import com.xiaobaichuan.zhixuan.my.entity.Cv;
import com.xiaobaichuan.zhixuan.my.entity.Favpost;
import com.xiaobaichuan.zhixuan.my.entity.Userinfo;
import com.xiaobaichuan.zhixuan.my.service.ICvService;
import com.xiaobaichuan.zhixuan.my.service.IFavjobService;
import com.xiaobaichuan.zhixuan.my.service.IFavpostService;
import com.xiaobaichuan.zhixuan.my.service.IUserinfoService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    private ICvService iCvService;

    @Autowired
    private IFavpostService iFavpostService;

    @Autowired
    private IFavjobService iFavjobService;

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
            if(user == null){
                jsonObject.put("errcode","10005");
                jsonObject.put("errmsg","用户已注册");
                return jsonObject;
            }else{
                Cv usercv = new Cv();
                usercv.setOpenid(account);
                iCvService.save(usercv);
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

    @RequestMapping(value = "/addcv",method = RequestMethod.POST)
    public JSONObject addcv(String openid,String uname,String gender,
                            String edubg,String major,Integer internship,String grade,
                            String practime,String worktime,String fsttarget,
                            String sndtarget){
        JSONObject jsonObject = new JSONObject();
        try{
            if(openid == null || openid.equals("")){
                jsonObject.put("errcode","10001");
                jsonObject.put("errmsg","数据传输错误，账号为空");
                return jsonObject;
            }
            if(uname == null || uname.equals("")){
                jsonObject.put("errcode","10008");
                jsonObject.put("errmsg","提交错误，姓名不能为空");
                return jsonObject;
            }
            if(gender == null || gender.equals("")){
                jsonObject.put("errcode","10009");
                jsonObject.put("errmsg","提交错误，性别不能为空");
                return jsonObject;
            }
            if(edubg == null || edubg.equals("")){
                jsonObject.put("errcode","10010");
                jsonObject.put("errmsg","提交错误，学历不能为空");
                return jsonObject;
            }
            if(major == null || major.equals("")){
                jsonObject.put("errcode","10011");
                jsonObject.put("errmsg","提交错误，专业不能为空");
                return jsonObject;
            }
            if(internship == null){
                jsonObject.put("errcode","10012");
                jsonObject.put("errmsg","提交错误，实习类型不能为空");
                return jsonObject;
            }
            if(grade == null || grade.equals("")){
                jsonObject.put("errcode","10013");
                jsonObject.put("errmsg","提交错误，年级不能为空");
                return jsonObject;
            }
            if(practime == null || practime.equals("")){
                jsonObject.put("errcode","10014");
                jsonObject.put("errmsg","提交错误，实习时间不能为空");
                return jsonObject;
            }
            if(worktime == null || worktime.equals("")){
                jsonObject.put("errcode","10015");
                jsonObject.put("errmsg","提交错误，工作时间不能为空");
                return jsonObject;
            }
            if(fsttarget == null || fsttarget.equals("")){
                jsonObject.put("errcode","10016");
                jsonObject.put("errmsg","提交错误，期望职位请至少填写一个");
                return jsonObject;
            }
            Cv result = iCvService.addcv(openid,uname,gender,edubg,major,
                    internship,grade,practime,worktime,fsttarget,sndtarget);
            jsonObject.put("errcode","0");
            jsonObject.put("data",result);
        }catch (Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","请求失败，发生未知错误");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/getcv",method = RequestMethod.POST)
    public JSONObject getcv(String openid){
        JSONObject jsonObject = new JSONObject();
        try{
            if(openid == null || openid.equals("")){
                jsonObject.put("errcode","10001");
                jsonObject.put("errmsg","数据传输错误，账号为空");
                return jsonObject;
            }
            Cv result = iCvService.getcv(openid);
            jsonObject.put("errcode","0");
            jsonObject.put("data",result);
        }catch (Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","请求失败，发生未知错误");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/getfavpost",method = RequestMethod.POST)
    public JSONObject getfavpost(String openid){
        JSONObject jsonObject = new JSONObject();
        try{
            if(openid == null || openid.equals("")) {
                jsonObject.put("errcode", "10001");
                jsonObject.put("errmsg", "数据传输错误，账号为空");
                return jsonObject;
            }
            List<Post> result = iFavpostService.getfavpost(openid);
            jsonObject.put("errcode","0");
            jsonObject.put("data",result);
        }catch (Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","请求失败，发生未知错误");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/cancelfavpost",method = RequestMethod.POST)
    public JSONObject cancelfavpost(String openid,Integer postid){
        JSONObject jsonObject = new JSONObject();
        try{
            if(openid == null || openid.equals("")){
                jsonObject.put("errcode","10001");
                jsonObject.put("errmsg","数据传输错误，账号为空");
                return jsonObject;
            }
            if(postid == null ){
                jsonObject.put("errcode","10017");
                jsonObject.put("errmsg","收藏帖子id不能为空");
                return jsonObject;
            }
            List<Post> result = iFavpostService.cancelfavpost(openid,postid);
            jsonObject.put("errcode","0");
            jsonObject.put("data",result);
        }catch (Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","请求失败，发生未知错误");
        }
        return jsonObject;
    }

    //后面暂时没写
    @RequestMapping(value = "/getfavjob",method = RequestMethod.POST)
    public JSONObject getfavjob(String openid){
        JSONObject jsonObject = new JSONObject();
        try{
            if (openid == null || openid.equals("")){
                jsonObject.put("errcode","10001");
                jsonObject.put("errmsg","数据传输错误，账号为空");
                return jsonObject;
            }

        }catch (Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","请求失败，发生未知错误");
        }
        return jsonObject;
    }

}
