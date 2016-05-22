package com.kiyoshi.core;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InternetStatus {

    private static boolean internet;

    public static boolean getInternetDisconnect() {
        try {
            internet = "127.0.0.1".equals(InetAddress.getLocalHost().getHostAddress()); // If return false internet is working properly
        } catch (UnknownHostException ex) {
            Logger.getLogger(InternetStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return internet;
    }
}
