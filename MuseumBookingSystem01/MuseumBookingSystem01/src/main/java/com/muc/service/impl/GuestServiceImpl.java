package com.muc.service.impl;

import com.muc.mapper.AdminMapper;
import com.muc.mapper.GuestMapper;
import com.muc.pojo.Admin;
import com.muc.pojo.Guest;
import com.muc.service.AdminService;
import com.muc.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 朱佳琦
 * @version 1.0
 */
@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    private GuestMapper guestMapper;

    @Override
    public Guest login(Guest guest) {
        return guestMapper.getByPhone(guest);
    }

    @Override
    public void signIn(Guest guest) {
        guestMapper.insert(guest);
    }

    @Override
    public Guest getInfoByPhone(String phone) {

        return guestMapper.selectByPhone(phone);
    }
}
