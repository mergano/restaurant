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
