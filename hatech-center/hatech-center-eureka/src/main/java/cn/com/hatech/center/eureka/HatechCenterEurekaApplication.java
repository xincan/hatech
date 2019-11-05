package cn.com.hatech.center.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: MybatisPage
 * Author:   JiangXincan
 * Date:     2018-12-19 15:47:00
 * Description: 同创云服务注册与发现中心
 */
@SpringBootApplication
@EnableEurekaServer
public class HatechCenterEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HatechCenterEurekaApplication.class, args);
    }

}

