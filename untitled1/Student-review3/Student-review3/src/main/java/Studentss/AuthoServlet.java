
package Studentss;
import oracle.jdbc.driver.OracleDriver;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AuthoServlet", value="/insert")
public class AuthoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        int reg_no = Integer.parseInt(request.getParameter("Reg_no"));
        String name = request.getParameter("Name");
        int age = Integer.parseInt(request.getParameter("Age"));
        String email = request.getParameter("Email");
        String Door_No = request.getParameter("Door_No");
        String Locality = request.getParameter("Locality");
        String City = request.getParameter("City");
        int Pincode = Integer.parseInt(request.getParameter("Pincode"));
        String P_Door = request.getParameter("P_Door_No");
        String P_Locality = request.getParameter("P_Locality");
        String P_City = request.getParameter("P_City");
        int P_Pincode = Integer.parseInt(request.getParameter("P_Pincode"));
        logger.log(Level.INFO, reg_no + name + age + email + Door_No + Locality + City + Pincode + P_Door + P_Locality + P_City);
        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1307");
            PreparedStatement preparedStatement = connection.prepareStatement("alter session set current_schema=\"SURYA DUTTA\"");
            preparedStatement.executeQuery();
            preparedStatement = connection.prepareStatement("insert into students values(?,?,?,?)");
            preparedStatement.setInt(1, reg_no);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, email);
            int ex = preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("insert into address1 values(a_id.NEXTVAL,?,?,?,?,'Current')");
            preparedStatement.setString(1, Door_No);
            preparedStatement.setString(2, Locality);
            preparedStatement.setString(3, City);
            preparedStatement.setInt(4, Pincode);
            int mp = preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("insert into Addmap values(?,a_id.CURRVAL)");
            preparedStatement.setInt(1, reg_no);
            int add = preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("insert into address1 values(a_id.NEXTVAL,?,?,?,?,'Permanent')");
            preparedStatement.setString(1, P_Door);
            preparedStatement.setString(2, P_Locality);
            preparedStatement.setString(3, P_City);
            preparedStatement.setInt(4, P_Pincode);
            int map = preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("insert into Addmap values(?,a_id.CURRVAL)");
            preparedStatement.setInt(1, reg_no);
            int t = preparedStatement.executeUpdate();
            if (ex > 0 && mp > 0 && add > 0 && map > 0 && t > 0) {
                logger.log(Level.INFO, "Insertion Successful");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            } else {
                logger.log(Level.INFO, "Insertion Declined");
                RequestDispatcher dispatcher = request.getRequestDispatcher("dash.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<dash.jsp>");

        try {
            // Load the JDBC driver

            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1307");
            PreparedStatement preparedStatement = connection.prepareStatement("alter session set current_schema=\"SURYA DUTTA\"");


            // Execute a query to fetch data
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            // Display the fetched data
            while (rs.next()) {
                out.println("<p>" + rs.getInt("Reg_no") + ", " + rs.getString("Name") + "</p>" + rs.getInt("Age") + "<p>" + rs.getString("Email")  );
            }

            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }

        out.println("</body></html>");
    }
}