package com.kiyoshi.dao;

import com.kiyoshi.bean.ReserveBean;
import com.kiyoshi.core.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ReserveDAO extends ConnectDB implements Reserve {

    private final String table = "reserve";
    private final String history_table = "history";
    private Connection conn;
    private PreparedStatement p = null;
    private ResultSet rs = null;
    private boolean flag;

    public ReserveDAO() {
        try {
            conn = super.getconnection();
        } catch (Exception ex) {
            Logger.getLogger(ReserveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<ReserveBean> getReserveData() {
        ArrayList<ReserveBean> reserve_list = new ArrayList<>();

        if (conn == null) {
            System.err.println("ERROR: NO INTERNET CONNECTION");
            JOptionPane.showMessageDialog(null, "Internet connection is broken or disconnected. \nPlease check your internet connection and try again.", "Communication error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            String sql = "SELECT * FROM " + table + ";";
            try {
                long start = java.lang.System.currentTimeMillis();
                p = conn.prepareStatement(sql);
                rs = p.executeQuery();

                if (rs.next()) {
                    do {
                        ReserveBean bean = new ReserveBean();
                        bean.setReserve_no(rs.getInt("reserve_no"));
                        bean.setReserve_name(rs.getString("reserve_name"));
                        bean.setReserve_seat(rs.getInt("reserve_seat"));
                        bean.setReserve_datetime(rs.getDate("reserve_datetime").toString());
                        reserve_list.add(bean);
                    } while (rs.next());
                    // Benchmark time
                    long stop = java.lang.System.currentTimeMillis();
                    System.out.println("JDBC query reserve list time: " + String.valueOf((stop - start)) + " ms");
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
        return reserve_list;
    }

    @Override
    public boolean AddReserve(ReserveBean bean) {
        flag = false;
        try {
            String sql_insert = "INSERT INTO " + table + " VALUES(?,?,?,CURRENT_TIMESTAMP)";
            p = conn.prepareStatement(sql_insert);
            p.setInt(1, bean.getReserve_no());
            p.setString(2, bean.getReserve_name());
            p.setInt(3, bean.getReserve_seat());
            p.executeUpdate();

            String sql_insert_his = "INSERT INTO " + history_table + " VALUES("
                    + "DEFAULT" + ","
                    + "'Added'" + ","
                    + "'Added reserve No. " + bean.getReserve_no() + "',"
                    + "current_date()" + ","
                    + "current_time()" + ",'"
                    + bean.getGetUserLastModified() + "');";

            p = conn.prepareStatement(sql_insert_his);
            int query_status = p.executeUpdate();
            System.out.println(query_status);
            conn.commit();
            flag = true;
            p.close();
        } catch (SQLException | NumberFormatException e) {
            flag = false;
            System.err.println(e);
        }
        return flag;
    }

    @Override
    public boolean DeleteReserve(ReserveBean bean, int res_no) {
        flag = false;
        try {
            String sql_delete = "DELETE FROM " + table + " WHERE reserve_no =" + res_no + ";";
            String sql_delete_bl = "INSERT INTO " + history_table + " VALUES("
                    + "DEFAULT" + ","
                    + "'Deleted'" + ","
                    + "'Deleted reserve No. " + bean.getReserve_no() + "',"
                    + "current_date()" + ","
                    + "current_time()" + ",'"
                    + bean.getGetUserLastModified() + "');";

            p = conn.prepareStatement(sql_delete);
            p.executeUpdate();
            p = conn.prepareStatement(sql_delete_bl);
            p.executeUpdate();
            conn.commit();
            flag = true;
            p.close();
        } catch (SQLException e) {
            System.err.println(e);
        } catch (Exception e) {
            flag = false;
            System.err.println(e);
        }
        return flag;
    }

    @Override
    public boolean EditReserve(ReserveBean bean, int n) {
        flag = false;
        try {
            String sql_update = "UPDATE " + table + " SET reserve_no =?, reserve_name=?, reserve_seat=? WHERE product_id =" + n + ";";
            p = conn.prepareStatement(sql_update);
            p.setInt(1, bean.getReserve_no());
            p.setString(2, bean.getReserve_name());
            p.setInt(3, bean.getReserve_seat());

            p.executeUpdate();
            String sql_edit_his = "INSERT INTO " + history_table + " VALUES("
                    + "DEFAULT" + ","
                    + "'Edited'" + ","
                    + "'Edited reserve No. " + bean.getReserve_no() + "',"
                    + "current_date()" + ","
                    + "current_time()" + ",'"
                    + bean.getGetUserLastModified() + "');";
            p = conn.prepareStatement(sql_edit_his);
            p.executeUpdate();
            conn.commit();
            flag = true;
            p.close();
        } catch (SQLException e) {
            flag = false;
        }
        return flag;
    }

}
