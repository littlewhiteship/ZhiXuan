package com.xiaobaichuan.zhixuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaobaichuan.zhixuan.*.mapper")
public class ZhixuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhixuanApplication.class, args);
    }
}
