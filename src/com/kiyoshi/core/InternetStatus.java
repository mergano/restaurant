/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
