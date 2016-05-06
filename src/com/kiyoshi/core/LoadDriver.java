package com.kiyoshi.core;

public class LoadDriver {

    private static String driver;

    public LoadDriver() {
        driver = null;
    }

    public static void LoadDBDriver(int DriverType) {
        switch (DriverType) {
            case 1: // MySQL
                driver = "com.mysql.jdbc.Driver";
                break;
            case 2: // Poes
                driver = "org.postgresql.Driver";
                break;
            case 3: // MS SQL SERVER
                break;
            default:
                break;
        }

    }
}
