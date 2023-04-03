package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "InsertionServlet" )
public class InsertionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String name = request.getParameter("Name");
        String email = request.getParameter("email");
        String pan = request.getParameter("pan");
        int contact = Integer.parseInt(request.getParameter("contact"));
        String Pin = request.getParameter("pin");
    }
}
