package bank.project.dao;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;


@org.springframework.stereotype.Service
public class BankService implements BankOperations //, UserDetailsService

{
    private  Logger logger= LoggerFactory.getLogger(BankService.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int getAttempts(int id){
        int attempts=jdbcTemplate.queryForObject("select failed_Attempts from customer_id=?",Integer.class,id);
        logger.info("Number of attempts:"+attempts);
        return attempts;
    }
    @Override
    public void decreaseAttempts(int id){
        jdbcTemplate.update("update customer set failed_attempts=failed_attempts-1 where customer_id=?",id);
//        logger.info("")
        updateStatus();
    }
    @Override
    public void updateStatus(){
        jdbcTemplate.update("update customer set customer_status='Suspended' where failed_attempts=0");
        logger.info("Suspended accounts");
    }
    public List<Customer> listCustomers(){
        return jdbcTemplate.query("Select * from customer",new MapperCustomer());
    }
    @Override
    public Customer getByUsername(String username){
        try {
            Customer customer = (jdbcTemplate.queryForObject("select * from customer where username=?", new MapperCustomer(), username));
            logger.info("List Customers by username");
            return customer;
        }catch (DataAccessException e){
            return null;
        }
    }
    public void incrementFailedAttempts(int id){
        jdbcTemplate.update("update customer set failed_attempts=failed_attempts+1 where customer_id=?",id);
        jdbcTemplate.update("update customer set customer_status='suspended' where customer_id=?",id);
    }
    public List<Account> ListAccounts(String user){
        logger.info(" Get by username ");
                 return jdbcTemplate.query("Select * from account join customer on customer.customer_id = account.customer_id where customer.username=?",new MapperAccount(),user);

             }
    public List<Account> ListActiveAccounts(String user){
        logger.info(" Get by username ");
        return jdbcTemplate.query("Select * from account join customer on customer.customer_id = account.customer_id where customer.username=? and account_status='active'",new MapperAccount(),user);

    }
    public List<Account> ListSuspendedAccounts(String user){
        logger.info(" Get by username suspended "+user);
        return jdbcTemplate.query("Select * from account join customer on customer.customer_id = account.customer_id where customer.username=? and account_status='suspended'",new MapperAccount(),user);

    }
    public List<Account> ListSpecificAccounts(String status){
        logger.info("List of specific accounts");
        return jdbcTemplate.query("select * from account where account_status=?",new MapperAccount(),status);
    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//            Customer customer=getByUsername(username);
//            if(customer==null){
//                throw new UsernameNotFoundException("Invalid user");
//            }
//            return customer;
//        }

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
