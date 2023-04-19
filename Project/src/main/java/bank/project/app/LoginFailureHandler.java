package bank.project.app;

import bank.project.dao.BankService;
import bank.project.dao.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@Configuration
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    BankService bankService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ResourceBundle bundle = ResourceBundle.getBundle("msg");
        String userName=request.getParameter("username");
        Customer customer= bankService.getByUsername(userName);
        if(customer!=null) {
            bankService.decreaseAttempts(customer.getCustomerId());
            int attempts = bankService.getAttempts(customer.getCustomerId());
            if(attempts==2){
                logger.info(bundle.getString("inPass")+bundle.getString("attempt1"));
                super.setDefaultFailureUrl("/web/login?error=" + bundle.getString("inPass")+bundle.getString("attempt1"));

            }
            else if(attempts==1){
                logger.info(bundle.getString("inPass") + bundle.getString("attempt2"));
                super.setDefaultFailureUrl("/web/login?error=" + bundle.getString("inPass")+bundle.getString("attempt2"));
            }
            else {
                logger.info(bundle.getString("inactive"));
                super.setDefaultFailureUrl("/web/login?error=" + bundle.getString("inactive"));
            }
// exception = new LockedException("Incorrect Password");
// super.setDefaultFailureUrl("/web/login?error="+"Incorrect Password..");
        }
        else {
            logger.info(exception);
            super.setDefaultFailureUrl("/web/login?error=" +bundle.getString("notExist") );
        }
        super.onAuthenticationFailure(request, response, exception);
    }
}

