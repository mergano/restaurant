package com.kiyoshi.bean;

public class ReserveBean {

    private int reserve_no;
    private String reserve_name;
    private int reserve_seat;
    private String getUserLastModified;
    private String reserve_datetime;

    public String getReserve_datetime() {
        return reserve_datetime;
    }

    public void setReserve_datetime(String reserve_datetime) {
        this.reserve_datetime = reserve_datetime;
    }

    public String getGetUserLastModified() {
        return getUserLastModified;
    }

    public void setGetUserLastModified(String getUserLastModified) {
        this.getUserLastModified = getUserLastModified;
    }

    public int getReserve_no() {
        return reserve_no;
    }

    public void setReserve_no(int reserve_no) {
        this.reserve_no = reserve_no;
    }

    public String getReserve_name() {
        return reserve_name;
    }

    public void setReserve_name(String reserve_name) {
        this.reserve_name = reserve_name;
    }

    public int getReserve_seat() {
        return reserve_seat;
    }

    public void setReserve_seat(int reserve_seat) {
        this.reserve_seat = reserve_seat;
    }

}
