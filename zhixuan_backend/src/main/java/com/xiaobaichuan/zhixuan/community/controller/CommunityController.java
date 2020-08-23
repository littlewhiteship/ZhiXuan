package com.xiaobaichuan.zhixuan.community.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobaichuan.zhixuan.community.entity.Post;
import com.xiaobaichuan.zhixuan.community.entity.Review;
import com.xiaobaichuan.zhixuan.community.service.IPostService;
import com.xiaobaichuan.zhixuan.community.service.IReviewService;
import com.xiaobaichuan.zhixuan.my.entity.Favpost;
import com.xiaobaichuan.zhixuan.my.service.IFavpostService;
import javafx.geometry.Pos;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private IPostService iPostService;

    @Autowired
    private IFavpostService iFavpostService;

    @Autowired
    private IReviewService iReviewService;

    @RequestMapping(value = "/getpostlist",method = RequestMethod.POST)
    public JSONObject getpostlist(){
        JSONObject jsonObject = new JSONObject();
        try{
            List<Post> result = new ArrayList<>();
            result = iPostService.getpostlist();
            jsonObject.put("errcode","0");
            jsonObject.put("data",result);
        }catch(Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","请求失败，发生未知错误。");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/posting",method = RequestMethod.POST)
    public JSONObject posting(String openid,String title,String content){
        JSONObject jsonObject = new JSONObject();
        try{
            if(openid == null || openid.equals("")){
                jsonObject.put("errcode","10001");
                jsonObject.put("errmsg","数据传输错误，账号为空");
                return jsonObject;
            }
            if(content == null || content.equals("")){
                jsonObject.put("errcode","10018");
                jsonObject.put("errmsg","帖子内容不能为空");
                return jsonObject;
            }
            if(title == null || title.equals("") || title.length() > 64){
                jsonObject.put("errcode","10019");
                jsonObject.put("errmsg","标题不能为空且字数需小于64");
                return jsonObject;
            }
            Post newpost = iPostService.posting(openid,title,content);
            jsonObject.put("errcode","0");
            jsonObject.put("data",newpost);
        }catch (Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","请求失败，发生未知错误");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/addfavpost",method = RequestMethod.POST)
    public JSONObject addfavpost(String openid,Integer postid){
        JSONObject jsonObject = new JSONObject();
        try {
            if (openid == null || openid.equals("")){
                jsonObject.put("errcode","10001");
                jsonObject.put("errmsg","数据传输错误，账号为空");
                return jsonObject;
            }
            if(postid == null || postid.equals("")){
                jsonObject.put("errcode","10020");
                jsonObject.put("errmsg","数据传输错误，帖子id为空");
                return jsonObject;
            }
            QueryWrapper<Favpost> favpostQueryWrapper = new QueryWrapper<>();
            favpostQueryWrapper.eq("openid",openid).eq("postid",postid);
            if(iFavpostService.list(favpostQueryWrapper).size() != 0) {
                jsonObject.put("errcode","10021");
                jsonObject.put("errmsg","收藏失败，该贴已在您的收藏列表！");
                return jsonObject;
            }
            List<Favpost> favpostList = iFavpostService.addfavpost(openid,postid);
            jsonObject.put("errcode","0");
            jsonObject.put("data",favpostList);
        }catch (Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","请求失败，发生未知错误");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/getpostdetail",method = RequestMethod.POST)
    public JSONObject getpostdetail(Integer postid){
        JSONObject jsonObject = new JSONObject();
        try{
            if(postid == null){
                jsonObject.put("errcode","10020");
                jsonObject.put("errmsg","数据传输错误，帖子id为空");
                return jsonObject;
            }
            Post post = iPostService.getpostdetail(postid);
            List<Review> review = iReviewService.getreview(postid);
            jsonObject.put("errcode","0");
            jsonObject.put("data",post);
            jsonObject.put("review",review);
        }catch (Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","请求失败，发生未知错误");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/addreview",method = RequestMethod.POST)
    public JSONObject addreview(String reopenid, Integer postid, String content){
        JSONObject jsonObject = new JSONObject();
        try{
            if(reopenid == null || reopenid.equals("")){
                jsonObject.put("errcode","10001");
                jsonObject.put("errmsg","数据传输失败，账号为空");
                return jsonObject;
            }
            if(postid == null){
                jsonObject.put("errcode","10020");
                jsonObject.put("errmsg","帖子id为空");
                return jsonObject;
            }
            if(content == null || content.equals("")){
                jsonObject.put("errcode","10022");
                jsonObject.put("errmsg","评论失败，评论内容不能为空");
                return jsonObject;
            }
            Review re = iReviewService.addreview(reopenid,postid,content);
            jsonObject.put("errcode","0");
            jsonObject.put("data",re);
        }catch (Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","请求失败，发生未知错误");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/addreply",method = RequestMethod.POST)
    public JSONObject addreply(String reopenid, Integer postid,
                               String content, String prinickname){
        JSONObject jsonObject = new JSONObject();
        try{
            if(reopenid == null || reopenid.equals("")){
                jsonObject.put("errcode","10001");
                jsonObject.put("errmsg","数据传输错误，账号为空");
                return jsonObject;
            }
            if(postid == null){
                jsonObject.put("errcode","10020");
                jsonObject.put("errmsg","数据传输错误，帖子id为空");
                return jsonObject;
            }
            if(content == null || content.equals("")){
                jsonObject.put("errcode","10023");
                jsonObject.put("errmsg","回复内容不能为空");
                return jsonObject;
            }
            if (prinickname == null || prinickname.equals("")){
                jsonObject.put("errcode","10024");
                jsonObject.put("errmsg","数据传输错误，被回复人昵称不能为空");
                return jsonObject;
            }
            Review re = iReviewService.addreply(reopenid,postid,content,prinickname);
            jsonObject.put("errcode","0");
            jsonObject.put("data",re);
        }catch(Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","请求失败，发生未知错误");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/ifaddfav",method = RequestMethod.POST)
    public JSONObject ifaddfav(String openid, Integer postid){
        JSONObject jsonObject = new JSONObject();
        try{
            if(openid == null || openid.equals("")){
                jsonObject.put("errcode","10001");
                jsonObject.put("errmsg","数据传输错误，账号为空");
                return jsonObject;
            }
            if (postid == null){
                jsonObject.put("errcode","10020");
                jsonObject.put("errmsg","数据传输错误，帖子id为空");
                return jsonObject;
            }
            boolean result = iFavpostService.ifaddfav(openid,postid);
            jsonObject.put("errcode","0");
            jsonObject.put("result",result);
        }catch (Exception ex){
            jsonObject.put("errcode","10004");
            jsonObject.put("errmsg","请求失败，发生未知错误");
        }
        return jsonObject;
    }

}