package com.muc.service.impl;

import com.muc.mapper.GuestMapper;
import com.muc.mapper.RegularAudienceMapper;
import com.muc.pojo.RegularAudience;
import com.muc.service.RegularAudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Service
//@Transactional
public class RegularAudienceServiceImpl implements RegularAudienceService {
    @Autowired
    private RegularAudienceMapper regularAudienceMapper;
    @Override

    public List<RegularAudience> selectByPhone(String phone) {
        return regularAudienceMapper.selectByPhone(phone);
    }

    @Override
    public void delete(String phone, String id) {
        regularAudienceMapper.delete(phone,id);
    }

    @Override
    public Boolean add(RegularAudience regularAudience) {
        Boolean b;

        if(regularAudienceMapper.selectByPhoneAndId(regularAudience)==null) {
            regularAudienceMapper.insert(regularAudience);
            b=true;
        }
        else{
            b=false;
        }
        return b;
    }

    @Override
    public void modify(RegularAudience regularAudience) {
        regularAudienceMapper.update(regularAudience);
    }
}
