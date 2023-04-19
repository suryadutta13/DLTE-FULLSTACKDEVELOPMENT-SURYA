package bank.project.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class DaoApplicationTests {

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    BankService bankService;


    @Test
    public void testListActiveAccounts() {
        Account a2 = new Account(13, "current", 345687, 45679, "active");
        Account a3 = new Account(14, "savings", 345465, 45679, "active");
        Account a4=new Account(12,"saving",8765,76,"active");
        List<Account> tempList = Stream.of(a2,a4,a3).collect(Collectors.toList());
        String str = "sur";
        //when(jdbcTemplate.query(any(String.class),any(HaiServices.HaiMapper.class))).thenReturn(tempList);
        when(jdbcTemplate.query(eq("Select * from account join customer on customer.customer_id = account.customer_id where customer.username=? and account_status='active'"),  any(RowMapper.class),eq(str))).thenReturn(tempList);
//        Customer c1=new Customer(45,"surya","active","Blore",456789567,)
        //assertEquals(h2,services.listAll().get(1));
        assertEquals(tempList, bankService.ListActiveAccounts(str));

    }
    @Test
    public void testlistCustomers(){
        Customer c2=new Customer(401,"Yesh","active","156,indiranagar,Bangalore",854678997,"ram",0,"admin");
        Customer c3=new Customer(456,"sann","active","blore",345678956,"sann",0,"admin");
        Customer c4=new Customer(457,"sur","active","blore",34524899,"sur",0,"admin");

        List<Customer> tempList = Stream.of(c2, c3, c4).collect(Collectors.toList());
        when(jdbcTemplate.query(eq("Select * from customer"),any(RowMapper.class))).thenReturn(tempList);
        assertEquals(tempList.size(), bankService.listCustomers().size());
    }
    @Test
    public void testListAccounts(){
        Account a2 = new Account(13, "current", 345687, 45679, "suspended");
        Account a3 = new Account(14, "savings", 345465, 45679, "active");
        String user = "Gourav";
        List<Account> tempList = Stream.of(a2,a3).collect(Collectors.toList());
        when(jdbcTemplate.query(eq("Select * from account join customer on customer.customer_id = account.customer_id where customer.username=?"),  any(RowMapper.class), eq(user))).thenReturn(tempList);
        assertEquals(tempList, bankService.ListAccounts(user));
    }
    @Test
    public void testGetbyUsername() {
        Customer customer = new Customer(100,"surya","active","AAA Road,ABC Street,900",34567899,"surya",0,"admin");
        String uname = "surya";

        when(jdbcTemplate.queryForObject(eq("select * from customer where username=?"),any(RowMapper.class),eq(uname))).thenReturn(customer);

        Customer customer1 = bankService.getByUsername("surya");
        assertEquals(customer.getUsername(),customer1.getUsername());
    }
    @Test
    public void testlistSuspendedAccounts(){
        Account account1 = new Account(13, "current", 345687, 45679, "suspended");
        Account account2 = new Account(14, "savings", 345465, 45679, "active");
        List<Account> tempList = Stream.of(account1,account2).collect(Collectors.toList());
        String str = "sur";
        when(jdbcTemplate.query(eq("Select * from account join customer on customer.customer_id = account.customer_id where customer.username=? and account_status='suspended'"),  any(RowMapper.class),eq(str))).thenReturn(tempList);
        assertEquals(tempList, bankService.ListSuspendedAccounts(str));
    }


}
