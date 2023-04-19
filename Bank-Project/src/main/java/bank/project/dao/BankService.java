package bank.project.dao;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@org.springframework.stereotype.Service
public class BankService implements BankOperations , UserDetailsService

{
    //
    ResourceBundle bundle=ResourceBundle.getBundle("message");
    private  Logger logger= LoggerFactory.getLogger(BankService.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //method for getting attempts
    @Override
    public int getAttempts(int id){
        int attempts=jdbcTemplate.queryForObject("select  failed_Attempts from customer where customer_id=?",Integer.class,id);
        logger.info(bundle.getString("number")+attempts);
        return attempts;
    }
    @Override
    public void decreaseAttempts(int id){
        jdbcTemplate.update("update customer set failed_attempts=failed_attempts-1 where customer_id=?",id);
//        logger.info("")
        updateStatus();
    }
    //method to update the status
    @Override
    public void updateStatus(){
        jdbcTemplate.update("update customer set customer_status='Suspended' where failed_attempts=0");
        logger.info("Suspended accounts");
    }
    //Method to list of customers
    public List<Customer> listCustomers(){

         List<Customer> customers=jdbcTemplate.query("Select * from customer",new MapperCustomer());
         logger.info(bundle.getString("customer")+customers);
         return customers;
    }
    //Method to fetch customers by Name
    @Override
    public Customer getByUsername(String username){
        try {
            Customer customer = (jdbcTemplate.queryForObject("select * from customer where username=?", new MapperCustomer(), username));
            logger.info(bundle.getString("Byname"));
            return customer;
        }catch (DataAccessException e){
            return null;
        }
    }
    public void setAttempts(int id){
        jdbcTemplate.update("update customer set failed_attempts=3 where customer_id=?");
        logger.info("set attempts to 3");
    }
    public void incrementFailedAttempts(int id){

        jdbcTemplate.update("update customer set failed_attempts=failed_attempts+1 where customer_id=?",id);
        jdbcTemplate.update("update customer set customer_status='suspended' where customer_id=?",id);
        logger.info(bundle.getString("Failed"));
    }
    public List<Account> ListAccounts(String user){
        logger.info(bundle.getString("account"));
                 return jdbcTemplate.query("Select * from account join customer on customer.customer_id = account.customer_id where customer.username=?",new MapperAccount(),user);

             }
    public List<Account> ListActiveAccounts(String user){
        logger.info(bundle.getString("active"));
        return jdbcTemplate.query("Select * from account join customer on customer.customer_id = account.customer_id where customer.username=? and account_status='active'",new MapperAccount(),user);

    }
    public List<Account> ListSuspendedAccounts(String user){
        logger.info(" Get by username suspended "+user);
        return jdbcTemplate.query("Select * from account join customer on customer.customer_id = account.customer_id where customer.username=? and account_status='suspended'",new MapperAccount(),user);

    }
    public List<Account> ListSpecificAccounts(String status){
        logger.info(bundle.getString("specific"));
        return jdbcTemplate.query("select * from account where account_status=?",new MapperAccount(),status);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info(bundle.getString("load"));
        Customer customer=getByUsername(username);
        if(customer==null)
            throw new UsernameNotFoundException(bundle.getString("invalid"));
        logger.info(customer.toString());
        return customer;
    }


    class MapperAccount implements RowMapper<Account>{
        @Override
        public Account mapRow(ResultSet rs,int rowNum) throws SQLException{
            Account account=new Account();
            account.setAccountId(rs.getInt("account_id"));
            account.setAccountBalance(rs.getInt("account_avl_balance"));
            account.setAccountNumber(rs.getInt("account_number"));
            account.setAccountType(rs.getString("account_type"));
            account.setAccountStatus(rs.getString("account_status"));
            return account;
        }
    }
    class MapperCustomer implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customers = new Customer();

            customers.setCustomerId(rs.getInt("customer_id"));
            customers.setCustomerName(rs.getString("customer_name"));
            customers.setAddress(rs.getString("customer_address"));
            customers.setContact(rs.getLong("customer_contact"));
            customers.setStatus(rs.getString("customer_status"));
            customers.setUsername(rs.getString("username"));
            customers.setPassword(rs.getString("password"));
            customers.setFailedAttempts(rs.getInt("failed_attempts"));


            return customers;

        }

    }
}
