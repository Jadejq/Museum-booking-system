package com.muc.service;

import com.muc.pojo.RegularAudience;

import java.util.List;

/**
 * @author 朱佳琦
 * @version 1.0
 */
public interface RegularAudienceService {
    List<RegularAudience> selectByPhone(String phone);

    void delete(String phone, String id);

    Boolean add(RegularAudience regularAudience);

    void modify(RegularAudience regularAudience);
}
