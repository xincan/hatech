package cn.com.hatech.app.business.manager.service;


import cn.com.hatech.app.business.manager.entity.User;

/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: MybatisPage
 * Author:   JiangXincan
 * Date:     2018-12-19 15:47:00
 * Description: 用户管理接口层
 */
public interface IUserService {

    User create(String username, String password);

}
