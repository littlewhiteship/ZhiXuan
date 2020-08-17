package com.xiaobaichuan.zhixuan.my.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author songyifan
 * @since 2020-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_userinfo")
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String openid;

    private String nickname;

    private String image;


}
