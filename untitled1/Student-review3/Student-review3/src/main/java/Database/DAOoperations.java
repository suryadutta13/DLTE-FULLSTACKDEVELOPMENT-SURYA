//package Database;
//
//import oracle.jdbc.driver.OracleDriver;
//
//import javax.swing.*;
//import java.sql.*;
//
//public class DAOoperations {
//    private Driver driver;
//    private Connection connection;
//    private PreparedStatement preparedStatement;
//
//    public DAOoperations(){
//        try {
//            driver = new OracleDriver();
//            DriverManager.registerDriver(driver);
//            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1307");
//            preparedStatement = connection.prepareStatement("alter session set current_schema=\"SURYA DUTTA\"");
//            preparedStatement.executeQuery();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public List<insert> insertData(){
//        try {
//            preparedStatement = connection.prepareStatement("insert into students values(?,?,?,?)");
//            preparedStatement.setInt(1, reg_no);
//            preparedStatement.setString(2, name);
//            preparedStatement.setInt(3, age);
//            preparedStatement.setString(4, email);
//            int ex = preparedStatement.executeUpdate();
//            preparedStatement = connection.prepareStatement("insert into address1 values(a_id.NEXTVAL,?,?,?,?,'Current')");
//            preparedStatement.setString(1, Door_No);
//            preparedStatement.setString(2, Locality);
//            preparedStatement.setString(3, City);
//            preparedStatement.setInt(4, Pincode);
//            int mp = preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
