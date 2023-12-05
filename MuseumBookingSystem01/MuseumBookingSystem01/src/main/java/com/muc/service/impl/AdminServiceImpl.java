package com.muc.service.impl;

import com.muc.mapper.AdminMapper;
import com.muc.pojo.Admin;
import com.muc.service.AdminService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
//    @Autowired
//    private SqlSessionTemplate sqlSessionTemplate1;

    @Override
    public Admin login(Admin admin) {
//        return sqlSessionTemplate1.getMapper(AdminMapper.class).getByIdAndPassword(admin);//adminMapper.getByIdAndPassword(admin);
//        sqlSessionTemplate1.getMapper(UserMapper1.class).getUserById(userId);
        return adminMapper.getByIdAndPassword(admin);
    }
}
