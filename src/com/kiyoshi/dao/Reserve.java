package com.kiyoshi.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface Reserve {

    public void AddReserve(String reservename, int seat, int tableno);

    public void DeleteReserve(String reservename, int tableno);

    public void EditReserve(String reservename, int seat, int tableno);

    public ArrayList<HashMap> getReserveList();
}
