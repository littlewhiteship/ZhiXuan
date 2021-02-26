package com.xiaobaichuan.zhixuan.backstage.controller;


import com.xiaobaichuan.zhixuan.backstage.entity.Advice;
import com.xiaobaichuan.zhixuan.backstage.service.IAdviceService;
import com.xiaobaichuan.zhixuan.homepage.entity.Advertisement;
import com.xiaobaichuan.zhixuan.homepage.entity.Positioninfo;
import com.xiaobaichuan.zhixuan.homepage.service.IAdvertisementService;
import com.xiaobaichuan.zhixuan.homepage.service.IPositioninfoService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/backstage/advice")
public class AdviceController {




    @Autowired
    private IAdviceService adviceService;

    @Autowired
    private IAdvertisementService advertisementService;

    @Autowired
    private IPositioninfoService positioninfoService;

    //导入数据接口
    //1.导入表格接口
    @RequestMapping(value = "/autoaddposinfo",method = RequestMethod.GET)
    public JSONObject autoaddposinfo(@RequestParam(value="file",required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        try{
            String result = positioninfoService.readExcelFile(file);
            jsonObject.put("errcode","0");
            jsonObject.put("data",result);
        }catch (Exception ex){
            System.out.println(ex);
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","显示数据错误");
        }
        return jsonObject;
    }




    //2.手动输入数据接口

    @RequestMapping(value = "/addposinfo",method = RequestMethod.GET)
    public JSONObject addposinfo(String search, String position, String time, String academic, String major, String officehour, String salary, String company, String introduction, String relativeinfo, String detailedinfo, String application){
        JSONObject jsonObject = new JSONObject();
        try{
            //存储内容
            if(search==""||search==null){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","未输入推荐搜索内容");
                return jsonObject;
            }
            if(time==""||time==null){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","未输入招聘时间");
                return jsonObject;
            }
            if(academic==""||academic==null){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","未输入学历要求");
                return jsonObject;
            }
            if(major==""||major==null){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","未输入专业要求");
                return jsonObject;
            }
            if(officehour==""||officehour==null){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","未输入工作时长");
                return jsonObject;
            }

            if(salary==""||salary==null){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","未输入薪水");
                return jsonObject;
            }
            if(company==""||company==null){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","未输入公司名称");
                return jsonObject;
            }
            if(introduction==""||introduction==null){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","未输入公司介绍");
                return jsonObject;
            }
            if(relativeinfo==""||relativeinfo==null){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","未输入相关信息");
                return jsonObject;
            }
            if(detailedinfo==""||detailedinfo==null){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","未输入详细信息");
                return jsonObject;
            }
            if(application==""||application==null){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","未输入应聘方式");
                return jsonObject;
            }
            if(position==""||position==null){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","未输入应聘岗位");
                return jsonObject;
            }

            Positioninfo positioninfo = new Positioninfo(search, position, time, academic, major, officehour, salary, company, introduction, relativeinfo, detailedinfo, application);
            boolean flag = positioninfoService.save(positioninfo);
            if(flag==false){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","存储数据失败");
                return jsonObject;
            }
            jsonObject.put("errcode","0");
            jsonObject.put("data",positioninfo);
            //返回数据为招聘信息
        }catch (Exception ex){
            System.out.println("开始输出错误内容");
            System.out.println(ex);
            jsonObject.put("errcode","10003");
            jsonObject.put("errmsg","显示数据错误");
        }
        return jsonObject;
    }

    //删除招聘信息接口
    @RequestMapping(value = "/deletepositioninfo",method = RequestMethod.POST)
    public JSONObject deletepositioninfo(int listid){
        JSONObject jsonObject = new JSONObject();
        try{
            boolean flag = positioninfoService.removeById(listid);
            if(flag==false){
                //如果id不存在，无法成功删除。
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","id不存在无法删除");
                return jsonObject;
            }
            List<Positioninfo> positioninfoList = positioninfoService.getIntroPosinfo();
            jsonObject.put("errcode","0");
            jsonObject.put("data",positioninfoList);
        }catch (Exception ex){
            System.out.println(ex);
            jsonObject.put("errcode","10003");
            jsonObject.put("errmsg","显示数据错误");
        }
        return jsonObject;
    }

    //添加广告接口
    @RequestMapping(value = "/addadv",method = RequestMethod.GET)
    public JSONObject addadv(String url){
        JSONObject jsonObject = new JSONObject();
        try{
            if (url==""){
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","未输入图片链接");
                return jsonObject;
            }
            Advertisement advertisement = new Advertisement(url);
            advertisementService.save(advertisement);
            List<Advertisement> advertisementList = advertisementService.getalladver();
            //重新返回的是当前所有的广告。
            jsonObject.put("errcode","0");
            jsonObject.put("data",advertisementList);
        }catch (Exception ex){
            jsonObject.put("errcode","10003");
            jsonObject.put("errmsg","显示数据错误");
        }
        return jsonObject;
    }

    //删除广告接口
    @RequestMapping(value = "/deleteadv",method = RequestMethod.GET)
    public JSONObject deleteadv(int id){
        JSONObject jsonObject = new JSONObject();
        try{
            //感觉没啥好判断的
            boolean flag = advertisementService.removeById(id);
            if(flag==false){
                //如果id不存在，无法成功删除。
                jsonObject.put("errcode","10003");
                jsonObject.put("errmsg","id不存在无法删除");
                return jsonObject;
            }
            List<Advertisement> advertisementList = advertisementService.getalladver();
            //重新返回的是当前所有的广告。
            jsonObject.put("errcode","0");
            jsonObject.put("data",advertisementList);
        }catch (Exception ex){
            jsonObject.put("errcode","10003");
            jsonObject.put("errmsg","显示数据错误");
        }
        return jsonObject;
    }

    @CrossOrigin
    //查看用户投诉信息接口
    @RequestMapping(value = "/getadvicelist",method = RequestMethod.POST)
    public JSONObject getadvicelist(){
        JSONObject jsonObject = new JSONObject();
        try{
            List<Advice> adviceList = adviceService.getalladvice();
            jsonObject.put("errcode","0");
            jsonObject.put("data",adviceList);
        }catch (Exception ex){
            jsonObject.put("errcode","10003");
            jsonObject.put("errmsg","显示数据错误");
        }
        return jsonObject;
    }

    //删除用户举报信息接口
    //删除该条后，返回重新生成的List
    @RequestMapping(value = "/deleteadvice",method = RequestMethod.POST)
    public JSONObject deleteadvice(int adviceid){
        JSONObject jsonObject = new JSONObject();
        try{
            boolean flag = adviceService.removeById(adviceid);
            if(flag==false){
                jsonObject.put("errcode","10004");
                jsonObject.put("errmsg","所删除数据id不存在");
                return jsonObject;
            }
            List<Advice> adviceList = adviceService.getalladvice();
            //不用这个了
            //List<Advice> adviceList = adviceService.deletadvice(adviceid);
            jsonObject.put("errcode","0");
            jsonObject.put("data",adviceList);
        }catch (Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","显示数据错误");
        }
        return jsonObject;
    }






}

