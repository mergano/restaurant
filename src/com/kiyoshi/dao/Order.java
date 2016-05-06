/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiyoshi.dao;

/**
 *
 * @author vchuk
 */
public interface Order {

    public void AddOrder(String ordername, int amount, int tableno);

    public void DeleteOrder(String ordername, int tableno);

    public void EditOrder(String ordername, int amount, int tableno);

}
