package com.kiyoshi.core;

import java.sql.Connection;
import java.util.Properties;

public class ConnectDB extends LoadDriver {

    String hostname;
    String DBname;
    String username;
    String password;
    String URL;
    int port;
    Connection conn;
    Properties prop = new Properties();

    public ConnectDB() {
        conn = null;
        hostname = null;
        port = 3306;
        DBname = null;
        username = null;
        password = null;
        URL = null;
    }

    public Connection getConnection() {

        DBname = "kiyoshi";
        username = "user";
        password = "iloveoosd";

        URL = "jdbc:mysql://128.199.117.93:3306/kiyoshi?"; //+ "user=user&password=iloveoosd"

        prop.put("dbname", DBname);
        prop.put("user", username);
        prop.put("passwd", password);

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();  // The newInstance() call is a work around for some
        } catch (ClassNotFoundException a) {
            System.out.println("Error: unable to load driver class!");
            System.err.println(a);
            System.exit(1);
        } catch (IllegalAccessException b) {
            System.out.println("Error: access problem while loading!");
            System.err.println(b);
            System.exit(2);
        } catch (InstantiationException c) {
            System.out.println("Error: unable to instantiate driver!");
            System.err.println(c);
            System.exit(3);
        }

//        try {
//            conn = DriverManager.getConnection(URL, props);
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//
//
//        } catch (SQLException ex) {
//            // handle any errors
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " + ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
//        }
        return conn;
    }

}
