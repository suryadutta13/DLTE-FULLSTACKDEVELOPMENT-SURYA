package bank.project.app;

import bank.project.dao.Account;
import bank.project.dao.BankService;
import bank.project.dao.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

@ComponentScan({"bank.project.dao"})
@RestController
public class Controller {
    @Autowired
    private BankService bankService;
    ResourceBundle bundle=ResourceBundle.getBundle("msg");
    private Logger logger = LoggerFactory.getLogger(Customer.class);

    //calling list for returning the method of listcustomers from bankservice class
    @GetMapping("/")
    public List<Customer> callList() {
        logger.info(bundle.getString("list"));
        return bankService.listCustomers();
    }
    //
    @GetMapping("/account/{user}")//URL
    public List<Account> callAccount(@PathVariable ("user")String user) {
        logger.info("Customer account");
        List<Account> list = bankService.ListAccounts(user);
        return list;

    }
    //List active accounts(url)  using username
    @GetMapping("/accounts/{user}")//URL
    public List<Account> ListActiveAccounts(@PathVariable("user")String user){
        List<Account> list1=bankService.ListActiveAccounts(user);
        return list1;
    }




    }




