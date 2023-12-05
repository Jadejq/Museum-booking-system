package com.muc.mapper;

import com.muc.pojo.Admin;
import com.muc.pojo.Guest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Mapper
//@Repository

public interface GuestMapper {
    @Select("select Ctel as phone from customer\n where Ctel = #{phone};")
    Guest getByPhone(Guest guest);

    @Insert("insert into Customer(Cno,Ctel) values \n" +
            "((select ncno from(select max(CONVERT(cno,SIGNED)) as ncno from customer ) as a)+1,\n" +
            "#{phone});")
    void insert(Guest guest);

    @Select("select Cno as uid,Ctel as phone from customer where Ctel=#{phone};")
    Guest selectByPhone(String phone);
}
