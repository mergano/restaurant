package com.kiyoshi.core;

import com.kiyoshi.bean.LoginBean;
import com.kiyoshi.dao.LoginDAO;

public class AuthenticateUser {

    public int VerifyUser(String encryptedUser, String encryptedPass) {
        LoginDAO log = new LoginDAO();
        int flag = log.getUser(encryptedUser, encryptedPass);
        switch (flag) {
            case 1:
                System.out.println("AUTHENTICATE QUERY SUCCESSFUL");
                if (encryptedUser.equals(LoginBean.getUsername()) && encryptedPass.equals(LoginBean.getPassword()) && LoginBean.getUserType().equals("employee")) {
                    return 1; // LOGIN SUCCESSFUL AS EMPLOYEE LEVEL
                } else if ((!encryptedUser.equals(LoginBean.getUsername())) || (!encryptedPass.equals(LoginBean.getPassword()))) {
                    return -1; // LOGIN FAILED WRONG USER OR PASSWORD
                }
                return 1;
            case 0: // NO INTERNET CONNECTION
                return 0;
            case -1:
                return -1; // LOGIN FAILED WRONG USER OR PASSWORD
            default:
                break;
        }
        return -1;
    }
}
