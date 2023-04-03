package Students;

import Operations.Address;
import Operations.DAOoperations;
import Operations.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "InsertionServlet" ,value="/insert")
public class InsertionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        int reg_no = Integer.parseInt(request.getParameter("Reg_no"));
        String name = request.getParameter("Name");
        int age = Integer.parseInt(request.getParameter("Age"));
        String email = request.getParameter("Email");
        int Door_No = Integer.parseInt(request.getParameter("Door_No"));
        String Locality = request.getParameter("Locality");
        String City = request.getParameter("City");
        int Pincode = Integer.parseInt(request.getParameter("Pincode"));
        int P_Door = Integer.parseInt(request.getParameter("P_Door_No"));
        String P_Locality = request.getParameter("P_Locality");
        String P_City = request.getParameter("P_City");
        int P_Pincode = Integer.parseInt(request.getParameter("P_Pincode"));
        Student student = new Student(reg_no, name, age, email);

        student.getAddress().add(new Address(Door_No, Locality, City, Pincode,"Current"));
        student.getAddress().add(new Address(P_Door, P_Locality, P_City, P_Pincode,"Permanent"));
        DAOoperations daOoperations=new DAOoperations();
        if(daOoperations.insert(student)!=3){
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            request.setAttribute("status","Insertion Unsuccessful");
            dispatcher.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
