package com.xiaobaichuan.zhixuan.my.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xiaobaichuan.zhixuan.my.entity.Cv;
import com.xiaobaichuan.zhixuan.my.mapper.CvMapper;
import com.xiaobaichuan.zhixuan.my.service.ICvService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songyifan
 * @since 2020-08-16
 */
@Service
public class CvServiceImpl extends ServiceImpl<CvMapper, Cv> implements ICvService {

    @Override
    public Cv addcv(String openid, String uname, String gender, String edubg,
                    String major, Integer internship, String grade, String practime,
                    String worktime, String fsttarget, String sndtarget) {
        UpdateWrapper<Cv>cvUpdateWrapper = new UpdateWrapper<>();
        cvUpdateWrapper.eq("openid",openid).set("uname",uname).set("gender",gender)
                .set("edubg",edubg).set("major",major).set("internship",internship)
                .set("grade",grade).set("practime",practime).set("worktime",worktime)
                .set("fsttarget",fsttarget).set("sndtarget",sndtarget);
        update(cvUpdateWrapper);
        QueryWrapper<Cv>cvQueryWrapper = new QueryWrapper<>();
        cvQueryWrapper.eq("openid",openid);
        Cv cv = getOne(cvQueryWrapper);
        return cv;
    }

    @Override
    public Cv getcv(String openid) {
        QueryWrapper<Cv>cvQueryWrapper = new QueryWrapper<>();
        cvQueryWrapper.eq("openid",openid);
        return getOne(cvQueryWrapper);
    }

}