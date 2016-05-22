package com.kiyoshi.dao;

import com.kiyoshi.bean.BillingBean;
import com.kiyoshi.bean.LoginBean;
import com.kiyoshi.core.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BillingDAO extends ConnectDB {

    private final String table = "kiyoshi.order";
    private final String history_table = "kiyoshi.history";
    private final String stat_table = "kiyoshi.statistic";
    private Connection conn;
    private PreparedStatement p = null;
    private ResultSet rs = null;
    private double totalPrice;
    private double totalVAT;
    private double totalChange;

    public BillingDAO() {
        try {
            conn = super.getconnection();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public double calculate(double cash, int tableno) {

        if (conn == null) {
            System.err.println("ERROR: NO INTERNET CONNECTION");
            JOptionPane.showMessageDialog(null, "Internet connection is broken or disconnected. \nPlease check your internet connection and try again.", "Communication error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            String sql = "SELECT SUM(quantity * price) as total FROM " + table + " WHERE tableno = " + tableno + " AND DATE(create_datetime ) = CURDATE();";
            try {
                p = conn.prepareStatement(sql);
                rs = p.executeQuery();
                if (rs.next()) {
                    do {
                        BillingBean bean = new BillingBean();
                        double raw = rs.getDouble("total");
                        System.out.println(raw);
                        totalVAT = raw * (7 / 100);
                        System.out.println(totalVAT);
                        totalPrice = totalVAT + raw;
                        System.out.println(totalPrice);
                        totalChange = cash - totalPrice;
                        bean.setTotalVAT(totalVAT);
                        bean.setTotalPrice(totalPrice);
                        bean.setTotalChange(totalChange);
                    } while (rs.next());
                } else {
                    // ERROR CODE QUERY ERROR
                }
                conn.commit();
                p.close();
                rs.close();
                conn.close();
            } catch (SQLException e) {
                System.err.print(e);
            }
        }
        return cash;
    }

    public void getPrice(int tableno) {
        if (conn == null) {
            System.err.println("ERROR: NO INTERNET CONNECTION");
            JOptionPane.showMessageDialog(null, "Internet connection is broken or disconnected. \nPlease check your internet connection and try again.", "Communication error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            String sql = "SELECT SUM(quantity * price) as total FROM " + table + " WHERE tableno = " + tableno + " AND DATE(create_datetime) = CURDATE();";
            System.out.println(sql);
            try {
                p = conn.prepareStatement(sql);
                rs = p.executeQuery();
                if (rs.next()) {
                    while (rs.next()) {
                        BillingBean bean = new BillingBean();
                        double raw = rs.getDouble("total");
                        System.out.println(raw);
                        totalVAT = raw * (7 / 100);
                        System.out.println(totalVAT);
                        totalPrice = totalVAT + raw;
                        System.out.println(totalPrice);
                        bean.setTotalVAT(totalVAT);
                        bean.setTotalPrice(totalPrice);
                    }
                } else {
                    // ERROR CODE QUERY ERROR
                }
                conn.commit();
                p.close();
                rs.close();
                conn.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean checkout(double revenue, int tableno) {
        if (conn == null) {
            System.err.println("ERROR: NO INTERNET CONNECTION");
            JOptionPane.showMessageDialog(null, "Internet connection is broken or disconnected. \nPlease check your internet connection and try again.", "Communication error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            String sql = "INSERT INTO " + stat_table + " VALUES(DEFAULT," + revenue + ",current_date());";
            try {
                p = conn.prepareStatement(sql);
                p.executeUpdate();
                String sql_edit_his = "INSERT INTO " + history_table + " VALUES("
                        + "DEFAULT" + ","
                        + "'Checkout Table No. '" + ","
                        + "' No. " + tableno + "',"
                        + "current_date()" + ","
                        + "current_time()" + ",'"
                        + LoginBean.getUsername() + "');";
                p = conn.prepareStatement(sql_edit_his);
                p.executeUpdate();
                conn.commit();
                p.close();
                rs.close();
                conn.close();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return false;
    }
}
