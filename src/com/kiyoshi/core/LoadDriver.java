package com.kiyoshi.core;

public class LoadDriver {

    private static String driver;
    private static String url_head;

    public LoadDriver() {
        driver = null;
        url_head = null;
    }

    public void LoadDBDriver(int DriverType) {
        switch (DriverType) {
            case 1: // MySQL
                setUrlHeader("jdbc:mysql://");
                setDriver("com.mysql.jdbc.Driver");
                break;
            case 2: // Postgresql
                setUrlHeader("jdbc:postgresql://");
                setDriver("org.postgresql.Driver");
                break;
            case 3: // SQL Server
                setUrlHeader("jdbc:microsoft:sqlserver://");
                setDriver("com.microsoft.jdbc.sqlserver.SQLServerDriver");
                break;
            case 4: // DB2
                setUrlHeader("jdbc:as400://");
                setDriver("com.ibm.as400.access.AS400JDBCDriver");
                break;
            default:
                break;
        }
    }

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        LoadDriver.driver = driver;
    }

    public static String getUrlHeader() {
        return url_head;
    }

    public static void setUrlHeader(String url_head) {
        LoadDriver.url_head = url_head;
    }

}
