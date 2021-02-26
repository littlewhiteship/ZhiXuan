package com.xiaobaichuan.zhixuan.backstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobaichuan.zhixuan.backstage.entity.Advice;
import com.xiaobaichuan.zhixuan.backstage.entity.ReadExcel;
import com.xiaobaichuan.zhixuan.backstage.mapper.AdviceMapper;
import com.xiaobaichuan.zhixuan.backstage.service.IAdviceService;
import com.xiaobaichuan.zhixuan.homepage.entity.Positioninfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class AdviceServiceImpl extends ServiceImpl<AdviceMapper, Advice> implements IAdviceService {

    @Override
    public Advice addadvice(String nickname, String content) {
        Advice newad = new Advice();
        newad.setNickname(nickname);
        newad.setContent(content);
        newad.setTime(LocalDateTime.now());
        save(newad);
        return newad;
    }

    @CrossOrigin
    @Override
    public List<Advice> getalladvice() {
        QueryWrapper<Advice> queryWrapper = new QueryWrapper<>();
        List<Advice> adviceList = list(queryWrapper);
        return adviceList;
    }

    @Override
    public List<Advice> deletadvice(int adviceid) {
        QueryWrapper<Advice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("adviceid",adviceid);
        remove(queryWrapper);
        QueryWrapper<Advice> queryWrapper1 = new QueryWrapper<>();
        List<Advice> adviceList = list(queryWrapper1);
        return adviceList;
    }


    @Override
    public String readExcelFile(MultipartFile file) {

        String result ="";
        //创建处理EXCEL的类
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取上传的事件单
        List<Positioninfo> positioninfoList = readExcel.getExcelInfo(file);
        //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
        //和你具体业务有关,这里不做具体的示范
        if(positioninfoList != null && !positioninfoList.isEmpty()){
            result = "上传成功";
        }else{
            result = "上传失败";
        }
        return result;

    }



}
