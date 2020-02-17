package com.strutnut.dao;

import com.strutnut.bean.User;

import java.sql.ResultSet;

/**
 * 适用于用户的Dao
 *
 * @author strutnut
 * @date 2020/2/14
 */
public interface IUserDao {

    /*凭账户名查找用户*/
    ResultSet findUserByAccount(String account);

    /* 添加用户 */
    void addUser(User user);

}
