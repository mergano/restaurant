package com.kiyoshi.dao;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ReserveDAO implements Reserve {

    @Override
    public void AddReserve(String reservename, int seat, int tableno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteReserve(String reservename, int tableno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EditReserve(String reservename, int seat, int tableno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<HashMap> getReserveList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        // return product_list;
    }

}