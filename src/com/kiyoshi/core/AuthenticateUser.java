package com.kiyoshi.core;

import com.kiyoshi.bean.LoginBean;
import com.kiyoshi.dao.LoginDAO;

public class AuthenticateUser {

    private static int attemps = 0;
    private final int max = 5;

    public int VerifyUser(String encryptedUser, String encryptedPass) {
        LoginDAO log = new LoginDAO();
        int flag = log.getUser(encryptedUser, encryptedPass);

        switch (flag) {
            case 1:
                if (attemps <= max) {
                    System.out.println("AUTHENTICATE QUERY SUCCESSFUL");
                    if (encryptedUser.equals(LoginBean.getUsername()) && encryptedPass.equals(LoginBean.getPassword()) && LoginBean.getUserType().equals("employee")) {
                        return 1; // LOGIN SUCCESSFUL AS EMPLOYEE LEVEL
                    } else if ((!encryptedUser.equals(LoginBean.getUsername())) || (!encryptedPass.equals(LoginBean.getPassword()))) {
                        attemps++;
                        return -1; // LOGIN FAILED WRONG USER OR PASSWORD
                    }
                    return 1;
                } else {
                    return -2; // BAN THE SYSTEM TEMPORARY
                }
            case 0: // NO INTERNET CONNECTION
                return 0;
            case -3:
                return -3; // UNEXPECTED ERROR
            default:
                break;
        }
        return -1;
    }
}
