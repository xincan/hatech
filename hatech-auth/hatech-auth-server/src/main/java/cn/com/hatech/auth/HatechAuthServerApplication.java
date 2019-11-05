package cn.com.hatech.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: HatechAuthServerApplication
 * Author:   JiangXincan
 * Date:     2018-12-19 15:47:00
 * Description: 同创云客户端认证程序入口
 */
@SpringBootApplication
@EnableWebMvc
public class HatechAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HatechAuthServerApplication.class, args);
    }

}

