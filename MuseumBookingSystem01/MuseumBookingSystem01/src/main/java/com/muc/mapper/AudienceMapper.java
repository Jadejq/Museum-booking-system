package com.muc.mapper;

import com.muc.pojo.Audience;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Mapper
//@Repository
public interface AudienceMapper {
    List<Audience> list(LocalDate date, String time, String id) ;
}
