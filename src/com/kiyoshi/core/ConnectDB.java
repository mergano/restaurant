package com.kiyoshi.core;

import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author JukBot
 */
public class ConnectDB {

    String hostname;
    String DBtype;
    String DBname;
    String username;
    String password;
    String URL;
    int port;
    Connection con;

    public ConnectDB() {
        hostname = null;
        port = 3306;
        DBtype = null;
        DBname = null;
        username = null;
        password = null;
        URL = null;
    }

    public Connection getConnection() {
        Connection conn = null;
        DBname = "kiyoshi";
        username = "user";
        password = "iloveoosd";
        Properties prop = new Properties();
        URL = "jdbc:mysql://128.199.117.93:3306/kiyoshi?"; //+ "user=user&password=iloveoosd"

        prop.put("dbname", DBname);
        prop.put("user", username);
        prop.put("passwd", password);

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
