package com.strutnut.service;

/**
 * 适用于登录状态的Service
 *
 * @author strutnut
 * @date 2020/2/14
 */
public interface ILogsService {

    /* 是否已登录过验证 */
    boolean checkLogs(String account, String logintime);

    /* 更新登录时间 */
    void updateLoginTime(String account,String logintime);

    /* 添加已登录信息 */
    void addLogs(String account,String ip,String logintime);

    /* 删除登录信息 */
    void deleteLogs(String account);
}
