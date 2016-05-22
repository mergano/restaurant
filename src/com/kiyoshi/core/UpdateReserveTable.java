package com.kiyoshi.core;

import com.kiyoshi.bean.HistoryBean;
import com.kiyoshi.bean.ReserveBean;
import com.kiyoshi.dao.HistoryDAO;
import com.kiyoshi.gui.Main;
import java.util.ArrayList;
import java.util.List;

public class UpdateReserveTable extends Main implements UpdateTable {

    public UpdateReserveTable(String username) {
        super(username);
    }

    public UpdateReserveTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateReserveTable(ArrayList<ReserveBean> list) {
        String[] columns = {"Reserve No.", "Reserve Name", "Seat", "Datetime"};
        Object[][] rows = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getReserve_no();
            rows[i][1] = list.get(i).getReserve_name();
            rows[i][2] = list.get(i).getReserve_seat();
            rows[i][3] = list.get(i).getReserve_datetime();
        }
        // set Model of JTabel from list array of data
        reserve_table.setModel(new javax.swing.table.DefaultTableModel(rows, columns));
        reserve_table.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        reserve_table.getColumnModel().getColumn(0).setPreferredWidth(30);
        reserve_table.getColumnModel().getColumn(1).setPreferredWidth(80);
        reserve_table.getColumnModel().getColumn(2).setPreferredWidth(45);
        reserve_table.getColumnModel().getColumn(3).setPreferredWidth(80);
        initialReserveNo();
        // set the JTable into scroll panel
        ScrollPanelForQueryTable.setViewportView(reserve_table);
        System.out.println("Reserve table updated");
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
