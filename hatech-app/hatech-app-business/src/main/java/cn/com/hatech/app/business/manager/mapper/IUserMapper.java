package cn.com.hatech.app.business.manager.mapper;

import cn.com.hatech.app.business.manager.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: MybatisPage
 * Author:   JiangXincan
 * Date:     2018-12-19 15:47:00
 * Description: mysql 用户管理数据访问接口
 */
@Mapper
public interface IUserMapper extends BaseMapper<User> {


}
