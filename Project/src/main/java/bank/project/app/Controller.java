package bank.project.app;

import bank.project.dao.Account;
import bank.project.dao.BankService;
import bank.project.dao.Customer;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@ComponentScan({"bank.project.dao"})
@RestController
public class Controller {
    @Autowired
    private BankService bankService;
    ResourceBundle bundle=ResourceBundle.getBundle("msg");
    private Logger logger = LoggerFactory.getLogger(Customer.class);

    @GetMapping("/")
    public List<Customer> callList() {
        logger.info(bundle.getString("list"));
        return bankService.listCustomers();
    }
    @GetMapping("/account/{user}")
    public List<Account> callAccount(@PathVariable ("user")String user) {
        logger.info("Customer account");
        List<Account> list = bankService.ListAccounts(user);
//        list=bankService.ListALL(id);
//        return bankService.ListALL(id);



//        list = bankService.ListALL(id);
//        System.out.println(list);
        return list;

    }

    @GetMapping("/accounts/{user}")
    public List<Account> ListActiveAccounts(@PathVariable("user")String user){
        List<Account> list1=bankService.ListActiveAccounts(user);
        return list1;
    }
    @GetMapping("accountss/{user}")
    public List<Account> ListSuspendedAccounts(@PathVariable("user")String user){
        List<Account> listSuspended=bankService.ListActiveAccounts(user);
        return listSuspended;
    }


    //    @GetMapping("/check/{user}/{pass}")
//    public Optional<Customer> callUser(@PathVariable("user") String username,@PathVariable("pass") String password){
//        logger.info("Username and password");
//        return bankService.getByUsername(username,password);
//    }
    @PostMapping("/retrieve")
    public String callRetrieve(@RequestParam("username") String username, @RequestParam("password") String password) {
        logger.info(bundle.getString("receive"));
        Customer customer = bankService.getByUsername(username);
        if (customer == null)
            return bundle.getString("user");
        else {
            logger.info(customer.getStatus());
            if (customer.getStatus().equalsIgnoreCase("Suspended"))
                return bundle.getString("deactivate");
                if (!password.equals(customer.getPassword())) {
                    bankService.incrementFailedAttempts(customer.getCustomerId());
                    return bundle.getString("incorrect");
                } else
                    return "Login Successful";

            }


        }
    }




