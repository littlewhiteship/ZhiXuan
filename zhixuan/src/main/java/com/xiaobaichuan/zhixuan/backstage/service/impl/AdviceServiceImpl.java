package com.xiaobaichuan.zhixuan.backstage.service.impl;

import com.xiaobaichuan.zhixuan.backstage.entity.Advice;
import com.xiaobaichuan.zhixuan.backstage.mapper.AdviceMapper;
import com.xiaobaichuan.zhixuan.backstage.service.IAdviceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author songyifan
 * @since 2020-08-21
 */
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

}
