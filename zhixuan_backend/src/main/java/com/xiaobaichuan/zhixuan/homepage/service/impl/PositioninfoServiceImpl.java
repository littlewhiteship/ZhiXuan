package com.xiaobaichuan.zhixuan.homepage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobaichuan.zhixuan.backstage.entity.ReadExcel;
import com.xiaobaichuan.zhixuan.homepage.entity.Positioninfo;
import com.xiaobaichuan.zhixuan.homepage.mapper.PositioninfoMapper;
import com.xiaobaichuan.zhixuan.homepage.service.IPositioninfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
public class PositioninfoServiceImpl extends ServiceImpl<PositioninfoMapper, Positioninfo> implements IPositioninfoService {

    @Override
    public String readExcelFile(MultipartFile file) {

        String result ="";
        //创建处理EXCEL的类
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取上传的事件单
        System.out.println("进入getExcelInfo函数");
        List<Positioninfo> positioninfoList = readExcel.getExcelInfo(file);
        //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
        //和你具体业务有关,这里不做具体的示范
        if(positioninfoList != null && !positioninfoList.isEmpty()){
            result = "上传成功";
            //将数据保存至数据库

            System.out.println("positioninfoList.size() = "+positioninfoList.size());
            System.out.println("开始显示整个list中的position内容");
            System.out.println(positioninfoList);
            System.out.println("显示整个list中的内容结束，即将开始存储");

            for(int i=0;i<positioninfoList.size();i++){
                System.out.println("进入第"+i+"个循环，开始存储数据");
                Positioninfo positioninfo = positioninfoList.get(i);
                System.out.println("第"+i+"个position的内容为"+positioninfo);
                System.out.println("即将开始存储第"+i+"个数据的内容");
                save(positioninfo);
            }


        }else{
            result = "上传失败";
        }
        return result;

    }

    @Override
    public List<Positioninfo> getIntroPosinfo() {
        QueryWrapper<Positioninfo> queryWrapper = new QueryWrapper<>();
        List<Positioninfo> positioninfoList =list(queryWrapper);
        return positioninfoList;
    }

    @Override
    public List<Positioninfo> getSelPosinfo(String content,String time,String academic,String major,String officehour,String salary) {
        QueryWrapper<Positioninfo> queryWrapper = new QueryWrapper<>();
        if(content!=""){
            //在search中对内容进行搜索
            queryWrapper.like("search",content);
            //对于content
            //可能为职位名、公司名、时间、年级
            //queryWrapper.like("position",content).or().like("company",content).or().like("time",content).or().like("academic",content);


            //在具体内容中对内容进行搜索
            //------------------
            queryWrapper.like("time",content).or().like("academic",content).or().like("major",content).or().like("officehour",content)
                    .or().like("salary",content).or().like("company",content).or().like("introduction",content).or().like("relativeinfo",content)
                    .or().like("detailedinfo",content).or().like("application",content);
        }
        //对于筛选项time
        //对时间进行模糊搜索
        if (time!=""){
            queryWrapper.like("time",time);
        }
        //对学历进行搜索
        if(academic!=""){
            /*
            if(academic=="本科"){
                //如果搜索本科将会搜索包括本科以及具体到某一届的本科生
                queryWrapper.like("academic","本科").or().eq("academic","2020届").or().eq("academic","2021届").or().eq("academic","2022届").or().eq("academic","2023届");
            }
            else {
                //如果不是，则直接用该关键词模糊搜索
                queryWrapper.like("academic",academic);
            }
            */
            queryWrapper.like("academic",academic);
        }
        //对专业要求
        //如金融会计财务等
        if(major!=""){
            queryWrapper.like("major",major);
        }
        //对筛选项上班时间
        //比如一周两天等
        if(officehour!=""){
            queryWrapper.like("officehour",officehour);
        }
        //对筛选项薪资
        //比如100以上
        if(salary!=""){
            queryWrapper.like("salary",salary);
        }
        List<Positioninfo> selPosInfoList = list(queryWrapper);
        return selPosInfoList;
    }
}
