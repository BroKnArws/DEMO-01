package com.strutnut.dao;

import java.sql.ResultSet;

/**
 * 适用于登录状态的Dao
 *
 * @author strutnut
 * @date 2020/2/14
 */
public interface ILogsDao {


    /* 获取登录状态 */
    ResultSet findLogs(String account);

    /* 更新登录时间 */
    void updateLoginTime(String account,String logintime);

    /* 添加登录信息 */
    void addLogs(String account,String ip,String logintime);

    /* 删除登录信息 */
    void deleteLogs(String account);


}
