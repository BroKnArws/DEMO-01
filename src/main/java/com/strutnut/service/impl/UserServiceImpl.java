package com.strutnut.service.impl;

import com.strutnut.bean.User;
import com.strutnut.dao.IUserDao;
import com.strutnut.dao.impl.UserDaoImpl;
import com.strutnut.service.IUserService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements IUserService {

    private static IUserDao userDao;

    static {
        userDao = new UserDaoImpl();
    }

    @Override
    public boolean checkUser(String account, String password) {
        ResultSet resultSet = userDao.findUserByAccount(account);
        try {
            assert resultSet != null;
            while (resultSet.next()) {
                if (password.equals(resultSet.getString("password"))
                        && account.equals(resultSet.getString("account"))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addUser(User user) {
        if (user.getName() == null || user.getPassword() == null || user.getAccount() == null
                || user.getAge() == null || user.getAvatar() == null || user.getSex() == null) {
            System.out.println("不允许空表单");
            return false;
        }
        ResultSet resultSet = userDao.findUserByAccount(user.getAccount());
        try {
            if (resultSet.next()) {
                System.out.println("用户名已存在");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        userDao.addUser(user);
        return true;
    }

    @Override
    public ResultSet findUserByAccount(String account) {
        return userDao.findUserByAccount(account);
    }
}
