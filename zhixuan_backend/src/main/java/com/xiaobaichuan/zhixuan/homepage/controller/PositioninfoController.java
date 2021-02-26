package com.xiaobaichuan.zhixuan.homepage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobaichuan.zhixuan.homepage.entity.Advertisement;
import com.xiaobaichuan.zhixuan.homepage.entity.Positioninfo;
import com.xiaobaichuan.zhixuan.homepage.service.IAdvertisementService;
import com.xiaobaichuan.zhixuan.homepage.service.IPositioninfoService;
import com.xiaobaichuan.zhixuan.my.entity.Favjob;
import com.xiaobaichuan.zhixuan.my.service.IFavjobService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/homepage/positioninfo")
public class PositioninfoController {


    @Autowired
    private IPositioninfoService positioninfoService;
    @Autowired
    private IAdvertisementService advertisementService;
    @Autowired
    private IFavjobService favjobService;

    //刚登录未进行搜索时显示内容接口
    @RequestMapping(value = "/getposinfolist",method = RequestMethod.POST)
    public JSONObject getposinfolist(){
        JSONObject jsonObject = new JSONObject();
        try{
            //账号未传入错误
            /*
            if(openid == null || openid.equals("")) {
                jsonObject.put("errcode", "10001");
                jsonObject.put("errmsg", "数据传输错误，账号为空");
                return jsonObject;
            }
             */
            //如果该id已经填写相应的求职意向，则返回与其同意向的推荐
            //if
            //如果该id还未填写求职意向，则返回数据库中前20条


            List<Positioninfo> positioninfoList = positioninfoService.getIntroPosinfo();
            jsonObject.put("errcode","0");
            jsonObject.put("data",positioninfoList);
        }catch (Exception ex){
            jsonObject.put("errcode","10002");
            jsonObject.put("errmsg","显示数据错误");
        }
        return jsonObject;
    }




    //对首页进行筛选接口
    @RequestMapping(value = "/getselectedinfo",method = RequestMethod.GET)
    public JSONObject getselectedinfo(String content,String time,String academic,String major,String officehour,String salary){
        JSONObject jsonObject = new JSONObject();
        try{
            if(content==""&&time==""&&academic==""&&major==""&&officehour==""&&salary==""){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","搜索内容以及各个筛选项皆输入为空");
                return jsonObject;
            }
            List<Positioninfo> selposinfoList = positioninfoService.getSelPosinfo(content,time,academic,major,officehour,salary);
            jsonObject.put("errcode","0");
            jsonObject.put("data",selposinfoList);
        }catch (Exception ex){
            jsonObject.put("errcode","10002");
            jsonObject.put("errmsg","显示数据错误");
        }
        return jsonObject;
    }

    //首页显示广告接口
    @RequestMapping(value = "/getadver",method = RequestMethod.POST)
    public JSONObject getadver(String content,String time,String academic,String major,String officehour,String salary){
        JSONObject jsonObject = new JSONObject();
        try{
            List<Advertisement> advertisementList = advertisementService.getalladver();
            jsonObject.put("errcode","0");
            jsonObject.put("data",advertisementList);
        }catch (Exception ex){
            jsonObject.put("errcode","10002");
            jsonObject.put("errmsg","显示数据错误");
        }
        return jsonObject;
    }

    //首页收藏岗位接口
    @RequestMapping(value = "/addfavpos",method = RequestMethod.POST)
    public JSONObject addfavpos(int positionid,String openid,String positiontype){
        JSONObject jsonObject = new JSONObject();
        try{
            if ((positioninfoService.getById(positionid))==null){
                jsonObject.put("errcode","10002");
                jsonObject.put("errmsg","positionid错误,所收藏的岗位不存在");
                return jsonObject;
            }
            //判断该招聘信息是否已经被该用户收藏
            /*

            boolean flag = favjobService.isExist(positionid,openid);

            if (flag==false){
                jsonObject.put("errcode","10002");
                jsonObject.put("errmsg","该条已经被收藏过");
                jsonObject.put("flag","false");
                return jsonObject;
            }
            jsonObject.put("flag","true");
             */
            if (openid.equals("") ||openid==null){
                jsonObject.put("errcode","10002");
                jsonObject.put("errmsg","openid错误");
                return jsonObject;
            }
            if (positiontype==""){
                jsonObject.put("errcode","10002");
                jsonObject.put("errmsg","positiontype错误");
                return jsonObject;
            }
            Favjob favjob = favjobService.addfavpos(positionid,openid,positiontype);
            jsonObject.put("errcode","0");
            jsonObject.put("data",favjob);
        }catch (Exception ex){
            jsonObject.put("errcode","10002");
            jsonObject.put("errmsg","显示数据错误");
            System.out.println(ex);
        }
        return jsonObject;
    }

    //首页通过id查询position详细信息接口
    @RequestMapping(value = "/getposbyid",method = RequestMethod.POST)
    public JSONObject getposbyid(int id){
        JSONObject jsonObject = new JSONObject();
        try{
            //QueryWrapper<Positioninfo> queryWrapper = new QueryWrapper<>();
            Positioninfo positioninfo = positioninfoService.getById(id);
            if(positioninfo==null){
                jsonObject.put("errcode","10002");
                jsonObject.put("errmsg","无该id信息");
            }
            jsonObject.put("errcode","0");
            jsonObject.put("data",positioninfo);
        }catch (Exception ex){
            jsonObject.put("errcode","10002");
            jsonObject.put("errmsg","显示数据错误");
        }
        return jsonObject;
    }

}
