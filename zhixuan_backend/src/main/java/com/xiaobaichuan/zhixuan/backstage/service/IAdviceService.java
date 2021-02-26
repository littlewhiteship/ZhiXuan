package com.xiaobaichuan.zhixuan.backstage.service;

import com.xiaobaichuan.zhixuan.backstage.entity.Advice;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface IAdviceService extends IService<Advice> {

    Advice addadvice(String nickname, String content);
    List<Advice> getalladvice();
    List<Advice> deletadvice(int adviceid);

    String readExcelFile( MultipartFile file);
}
