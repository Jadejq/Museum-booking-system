package com.muc.mapper;

import com.muc.pojo.RegularAudience;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */

@Mapper
//@Repository

public interface RegularAudienceMapper {
    @Select("select Vname as name ,VidType as doc_type,Vidnum as id,Vno as regular_audience_no from regularvisitor where Cno=( select Cno from customer where Ctel=#{phone});")
    List<RegularAudience> selectByPhone(String phone);

    @Delete("delete from regularvisitor where Vidnum=#{id,jdbcType=VARCHAR} and cno =(select cno from customer where ctel = #{phone,jdbcType=VARCHAR});")
    void delete(String phone, String id);


    void insert(RegularAudience regularAudience);

    void update(RegularAudience regularAudience);

    RegularAudience selectByPhoneAndId(RegularAudience regularAudience);
}
