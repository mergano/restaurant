package com.kiyoshi.bean;

public class BillingBean {

    private double totalPrice;
    private double totalCash;
    private double totalVAT;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(double totalCash) {
        this.totalCash = totalCash;
    }

    public double getTotalVAT() {
        return totalVAT;
    }

    public void setTotalVAT(double totalVAT) {
        this.totalVAT = totalVAT;
    }

    public double getTotalChange() {
        return totalChange;
    }

    public void setTotalChange(double totalChange) {
        this.totalChange = totalChange;
    }
    private double totalChange;
}
