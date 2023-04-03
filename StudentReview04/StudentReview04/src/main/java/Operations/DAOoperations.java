package Operations;



import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

public class DAOoperations {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public DAOoperations() {
        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1307");
            preparedStatement = connection.prepareStatement("alter session set current_schema=\"SURYA DUTTA\"");
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public Integer insert(Student student){
        int add=0;
            try {
                preparedStatement = connection.prepareStatement("insert into students values(?,?,?,?)");
                preparedStatement.setInt(1, student.getReg_no());
                preparedStatement.setString(2, student.getName());
                preparedStatement.setInt(3, student.getAge());
                preparedStatement.setString(4, student.getEmail());
                add +=preparedStatement.executeUpdate();
                for (Address address : student.getAddress()) {
                    preparedStatement = connection.prepareStatement("insert into address1 values(ade_seq.NEXTVAL,?,?,?,?,?)");
                    preparedStatement.setInt(1, address.getDoor_no());
                    preparedStatement.setString(2, address.getLocality());
                    preparedStatement.setString(3, address.getCity());
                    preparedStatement.setInt(4, address.getPincode());
                    preparedStatement.setString(5, address.getType());
                    preparedStatement.executeUpdate();
                    preparedStatement = connection.prepareStatement("insert into addmap values(?,ade_seq.CURRVAL)");
                    preparedStatement.setInt(1, student.getReg_no());
                    add += preparedStatement.executeUpdate();

                }

            } catch (SQLException ex) {

                ex.printStackTrace();


            }
            return  add;
        }
    }

