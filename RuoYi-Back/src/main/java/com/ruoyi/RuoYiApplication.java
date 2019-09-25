package com.ruoyi;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 启动程序
 * 
 * @author XRZ
 */
@Slf4j
@MapperScan(basePackages = {
        "com.ruoyi.taoke.*.mapper"
})
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class RuoYiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RuoYiApplication.class, args);
        log.info("========================【淘客工具后台启动完成】========================");
    }
}