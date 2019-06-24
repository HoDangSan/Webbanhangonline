package com.hodangsan.webbanhang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public DBConnection() {
    }

    public Connection getConnection() {
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "localhost";
            String myDB = "banhangonlinedb";
            String url = "jdbc:mysql://" + serverName + "/" + myDB;
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
