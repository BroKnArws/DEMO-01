package com.strutnut.dao.impl;

import com.strutnut.dao.ILogsDao;
import com.strutnut.utils.DatabaseUtil;

import java.sql.ResultSet;

public class LogsDaoImpl implements ILogsDao {

    private static final String TABLENAME = "logs";

    @Override
    public ResultSet findLogs(String account) {
        ResultSet resultSet = DatabaseUtil.connect("SELECT * FROM " + TABLENAME + " WHERE account='" + account + "'");
        return resultSet;
    }

    @Override
    public void updateLoginTime(String account, String logintime) {
        System.out.println("UPDATE logs SET logintime='" + logintime + "' WHERE account='" + account + "'");
        ResultSet resultSet = DatabaseUtil.connect("UPDATE " + TABLENAME + " SET logintime='" + logintime + "' WHERE account='" + account + "'");
    }

    @Override
    public void addLogs(String account, String ip, String logintime) {
        ResultSet resultSet = DatabaseUtil.connect("INSERT INTO " + TABLENAME + "(account,ip,logintime) " +
                "VALUES('" + account + "'," +
                "'" + ip + "'," +
                "'" + logintime + "')"
        );
    }

    @Override
    public void deleteLogs(String account) {
        ResultSet resultSet = DatabaseUtil.connect("DELETE FROM " + TABLENAME + " WHERE account='" + account + "'");
    }

}
