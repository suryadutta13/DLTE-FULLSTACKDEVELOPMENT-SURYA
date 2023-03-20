package Students;

import java.sql.*;
import java.util.Scanner;

//creation of class details
public class details implements StudentEvents {

    Scanner scanner = new Scanner(System.in);
    Connection cn;
    PreparedStatement preparedStatement;
//constructor
    details() throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        cn = DriverManager.getConnection(oracleUrl,"system","1307");
        preparedStatement = cn.prepareStatement("alter session set current_schema=\"SURYA DUTTA\"");
        //preparedStatement.setString(1,"SURYA DUTTA");
        preparedStatement.executeQuery();
        System.out.println("Connected");
    }

    //insertion of data into the table
    @Override
    public void insertData() throws SQLException {
        Students st = new Students();
        System.out.println("Enter the Register No.:");
        st.setReg_no(scanner.nextInt());
        System.out.println("Enter the Name:");
        scanner.nextLine();
        st.setName(scanner.nextLine());
        System.out.println("Enter the Age:");
        st.setAge(scanner.nextInt());
        System.out.println("Enter the Email ID:");
        scanner.nextLine();
        st.setEmail(scanner.nextLine());
        System.out.println("Enter the Door No:");
        st.setDoor_no(scanner.nextLine());
        System.out.println("Enter the Locality");
        st.setLocality(scanner.nextLine());
        System.out.println("Enter the City:");
        st.setCity(scanner.nextLine());
        System.out.println("Enter the Pincode:");
        st.setPincode(scanner.nextInt());
        scanner.nextLine();
        insertDBS(st);
    }

    @Override
    public void insertDBS(Students student) throws SQLException {
        preparedStatement = cn.prepareStatement("insert into student values(?,?,?,?,sq_no.NEXTVAL)");
        preparedStatement.setInt(1,student.getReg_no());
        preparedStatement.setString(2,student.getName());
        preparedStatement.setInt(3,student.getAge());
        preparedStatement.setString(4,student.getEmail());


        int x =preparedStatement.executeUpdate();
        preparedStatement = cn.prepareStatement("insert into address values(sq_no.CURRVAL,?,?,?,?)");
        preparedStatement.setString(1,student.getDoor_no());
        preparedStatement.setString(2,student.getLocality());
        preparedStatement.setString(3,student.getCity());
        preparedStatement.setInt(4,student.getPincode());
//        preparedStatement.setInt(5,sq_no.CURRVAL);
        int y = preparedStatement.executeUpdate();
        if(x>0&&y>0){
            System.out.println("Insertion successful");
        }
        else {
            System.out.println("Insertion declined");
        }
    }



    @Override
    public void displayData() throws SQLException {
        preparedStatement = cn.prepareStatement("select * from student,address where add_id=address_id");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt("reg_no")+" "+rs.getString("name")+" "+rs.getInt("age")+" "+rs.getString("email")+" "+rs.getString("door_number")+" "+rs.getString("locality")+" "+rs.getString("city")+" "+rs.getInt("pincode"));
        }
    }
    @Override
    public void deleteData() throws SQLException {
        System.out.println("Enter student register number");
        deleteDB(scanner.nextInt());
    }
//delete rows from table
    @Override
    public void deleteDB(int regNo) throws SQLException {
        preparedStatement = cn.prepareStatement("delete from students where reg_no=?");
        preparedStatement.setInt(1,regNo);
        if(preparedStatement.executeUpdate()>0){
            System.out.println("Deletion Successful");
        }
        else {
            System.out.println("Insertion declined");
        }
    }
}