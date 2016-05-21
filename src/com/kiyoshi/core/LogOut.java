package com.kiyoshi.core;

import com.kiyoshi.gui.Main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LogOut {

    public static void logout_confirm() {
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure do you want to logout?", "Logout confirmation", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                Restart.restartApplication(null);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
