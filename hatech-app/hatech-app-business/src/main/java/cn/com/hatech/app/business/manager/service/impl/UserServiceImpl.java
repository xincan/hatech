package cn.com.hatech.app.business.manager.service.impl;

import cn.com.hatech.app.business.manager.entity.User;
import cn.com.hatech.app.business.manager.mapper.IUserMapper;
import cn.com.hatech.app.business.manager.service.IUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: MybatisPage
 * Author:   JiangXincan
 * Date:     2018-12-19 15:47:00
 * Description: 员工管理业务实现层
 */
@Service
public class UserServiceImpl implements IUserService {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Resource
    private IUserMapper userMapper;

    @Override
    public User create(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        int res = this.userMapper.insert(user);
        return user;
    }
}
