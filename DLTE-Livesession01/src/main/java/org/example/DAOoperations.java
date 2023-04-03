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

    public void InsertDb(int customerId, String name, int age, String email) {
        try {
            preparedStatement = connection.prepareStatement("insert into Customers values(?,?,?,?)");
            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, email);
            int ex = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public String authenticate(String username,String password) {
        try {
            preparedStatement = connection.prepareStatement("select * from admin where username=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                resultSet.getString("username");
                resultSet.getString("password");
                return resultSet.getString("fullname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;
    }
//
//    public ArrayList<Loan> fetch() throws SQLException {
//        query = "Select * from Loans where ";
//    }


}
