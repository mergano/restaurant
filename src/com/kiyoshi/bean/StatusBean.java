package com.kiyoshi.bean;

public class StatusBean {

    private static String status;
    private static String dbType;
    private static String port;
    private static String url;
    private static String dbName;

    //Setter and Getter for Connection status information
    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        StatusBean.status = status;
    }

    public static String getDbType() {
        return dbType;
    }

    public static void setDbType(String dbType) {
        StatusBean.dbType = dbType;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        StatusBean.port = port;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        StatusBean.url = url;
    }

    public static String getDbName() {
        return dbName;
    }

    public static void setDbName(String dbName) {
        StatusBean.dbName = dbName;
    }
}
