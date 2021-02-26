package com.xiaobaichuan.zhixuan.homepage.service;

import com.xiaobaichuan.zhixuan.homepage.entity.Positioninfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface IPositioninfoService extends IService<Positioninfo> {
    String readExcelFile( MultipartFile file);
    List<Positioninfo> getIntroPosinfo();
    List<Positioninfo> getSelPosinfo(String content, String time, String academic, String major, String officehour, String salary);
}
