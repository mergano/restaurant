package com.kiyoshi.core;

import com.kiyoshi.dao.BillingDAO;
import com.kiyoshi.gui.Main;
import javax.swing.JOptionPane;

public class Checkout extends Main {

    public Checkout(String username) {
        super(username);
    }

    public void checkout() {
        if (Double.parseDouble(cash_input_box.getText()) < Double.parseDouble(total_price.getText())) {
            JOptionPane.showMessageDialog(null, "Cash amount can't less than the total price.", "Cash amount input error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            BillingDAO bill = new BillingDAO();
            boolean result = bill.checkout(Double.parseDouble(total_price.getText()), Integer.parseInt(table_no_billing_input.getText()));
            if (result) {
                JOptionPane.showMessageDialog(null, "Check out successfully", "Checkout completed",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                table_no_billing_input.setText("");
                total_vat.setText("");
                total_price.setText("");
                cash_input_box.setText("");
                change_box.setText("");
            }
        }
    }
}
