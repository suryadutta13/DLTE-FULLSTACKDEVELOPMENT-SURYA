package org.example;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;

public class DAOoperations {
    private Driver driver;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;
    private ResultSet resultSet;

    public DAOoperations() {
        try {
            driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1307");
            preparedStatement = connection.prepareStatement("alter session set current_schema=\"SURYA DUTTA\"");
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertDb(Admin admin) {
        try {
            preparedStatement = connection.prepareStatement("insert into admin values(?,?,?,?)");
            preparedStatement.setString(1, admin.getUsername());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setString(3, admin.getFullname());
            preparedStatement.setInt(4, admin.getAge());
            int ex = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Customer> fetch(){
        ArrayList<Customer> customers=new ArrayList<>();
        try {
            preparedStatement=connection.prepareStatement("Select * from customers ");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int customerId=resultSet.getInt("customerId");
                String customerName=resultSet.getString("customerName");
                String email=resultSet.getString("email");
                String pan=resultSet.getString("pan");
                int contact=resultSet.getInt("contact");
                String pin=resultSet.getString("pin");
                Customer customer=new Customer(customerId,customerName,email,pan,contact,pin);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public String authenticate(String username, String password) {
        try {
            preparedStatement = connection.prepareStatement("select * from admin where username=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("fullname");
            }
            else{
                return "No user available";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}