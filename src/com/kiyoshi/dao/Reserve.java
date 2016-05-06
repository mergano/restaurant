package com.kiyoshi.dao;

public interface Reserve {

    public void AddReserve(String reservename, int seat, int tableno);

    public void DeleteReserve(String reservename, int tableno);

    public void EditReserve(String reservename, int seat, int tableno);
}
