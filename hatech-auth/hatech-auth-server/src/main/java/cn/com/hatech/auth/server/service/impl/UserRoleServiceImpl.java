package cn.com.hatech.auth.server.service.impl;

import cn.com.hatech.auth.server.entity.User;
import cn.com.hatech.auth.server.mapper.user.IUserMapper;
import cn.com.hatech.auth.server.service.IUserRoleService;
import cn.com.hatech.auth.server.service.IUserService;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {

    @Resource
    IUserMapper userMapper;

    @Autowired
    IUserService userService;

    @Override
    public List<User> findRoleByUser(User user) {
        return null;
    }

    @Override
    public Integer saveUser(User user) {
        return userMapper.insert(user);
    }


}
