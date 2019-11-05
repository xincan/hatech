package cn.com.hatech.auth.server.service.impl;

import cn.com.hatech.auth.server.entity.User;
import cn.com.hatech.auth.server.mapper.user.IUserMapper;
import cn.com.hatech.auth.server.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {
}
