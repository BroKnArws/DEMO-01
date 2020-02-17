package com.strutnut.bean;

/**
 * 描述登录状态的实体类
 *
 * @author strutnut
 * @date 2020/2/14
 */
public class Logs {

  private long logid;
  private String logintime;
  private String ip;
  private String account;


  public long getLogid() {
    return logid;
  }

  public void setLogid(long logid) {
    this.logid = logid;
  }


  public String getLogintime() {
    return logintime;
  }

  public void setLogintime(String logintime) {
    this.logintime = logintime;
  }


  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

}
