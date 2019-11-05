package cn.com.hatech.auth.server.controller;

import cn.com.hatech.auth.server.entity.User;
import cn.com.hatech.auth.server.service.IUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Api(tags = {"用户接口"}, description = "UserController")
@RestController
@RequestMapping("/hatech")
public class UserController {

    @Autowired
    IUserRoleService userRoleService;

    @GetMapping(value = "/sleuth")
    public Mono sleuth() {
        return Mono.justOrEmpty("{id:1, name: '张山'}");
    }


    @GetMapping(value = "/principal")
    public Mono getUser(Principal principal) {
        return Mono.justOrEmpty(principal);
    }

    @GetMapping("/oauth")
    public Mono getUser(OAuth2Authentication oAuth2Authentication){
        return Mono.just(oAuth2Authentication);
    }

    @GetMapping("/authentication")
    public Mono getUser(Authentication authentication){
        return Mono.just(authentication);
    }

    @ApiOperation(value="用户注册",httpMethod="POST",notes="注册新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="username",value="用户名", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="password",value="密码", required = true, dataType = "String",paramType = "query"),
    })
    @PostMapping(value = "/registry")
    public ResponseEntity<Mono> createUser(Principal principal, @RequestParam("username") String username, @RequestParam("password") String password) {
        if (principal == null) {
            Map<String, Object> res = new HashMap<>();
            res.put("error", "用户未认证");
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Mono.just(res));
        }
        String cryptPassword = (new BCryptPasswordEncoder()).encode(password);
        User user = new User(username, cryptPassword);
        Integer res = userRoleService.saveUser(user);
        if (res == 1) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(Mono.just("user registry succeed"));
        }
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Mono.just("user registry failed"));
    }

}
