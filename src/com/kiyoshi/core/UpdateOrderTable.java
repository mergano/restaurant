package com.kiyoshi.core;

import com.kiyoshi.bean.HistoryBean;
import com.kiyoshi.bean.OrderBean;
import com.kiyoshi.dao.HistoryDAO;
import com.kiyoshi.gui.Main;
import java.util.ArrayList;
import java.util.List;

public class UpdateOrderTable extends Main implements UpdateTable {

    public UpdateOrderTable(String username) {
        super(username);
    }

    public UpdateOrderTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateOrderTable(ArrayList<OrderBean> list) {
        String[] columns = {"Order ID", "Name", "Quantity", "Price", "Datetime"};
        Object[][] rows = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getIdorder();
            rows[i][1] = list.get(i).getFoodName();
            rows[i][2] = list.get(i).getQuantity();
            rows[i][3] = list.get(i).getPrice();
            rows[i][4] = list.get(i).getDatetime();
        }
        // set Model of JTabel from list array of data
        order_list_table.setModel(new javax.swing.table.DefaultTableModel(rows, columns));
        order_list_table.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        order_list_table.getColumnModel().getColumn(0).setPreferredWidth(10);
        order_list_table.getColumnModel().getColumn(1).setPreferredWidth(30);
        order_list_table.getColumnModel().getColumn(2).setPreferredWidth(30);
        order_list_table.getColumnModel().getColumn(3).setPreferredWidth(30);
        order_list_table.getColumnModel().getColumn(3).setPreferredWidth(30);
        super.initialReserveNo();
        // set the JTable into scroll panel
        ScrollPanelForQueryTable.setViewportView(order_list_table);
        System.out.println("Order list table updated");
    }

    @Override
    public void updateHistory(ArrayList<HistoryBean> list) {
        List<String[]> values = new ArrayList<>();
        List<String> columns = new ArrayList<>();
        HistoryDAO dao = new HistoryDAO();
        try {
            list = dao.getHistoryData();
        } catch (Exception e) {
        }

        columns.add("History ID");
        columns.add("Type");
        columns.add("Action detail");
        columns.add("Date modified");
        columns.add("Time");
        columns.add("Username");

        for (int i = 0; i < list.size(); i++) {
            values.add(new String[]{""
                + list.get(i).getHistoryID(),
                list.get(i).getActionType(),
                list.get(i).getActionDetail(),
                list.get(i).getHistoryDate(),
                list.get(i).getHistoryTime(),
                list.get(i).getUser()
            });
        }
        history_table.setModel(new javax.swing.table.DefaultTableModel(values.toArray(new Object[][]{}), columns.toArray()));
        ScrollPanelForHistory.setViewportView(history_table);
        clear_history_menuitem.setEnabled(true);
        System.out.println("History table updated");
    }
}
