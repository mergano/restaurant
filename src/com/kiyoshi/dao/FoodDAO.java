package com.kiyoshi.dao;

import com.kiyoshi.bean.FoodBean;
import com.kiyoshi.core.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FoodDAO extends ConnectDB {

    private final String food_table = "food";
    private final String history_table = "history";
    private Connection conn;
    private PreparedStatement p = null;
    private ResultSet rs = null;
    private boolean flag;

    public FoodDAO() {
        try {
            conn = super.getconnection();
        } catch (Exception ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// Display all data from product table
    public ArrayList<FoodBean> getData() {
        ArrayList<FoodBean> food_list = new ArrayList<>();

        if (conn == null) {
            System.err.println("ERROR: NO INTERNET CONNECTION");
            JOptionPane.showMessageDialog(null, "Internet connection is broken or disconnected. \nPlease check your internet connection and try again.", "Communication error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            String sql = "SELECT idfood, category, name, price, quantity, status, image_name FROM " + food_table + " ORDER BY " + "category;";
            try {
                long start = java.lang.System.currentTimeMillis();
                p = conn.prepareStatement(sql);
                rs = p.executeQuery();

                if (rs.next()) {
                    do {
                        FoodBean bean = new FoodBean();
                        bean.setIdfood(rs.getInt("idfood"));
                        bean.setCategory(rs.getString("category"));
                        bean.setName(rs.getString("name"));
                        bean.setPrice(rs.getDouble("price"));
                        bean.setQuantity(rs.getInt("quantity"));
                        bean.setStatus(rs.getString("status"));
                        bean.setImage_name(rs.getString("image_name"));
                        food_list.add(bean);
                    } while (rs.next());
                    // Benchmark time
                    long stop = java.lang.System.currentTimeMillis();
                    System.out.println("JDBC query food table time: " + String.valueOf((stop - start)) + " ms");
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
        return food_list;
    }

// Insert data into product table
    public boolean insertFood(FoodBean bean) {
        flag = false;
        try {
            //String querySetLimit = "SET GLOBAL max_allows_packet = 104857600"; // 10 MB
            //PreparedStatement ps = conn.prepareStatement(querySetLimit);
            //ps.execute();
            String sql_insert = "INSERT INTO " + food_table + " VALUES(?,?,?,?,?,?,?);";
            p = conn.prepareStatement(sql_insert);
            p.setInt(1, bean.getIdfood());
            p.setString(2, bean.getCategory());
            p.setString(3, bean.getName());
            p.setDouble(4, bean.getPrice());
            p.setInt(5, bean.getQuantity());
            p.setString(6, bean.getStatus());
            p.setString(7, bean.getImage_name());
            p.executeUpdate();

            String sql_insert_his = "INSERT INTO " + history_table + " VALUES(DEFAULT,?,?,current_date(),current_time(),?);";
            p = conn.prepareStatement(sql_insert_his);
            p.setString(2, "Added food");
            p.setString(3, bean.getName());
            p.setString(6, bean.getCurrentUser());
            p.executeUpdate();
            conn.commit();

            flag = true;
            p.close();
        } catch (SQLException | NumberFormatException e) {
            flag = false;
            System.err.println(e);
        }
        return flag;
    }

    // Update data into product table
    public boolean updateFood(FoodBean bean, long n) {
        flag = false;
        try {
            String sql_update = "UPDATE " + food_table + " SET product_id =?,category=?,manufacture=?,name=?,model=?,description=?,cost=?,location=?,warranty=?,quantity=?,import_date=?,status_?,user_lastmodified=?,image=? WHERE product_id =" + n + ";";
            p = conn.prepareStatement(sql_update);
            p.setInt(1, bean.getIdfood());
            p.setString(2, bean.getCategory());
            p.setString(3, bean.getName());
            p.setDouble(4, bean.getPrice());
            p.setInt(5, bean.getQuantity());
            p.setString(6, bean.getStatus());
            p.setString(7, bean.getImage_name());
            p.executeUpdate();

            String sql_edit_his = "INSERT INTO " + history_table + " VALUES(DEFAULT,?,?,current_date(),current_time(),?);";
            p = conn.prepareStatement(sql_edit_his);
            p.setString(2, "Update food");
            p.setString(3, bean.getName());
            p.setString(6, bean.getCurrentUser());
            p.executeUpdate();
            conn.commit();

            flag = true;
            p.close();
        } catch (SQLException e) {
            flag = false;
        }
        return flag;
    }

    // Delete data from database
    public boolean deleteData(FoodBean bean, int n) {
        flag = false;
        try {
            String sql_delete = "DELETE FROM " + food_table + " WHERE idfood =" + n + ";";
            p = conn.prepareStatement(sql_delete);
            p.setString(2, "Delete food");
            p.setString(3, bean.getName());
            p.setString(6, bean.getCurrentUser());
            p.executeUpdate();

            String sql_delete_his = "INSERT INTO " + history_table + " VALUES(DEFAULT,?,?,current_date(),current_time(),?);";
            p = conn.prepareStatement(sql_delete_his);
            p.executeUpdate();
            conn.commit();

            flag = true;
            p.close();
        } catch (SQLException e) {
            flag = false;
            System.err.println(e);
        }
        return flag;
    }
}

// DEBUG CODE
//           ResultSetMetaData metadata = (ResultSetMetaData) rs.getMetaData();
//           int cols = metadata.getColumnCount();
//           String columnNames[] = new String[cols];
//           for(int i=1; i<= cols; i++){
//               System.out.println(metadata.getColumnLabel(i));
//           }

