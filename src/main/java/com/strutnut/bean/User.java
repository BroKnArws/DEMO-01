package com.strutnut.bean;

/**
 * 用户信息的实体类
 *
 * @author strutnut
 * @date 2020/2/14
 */

public class User {

  private long uid;
  private String account;
  private String password;
  private String name;
  private String age;
  private String sex;
  private String avatar;
  private String signature;

  public User(String account, String password, String name, String age, String sex, String avatar, String signature) {
    this.account = account;
    this.password = password;
    this.name = name;
    this.age = age;
    this.sex = sex;
    this.avatar = avatar;
    this.signature = signature;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }


  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

}
