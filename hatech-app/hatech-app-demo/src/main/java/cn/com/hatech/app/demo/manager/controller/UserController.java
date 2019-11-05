package cn.com.hatech.app.demo.manager.controller;

import cn.com.hatech.app.demo.manager.entity.User;
import cn.com.hatech.app.demo.manager.service.IUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.Principal;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: MybatisPage
 * Author:   JiangXincan
 * Date:     2018-12-19 15:47:00
 * Description: 员工管理控制层
 */
@Slf4j
@Api(tags = {"系统管理","用户管理"}, description = "UserController")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/registry")
    public Mono createUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = this.userService.create(username,password);
        return Mono.just(user);

    }

    /**
     * 获取当前认证用户的信息
     */
    @GetMapping("/principle")
    public Flux getPrinciple(OAuth2Authentication oAuth2Authentication, Principal principal, Authentication authentication){
        return Flux.just(oAuth2Authentication, principal, authentication);
    }


}
