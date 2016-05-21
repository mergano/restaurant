/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiyoshi.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface Employee {

    public void createEmp(String name, Integer age);

    public int getEmployee(Integer id);

    public ArrayList<HashMap> listEmployee();

    public void deleteEmp(Integer id);

    public void updateEmp(Integer id, Integer age);
}
