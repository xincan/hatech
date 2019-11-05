package cn.com.hatech.app.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: EmployeeServiceImpl
 * Author:   JiangXincan
 * Date:     2018-12-19 15:47:00
 * Description: 灾备业务影响分析微服务入口
 */
@SpringBootApplication
@EnableFeignClients
public class HatechAppDemoApplication {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(HatechAppDemoApplication.class, args);
    }

}

