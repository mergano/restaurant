package com.kiyoshi.dao;

import com.kiyoshi.bean.LoginBean;
import com.kiyoshi.core.ConnectDB;
import com.kiyoshi.core.Encryption;
import com.kiyoshi.core.InternetStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAO extends ConnectDB {

    private final String table = "user";
    private Connection conn;
    private PreparedStatement p = null;
    private ResultSet rs = null;

    public LoginDAO() {
        try {
            conn = super.getconnection();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public int getUser(String users, String passwd) {
        if (InternetStatus.getInternetDisconnect() || conn == null) {
            return 0;
        }
        String sql = "SELECT username, password, type, email, type FROM " + table + " WHERE username =? AND password =? ;";
        String decryptUser;
        try {
            p = conn.prepareStatement(sql);
            p.setString(1, users);
            p.setString(2, passwd);
            rs = p.executeQuery();
            while (rs.next()) {
                LoginBean bean = new LoginBean();
                bean.setUsername(rs.getString("username"));
                bean.setPassword(rs.getString("password"));
                bean.setUserType(rs.getString("type"));
                bean.setUserEmail(rs.getString("email"));
                decryptUser = Encryption.decrypt(rs.getString("username"));
                bean.setUserTxt(decryptUser);
            }
            //Clean-up environment
            conn.commit();
            p.close();
            rs.close();
            conn.close();
            System.out.println("=== CLOSED CONNECTION SUCCESSFULLY ===");
            return 1; // Query success
        } catch (SQLException se) {
            try {
                System.err.println(se);
                conn.close();
                return -3; // SQL Error
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return -1; // Wrong username or password
    }
}
