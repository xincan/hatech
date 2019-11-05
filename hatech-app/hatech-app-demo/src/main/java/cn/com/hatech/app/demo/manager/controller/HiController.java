package cn.com.hatech.app.demo.manager.controller;


import cn.com.hatech.app.demo.manager.service.feign.AppBusinessFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @Copyright (C), 2018,北京同创永益科技发展有限公司
 * @ProjectName: hatech
 * @Package: cn.com.hatech.app.demo.manager.controller
 * @ClassName: HiController
 * @Author: Xincan
 * @Description: ${description}
 * @Date: 2019/4/21 13:33
 * @Version: 1.0
 */
@RestController
@Slf4j
public class HiController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppBusinessFeignService appBusinessFeignService;

    /**
     * 不需要任何权限，只要Header中的Token正确即可
     */
    /**
     * 获取当前认证用户的信息
     */
    @GetMapping("/principle")
    public Mono getPrinciple(String access_token){
        System.out.println(access_token);
        String url = "http://localhost:8070/hatech/principal?access_token=" + access_token;
        Object a =  this.restTemplate.getForObject(url,Object.class);
        return Mono.justOrEmpty(a);
    }

    /**
     * 不需要任何权限，只要Header中的Token正确即可
     */
    @GetMapping("/hi")
    public Map<String, Object> hi() {
        Map<String,Object> json = new HashMap<>();
        json.put("port",port);
        json.put("msg", "hi, i am from port: "+port);
        return json;
    }

    /**
     * 调用business服务hi方法
     * @return
     */
    @GetMapping("/feign")
    public Map<String, Object> feignHi() {
        return appBusinessFeignService.hi();
    }

    @PreAuthorize("hasAuthority('ROLE_STUDENT')")  //
    @RequestMapping("/student")
    public String student (){
        return "student";
    }

    /**
     * 需要ROLE_ADMIN权限
     */
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/hello")
    public Mono hello() {
        Map<String, Object> json = new HashMap<>();
        json.put("port",port);
        json.put("msg", "hello");
        return Mono.justOrEmpty(json);
    }

}
