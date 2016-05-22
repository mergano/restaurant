package com.kiyoshi.dao;

import com.kiyoshi.bean.OrderBean;
import com.kiyoshi.core.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class OrderDAO extends ConnectDB {

    private final String order_table = "order";
    private final String history_table = "history";
    private Connection conn;
    private PreparedStatement p = null;
    private ResultSet rs = null;
    private boolean flag;

    public OrderDAO() {
        try {
            conn = super.getconnection();
        } catch (Exception ex) {
            Logger.getLogger(FoodDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// Display all data from product table
    public ArrayList<OrderBean> getOrderData(int tableno) {
        ArrayList<OrderBean> order_list = new ArrayList<>();

        if (conn == null) {
            System.err.println("ERROR: NO INTERNET CONNECTION");
            JOptionPane.showMessageDialog(null, "Internet connection is broken or disconnected. \nPlease check your internet connection and try again.", "Communication error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            String sql = "SELECT * FROM " + order_table + " WHERE tableno = " + tableno + ";";
            System.out.println(sql);
            try {
                long start = java.lang.System.currentTimeMillis();
                p = conn.prepareStatement(sql);
                rs = p.executeQuery();

                if (rs.next()) {
                    do {
                        OrderBean bean = new OrderBean();
                        bean.setIdorder(rs.getInt("idorder"));
                        bean.setTableno(rs.getInt("tableno"));
                        bean.setFoodName(rs.getString("food_name"));
                        bean.setQuantity(rs.getInt("quantity"));
                        bean.setPrice(rs.getDouble("price"));
                        bean.setCreateDateTime(rs.getTimestamp("create_datetime"));
                        order_list.add(bean);
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
        return order_list;
    }

// Insert data into product table
    public boolean addOrder(OrderBean bean) {
        flag = false;
        try {
            //String querySetLimit = "SET GLOBAL max_allows_packet = 104857600"; // 10 MB
            //PreparedStatement ps = conn.prepareStatement(querySetLimit);
            //ps.execute();
            String sql_insert = "INSERT INTO " + order_table + " VALUES(DEFAULT,?,?,?,?,current_date());";
            p = conn.prepareStatement(sql_insert);
            p.setInt(2, bean.getTableno());
            p.setString(3, bean.getFoodName());
            p.setInt(4, bean.getQuantity());
            p.setDouble(5, bean.getPrice());
            p.executeUpdate();

            String sql_insert_his = "INSERT INTO " + history_table + " VALUES(DEFAULT,?,?,current_date(),current_time(),?);";
            p = conn.prepareStatement(sql_insert_his);
            p.setString(2, "Added order to Table ");
            p.setObject(3, bean.getTableno());
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
    public boolean editOrder(OrderBean bean, int n) {
        flag = false;
        try {
            String sql_update = "UPDATE " + order_table + " SET idorder =?, tableno=?, food_name=?, quantity=?, price=?, create_datetime=current_date() WHERE idorder =" + n + ";";
            p = conn.prepareStatement(sql_update);
            p.setInt(1, bean.getIdorder());
            p.setInt(2, bean.getTableno());
            p.setString(3, bean.getFoodName());
            p.setInt(4, bean.getQuantity());
            p.setDouble(5, bean.getPrice());
            p.executeUpdate();

            String sql_edit_his = "INSERT INTO " + history_table + " VALUES(DEFAULT,?,?,current_date(),current_time(),?);";
            p = conn.prepareStatement(sql_edit_his);
            p.setString(2, "Edited order table ");
            p.setObject(3, bean.getTableno());
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
    public boolean deleteOrder(OrderBean bean, int n) {
        flag = false;
        try {
            String sql_delete = "DELETE FROM " + order_table + " WHERE idfood =" + n + ";";
            p = conn.prepareStatement(sql_delete);
            p.setString(2, "Cancel order table");
            p.setObject(3, bean.getTableno());
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
