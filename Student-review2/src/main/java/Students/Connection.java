package Students;
import oracle.jdbc.OracleDriver;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


class IterateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1307");
            String query="select * from student";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            //connection.close();
            Students student=null;
            List<Students> profiles=new ArrayList<Students>();
            while(resultSet.next()){
                student=new Students();
                student.setReg_no(resultSet.getInt("Reg number"));
                student.setName(resultSet.getString("Student name"));
                student.setAge(resultSet.getInt("Students_age"));
                student.setEmail(resultSet.getString("student_email"));
                InputStream inputStream=resultSet.getBinaryStream("address");
                byte[] tempBinary=new byte[inputStream.available()];
                inputStream.read(tempBinary);
                String address=new String(tempBinary);
                student.setAddress(address);
                profiles.add(student);
            }
            RequestDispatcher dispatcher=request.getRequestDispatcher("available.jsp");
            request.setAttribute("dbData",profiles);
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}