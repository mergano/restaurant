/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiyoshi.dao;

import com.kiyoshi.bean.StatusBean;
import com.kiyoshi.core.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author vchuk
 */
public class TableDAO {

    private ConnectDB connect;
    private Connection conn;
    private PreparedStatement p = null;
    private ResultSet rs = null;
    private boolean flag;

    public TableDAO() {
        try {
            connect = new ConnectDB();
            conn = connect.getconnection();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

// Display all data from product table
    public ArrayList<HashMap> getTable() {
        ArrayList<HashMap> table_list = new ArrayList<>();

        if (conn == null) {
            System.err.println("ERROR: NO INTERNET CONNECTION");
            JOptionPane.showMessageDialog(null, "Internet connection is broken or disconnected. \nPlease check your internet connection and try again.", "Communication error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            String sql = "SELECT table_no,table_status,table_seat FROM " + StatusBean.getDbName() + ".table ORDER BY table_no ASC;";
            System.out.println(sql);
            try {
                long start = java.lang.System.currentTimeMillis();
                p = conn.prepareStatement(sql);
                rs = p.executeQuery();
                ResultSetMetaData md = rs.getMetaData();
                int columns = md.getColumnCount();
                System.out.println("column no: " + columns);
                if (rs.next()) {
                    // If have table create hashmap
                    HashMap<String, Object> map = new HashMap<>(columns); // store keyname as string and value as object
                    do {
                        for (int i = 1; i <= columns; i++) {
                            map.put(md.getColumnName(i), rs.getObject(i));
                        }
                        //System.out.println(rs.getInt("table_no") + " " + rs.getString("table_status") + " " + rs.getInt("table_seat"));
//            HashMap<String, Object> hashMap = new HashMap<>();
//            hashMap.put("qty", order.get("quantity"));
//            hashMap.put("foodName", data.get("foodName"));
//            hashMap.put("total", Integer.parseInt(String.valueOf(order.get("quantity"))) * Integer.parseInt(String.valueOf(data.get("price"))));
                        table_list.add(map);
                        System.out.println("MAP 1:" + Arrays.asList(map)); // method 1
                        System.out.println("MAP 2:" + Collections.singletonList(map)); // method 2
                    } while (rs.next());
//                        bean.setProductID(rs.getLong("table_no"));
//                        bean.setCategory(rs.getString("table_status"));
//                        bean.setManufacture(rs.getString("table_seat"));
                    // Benchmark time
                    long stop = java.lang.System.currentTimeMillis();
                    System.out.println("JDBC query table time: " + String.valueOf((stop - start)) + " ms");
                } else {
                    // ERROR CODE QUERY ERROR
                }
                p.close();
                rs.close();
                conn.close();
            } catch (Exception e) {
                System.err.print(e);
            }
        }
        return table_list;
    }

    public void printTable() {
//        for (int i = 0; i < getTable().size(); i++) {
//            System.out.println(getTable().get(i)); //prints element i
//        }
    }

}
