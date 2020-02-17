package com.strutnut.test;



import org.junit.Test;

public class MyTest {

    @Test
    public void test() {
        long currentTime = System.currentTimeMillis();
        //System.out.println(currentTime);
        //System.out.println(DateUtil.isTimeDifferenceMoreThan("2018-03-01 12:00:00","2018-03-01 12:04:00",5));
        //new LogsDaoImpl().deleteLogs("admin");
        System.out.println("INSERT INTO " + "TABLENAME" + " ("
                + "account" + ","
                + "password" + ","
                + "age" + ","
                + "sex" + ","
                + "avatar" + ","
                + "signature"
                + ") VALUES ('"
                + "user.getAccount()" + "','"
                + "user.getPassword()" + "','"
                + "user.getAge()" + "','"
                + "user.getSex()" + "','"
                + "user.getAvatar()" + "','"
                + "user.getSignature()"
                + "')");
    }
}
