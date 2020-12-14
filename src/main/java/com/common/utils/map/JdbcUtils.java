package com.common.utils.map;

import java.sql.*;

/**
* @author  作者 E-mail:
* @date 创建时间：2019年5月28日 上午11:05:22
* @version 1.0
* @parameter
* @since
* @return  */
public class JdbcUtils {

//oracle连接参数获取
private static final String oracleDriver,oracleUrl,javaUser,javaPassword;
//mysql连接
private static final String mysqlDriver,mysqlUrl,mysqlUser,mysqlPassword;
//postgreSQL连接
private static final String postgreDriver,postgreUrl,postgreUser,postgrePassword;

static {
     // 定义数据源连接信息，假设以下所有数据源设置都存在
    oracleDriver = "oracle.jdbc.driver.OracleDriver";
    oracleUrl = "jdbc:oracle:thin:@10.10.68.248:1521:orcl";
    javaUser =  "riskcontrol";
    javaPassword =  "riskcontrol";

    mysqlDriver = "com.mysql.jdbc.Driver";
    mysqlUrl = "jdbc:mysql://192.168.0.101:3306/shop?characterEncoding=utf-8";
//		mysqlUrl = "jdbc:mysql://localhost:3306/shop?characterEncoding=utf-8";
    mysqlUser =  "root";
    mysqlPassword =  "admin";

    postgreDriver = "org.postgresql.Driver";
    postgreUrl = "jdbc:postgresql://localhost:5432/platform_devdb";
    postgreUser =  "postgres";
    postgrePassword =  "123456";

}
/*进行postgreSQL数据库的连接*/
public static Connection getPostgreConnection(){
    Connection connect = null;
    try {
        Class.forName(postgreDriver);
        connect = DriverManager.getConnection(postgreUrl, postgreUser, postgrePassword);
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
    if(connect!=null){
        System.out.println("数据库连接成功!");
    }else {
        System.out.println("数据库连接失败!");
    }
    return connect;
}
/*进行oracle数据库的连接*/
public static Connection getJdbcConnection(){
    Connection connect = null;
    try {
        Class.forName(oracleDriver);
        connect = DriverManager.getConnection(oracleUrl, javaUser, javaPassword);
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
    return connect;
}
/*进行mysql数据库的连接*/
public static Connection getMysqlConnection(){
    Connection connect = null;
    try {
        Class.forName(mysqlDriver);
        connect = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPassword);
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
    return connect;
}

/* 关闭数据库资源*/
public static void closeResource(ResultSet resultSet,PreparedStatement preState,Connection connect){
     try {
        if (resultSet!=null) resultSet.close();
        if (preState!=null) preState.close();
        if (connect!=null) connect.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}
