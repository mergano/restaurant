package com.kiyoshi.core;

import com.kiyoshi.bean.FoodBean;
import com.kiyoshi.bean.HistoryBean;
import com.kiyoshi.dao.HistoryDAO;
import com.kiyoshi.gui.Main;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class UpdateFoodTable extends Main implements UpdateTable {

    public UpdateFoodTable(String username) {
        super(username);
    }

    public UpdateFoodTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateFoodTable(ArrayList<FoodBean> list) {
        String[] columns = {"#", "Category", "Name", "Price", "Status", "Image"};
        Object[][] rows = new Object[list.size()][14];
        for (int i = 0; i < list.size(); i++) {
            //values.add(new Object[] {
            rows[i][0] = list.get(i).getIdfood();
            rows[i][1] = list.get(i).getCategory();
            rows[i][2] = list.get(i).getName();
            rows[i][3] = list.get(i).getPrice();
            rows[i][4] = list.get(i).getStatus();
            if (list.get(i).getFImage() != null) {
                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getFImage()).getImage().getScaledInstance(60, 20, Image.SCALE_SMOOTH));
                rows[i][5] = list.get(i).getFImage();
            } else {
                rows[i][5] = null;
            }
        }
        // set Model of JTabel from list array of data
        food_table.setModel(new javax.swing.table.DefaultTableModel(rows, columns));
        food_table.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        food_table.getColumnModel().getColumn(0).setPreferredWidth(10);
        food_table.getColumnModel().getColumn(1).setPreferredWidth(30);
        food_table.getColumnModel().getColumn(2).setPreferredWidth(30);
        food_table.getColumnModel().getColumn(3).setPreferredWidth(30);
        food_table.getColumnModel().getColumn(4).setPreferredWidth(30);
        food_table.getColumnModel().getColumn(5).setPreferredWidth(100);

        if (food_table.getRowCount() == 0) {
            add_order_button.setEnabled(false);
        }
        // set the JTable into scroll panel
        ScrollPanelForQueryTable.setViewportView(food_table);
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
