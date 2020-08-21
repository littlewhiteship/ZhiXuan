package com.xiaobaichuan.zhixuan.backstage.service;

import com.xiaobaichuan.zhixuan.backstage.entity.Advice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author songyifan
 * @since 2020-08-21
 */
public interface IAdviceService extends IService<Advice> {

    Advice addadvice(String nickname, String content);

}
