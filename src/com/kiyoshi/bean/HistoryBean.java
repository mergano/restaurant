/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiyoshi.bean;

public class HistoryBean {

    // History table
    private int HistoryID;
    private String ActionType;
    private String ActionDetail;
    private String HistoryDate;
    private String HistoryTime;
    private String user;

    // Setter and Getter for backlog data
    public int getHistoryID() {
        return HistoryID;
    }

    public void setHistoryID(int HistoryID) {
        this.HistoryID = HistoryID;
    }

    public String getActionType() {
        return ActionType;
    }

    public void setActionType(String ActionType) {
        this.ActionType = ActionType;
    }

    public String getActionDetail() {
        return ActionDetail;
    }

    public void setActionDetail(String ActionDetail) {
        this.ActionDetail = ActionDetail;
    }

    public String getHistoryDate() {
        return HistoryDate;
    }

    public void setHistoryDate(String HistoryDate) {
        this.HistoryDate = HistoryDate;
    }

    public String getHistoryTime() {
        return HistoryTime;
    }

    public void setHistoryTime(String HistoryTime) {
        this.HistoryTime = HistoryTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
