/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiyoshi.dao;

import java.util.List;
import javax.sql.DataSource;

public interface EmployeeDAO {

    /**
     * This is the method to be used to initialize database resources ie.
     * connection.
     *
     * @param ds
     */
    public void setDataSource(DataSource ds);

    /**
     * This is the method to be used to create a record in the Student table.
     *
     * @param name
     * @param age
     */
    public void create(String name, Integer age);

    /**
     * This is the method to be used to list down a record from the Student
     * table corresponding to a passed student id.
     *
     * @param id
     * @return
     */
    public Employee getEmployee(Integer id);

    /**
     * This is the method to be used to list down all the records from the
     * Student table.
     *
     * @return
     */
    public List<Employee> listEmployee();

    /**
     * This is the method to be used to delete a record from the Student table
     * corresponding to a passed student id.
     *
     * @param id
     */
    public void delete(Integer id);

    /**
     * This is the method to be used to update a record into the Student table.
     *
     * @param id
     * @param age
     */
    public void update(Integer id, Integer age);

    public static class Employee {

        public Employee() {
        }
    }
}
