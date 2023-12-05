package com.muc.mapper;

import com.muc.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
//import org.springframework.stereotype.Repository;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Mapper
//@Repository
public interface AdminMapper {
    Admin getByIdAndPassword(Admin admin);
}
