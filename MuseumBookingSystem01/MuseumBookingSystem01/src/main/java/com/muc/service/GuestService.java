package com.muc.service;

import com.muc.pojo.Admin;
import com.muc.pojo.Guest;

/**
 * @author 朱佳琦
 * @version 1.0
 */
public interface GuestService {

    Guest login(Guest guest);
    void signIn(Guest guest);

    Guest getInfoByPhone(String phone);
}
