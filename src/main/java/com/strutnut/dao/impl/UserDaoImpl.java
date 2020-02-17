package com.strutnut.dao.impl;

import com.strutnut.bean.User;
import com.strutnut.dao.IUserDao;
import com.strutnut.utils.DatabaseUtil;

import java.sql.ResultSet;

public class UserDaoImpl implements IUserDao {


    private static final String TABLENAME = "user";

    @Override
    public ResultSet findUserByAccount(String account) {

        ResultSet resultSet = DatabaseUtil.connect("SELECT * FROM " + TABLENAME + " WHERE account='" + account + "'");
        return resultSet;
    }

    @Override
    public void addUser(User user) {
        ResultSet resultSet = DatabaseUtil.connect("INSERT INTO " + TABLENAME + " ("
                + "account" + ","
                + "password" + ","
                + "name" + ","
                + "age" + ","
                + "sex" + ","
                + "avatar" + ","
                + "signature"
                + ") VALUES ('"
                + user.getAccount() + "','"
                + user.getPassword() + "','"
                + user.getName() + "','"
                + user.getAge() + "','"
                + user.getSex() + "','"
                + user.getAvatar() + "','"
                + user.getSignature()
                + "')");
    }
}
