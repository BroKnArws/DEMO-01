package com.strutnut.service;

import com.strutnut.bean.User;

import java.sql.ResultSet;

/**
 * 适用于用户相关信息的Service
 *
 * @author strutnut
 * @date 2020/2/14
 */
public interface IUserService {

    /* 登录验证 */
    boolean checkUser(String account, String password);

    /* 添加用户 */
    boolean addUser(User user);

    /*凭账户名查找用户*/
    ResultSet findUserByAccount(String account);
}
