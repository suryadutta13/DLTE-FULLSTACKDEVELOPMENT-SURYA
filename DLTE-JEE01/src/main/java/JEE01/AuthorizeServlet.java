package JEE01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



        import oracle.jdbc.driver.OracleDriver;
        import oracle.jdbc.pool.OracleDataSource;

        import javax.servlet.*;
        import javax.servlet.http.*;
        import javax.servlet.annotation.*;
        import java.io.IOException;
        import java.sql.*;
        import java.util.logging.Level;
        import java.util.logging.Logger;

@WebServlet(name = "AuthorizeServlet", value = "/authenticate")
public class AuthorizeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        String receiveId=request.getParameter("cust_id");
        String receivePin=request.getParameter("password");
        int cust_id=Integer.parseInt(receiveId);
        try {
            Driver driver=new OracleDriver();
            ServletContext obj=request.getServletContext();
            OracleDataSource source=new OracleDataSource();
            source.setUser("system");source.setPassword("1307");
            source.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            obj.setAttribute("connection",source);
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1307");
            String query = "select * from customer where cust_id="+cust_id+" and customer_password='"+receivePin+"'";
            logger.log(Level.INFO,"select * from customer where cust_id="+cust_id+" and customer_password='"+receivePin+"'");
            query = "select * from payee where name='san'";
            query = "select * from customer where cust_id=? and password=?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1, cust_id);
            preparedStatement.setString(2,receivePin);
            logger.log(Level.INFO,""+receiveId+""+receivePin);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                RequestDispatcher dispatcher=request.getRequestDispatcher("dash.jsp");
                logger.log(Level.INFO,"Authenticated");
                System.out.println("Passed "+resultSet.getString("cust_name"));
                request.setAttribute("customer",resultSet.getString("cust_name"));
                dispatcher.forward(request,response);
            }
            else{
                RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
                logger.log(Level.WARNING,"Not Authenticated");
                dispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}