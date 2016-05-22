package com.kiyoshi.dao;

import com.kiyoshi.bean.HistoryBean;
import com.kiyoshi.core.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HistoryDAO {

    private ConnectDB connect;
    private Connection conn;
    private PreparedStatement p = null;
    private ResultSet rs = null;
    private final String history_table = "kiyoshi.history";
    private String sql;

    public HistoryDAO() {
        try {
            connect = new ConnectDB();
            conn = connect.getconnection();
        } catch (Exception ex) {
            Logger.getLogger(HistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // get history data from history table
    public ArrayList<HistoryBean> getHistoryData() {
        ArrayList<HistoryBean> list = new ArrayList<>();
        sql = "SELECT * FROM " + history_table + ";";
        if (conn == null) {
            System.out.print("ERROR NO CONNECTION");
        }

        try {
            p = conn.prepareStatement(sql);
            rs = p.executeQuery();
            conn.commit();
            while (rs.next()) {
                HistoryBean bean = new HistoryBean();
                bean.setHistoryID(rs.getInt("id_his"));
                bean.setActionType(rs.getString("action_type"));
                bean.setActionDetail(rs.getString("detail"));
                bean.setHistoryDate(rs.getDate("modified_date").toString());
                bean.setHistoryTime(rs.getTime("modified_time").toString());
                bean.setUser(rs.getString("modified_user"));
                list.add(bean);
            }
            p.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public void truncateHistory() {
        try {
            sql = "TRUNCATE " + history_table + ";";
            p = conn.prepareStatement(sql);
            p.executeUpdate();
            conn.commit();
            p.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}
