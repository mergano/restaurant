package com.kiyoshi.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    String url;
    String status;
    String error;
    int port;
    Connection con;

    public ConnectDB() {
        hostname = null;
        port = 3306;
        DBtype = null;
        DBname = null;
        username = null;
        password = null;
        status = null;
    }

//    public Connection getConnection() {
//        Connection conn = null;
//        String dbname = null;
//        String username = null;
//        String passwd = null;
//
//        Properties connectionProps = new Properties();
//        connectionProps.put(dbname, this.dbName);
//        connectionProps.put(username, this.userName);
//        connectionProps.put(passwd, this.passWord);
//        connectionProps.
//        if (this.dbms.equals("mysql")) {
//            conn = DriverManager.getConnection("jdbc:" + this.dbms + "://" + this.serverName + ":" + this.portNumber + "/",
//                    connectionProps);
//
//        } else if (this.dbms.equals("derby")) {
//            conn = DriverManager.getConnection("jdbc:" + this.dbms + ":" + this.dbName + ";create=true",
//                    connectionProps);
//        }
//
//    }
}
