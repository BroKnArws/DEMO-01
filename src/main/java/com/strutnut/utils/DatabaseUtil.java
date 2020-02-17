package com.strutnut.utils;

import java.sql.*;


/**
 * 用于连接数据库和获取结果集
 *
 * @author strutnut
 * @date 2020/2/14
 */

public class DatabaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/sy?useUnicode=true&characterEncoding=UTF-8";
    private static final String NAME = "root";
    private static final String PASSWORD = "123456";


    /* 连接数据库和返回结果集 */
    public static ResultSet connect(String sql) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            Statement stmt = connection.createStatement();
//            增删改如果使用executeQuery会报错。
            if (sql.contains("UPDATE") || sql.contains("DELETE") || sql.contains("INSERT")) {
                stmt.executeUpdate(sql);
            } else {
                ResultSet rs = stmt.executeQuery(sql);
                return rs;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
