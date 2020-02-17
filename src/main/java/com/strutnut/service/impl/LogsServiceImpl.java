package com.strutnut.service.impl;

import com.strutnut.dao.ILogsDao;
import com.strutnut.dao.impl.LogsDaoImpl;
import com.strutnut.service.ILogsService;
import com.strutnut.utils.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogsServiceImpl implements ILogsService {
    private static ILogsDao logsDao;

    static {
        logsDao = new LogsDaoImpl();

    }

    //自动登录时效（分钟）
    private static final int MARGINMINUTES = 5;

    @Override
    public boolean checkLogs(String account, String logintime) {
        ResultSet resultSet = logsDao.findLogs(account);
        try {
            assert resultSet != null;
            while (resultSet.next()) {
                String beforeTime = resultSet.getString("logintime");
                if (account.equals(resultSet.getString("account"))
                        && !DateUtil.isTimeDifferenceMoreThan(beforeTime, logintime, MARGINMINUTES)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateLoginTime(String account, String logintime) {
        logsDao.updateLoginTime(account, logintime);
    }

    @Override
    public void addLogs(String account, String ip, String logintime) {
        logsDao.addLogs(account, ip, logintime);
    }

    @Override
    public void deleteLogs(String account) {
        logsDao.deleteLogs(account);
    }
}
