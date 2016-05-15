/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiyoshi.dao;

import com.kiyoshi.core.ConnectDB;
import com.kiyoshi.core.InternetStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDAO extends MainDAO implements Order {

    private final String table = "order";
    private ConnectDB c;
    private Connection conn;
    private PreparedStatement p = null;
    private ResultSet rs = null;

    private OrderDAO() {
        try {
            c = new ConnectDB();
            conn = c.getconnection();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        if (InternetStatus.getInternetDisconnect() || conn == null) {
            System.out.println("No internet connection");
        }
    }

    @Override
    public void AddOrder(String ordername, int amount, int tableno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteOrder(String ordername, int tableno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EditOrder(String ordername, int amount, int tableno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
