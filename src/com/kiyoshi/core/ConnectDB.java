package com.kiyoshi.core;

import com.kiyoshi.bean.StatusBean;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDB extends LoadDriver {

    private Connection conn;
    private String URL_HEADER;
    private String URL;
    private final String hostName;
    private final int port;
    private final String databaseName;
    private final String username;
    private final String password;
    private String status;
    private DatabaseMetaData meta;
    private final Properties info = new Properties();

    public ConnectDB() {
        conn = null;
        URL_HEADER = "";
        URL = "";
        hostName = "128.199.117.93";
        port = 3306;
        databaseName = "kiyoshi";
        username = "user";
        password = "iloveoosd";
        status = "";
        meta = null;

    }

    public Connection getconnection() {
        super.LoadDBDriver(1); // Load MySQL driver
        URL_HEADER = LoadDriver.getUrlHeader();
        URL = URL_HEADER + hostName + ":" + port + "/" + databaseName + "?useCompression=true" + "&autoReconnnect=true" + "&useSSL=false";
        info.put("user", username);
        info.put("password", password);

        try {
            boolean internet = "127.0.0.1".equals(InetAddress.getLocalHost().getHostAddress());
            System.out.println(internet);
            Class.forName(LoadDriver.getDriver()); // Registed JDBC DRIVER
            conn = DriverManager.getConnection(URL, info);
            conn.setAutoCommit(true);
            meta = conn.getMetaData();
            if (conn == null) {
                status = "Disconnnect";
                System.out.println("Connect to database failed");
                System.exit(1);
            } else {
                status = "Connected";
                StatusBean.setStatus(status);
                StatusBean.setDbType(meta.getDatabaseProductName());
                StatusBean.setDbName(conn.getCatalog());
                StatusBean.setPort(port + "");
                StatusBean.setUrl(hostName);
                System.out.println("Connected to database " + conn);
            }
        } catch (ClassNotFoundException | SQLException | UnknownHostException ex) {
            System.err.println("Error " + ex);
            System.exit(1);
        }
        return conn;
    }

    public void commit() {
        try {
            conn.commit();
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                System.exit(1);
            }
        }
    }

    public void closeDB() {
        try {
            conn.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
        }
    }

}
