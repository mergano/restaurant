package com.kiyoshi.bean;

public class OrderBean {

    private int idorder;
    private int tableno;
    private String foodname;
    private double price;
    private int quantity;
    private String user;

    public String getCurrentUser() {
        return user;
    }

    public void setCurrentUser(String user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public int getTableno() {
        return tableno;
    }

    public void setTableno(int tableno) {
        this.tableno = tableno;
    }

    public String getFoodName() {
        return foodname;
    }

    public void setFoodName(String food_name) {
        this.foodname = food_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
