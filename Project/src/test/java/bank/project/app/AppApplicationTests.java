//package bank.project.app;
//
//import bank.project.dao.Account;
//import bank.project.dao.BankService;
//import bank.project.dao.Customer;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import static org.mockito.ArgumentMatchers.eq;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.junit.jupiter.api.Assertions.*;
//
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class SpringOracleJdbcTemplateSlf4jApplicationTests {
//
//    @Mock
//    JdbcTemplate jdbcTemplate;
//
//    @InjectMocks
//    BankService bankService;
//
//
////    @Test
////    public void testListActiveAccounts() {
////        Account a1 = new Account(12, "savings", 345678, 45679, "active");
////        Account a2 = new Account(13, "current", 345687, 45679, "suspended");
////        Account a3 = new Account(14, "savings", 345465, 45679, "active");
////        List<Account> tempList = Stream.of(a1, a2, a3).collect(Collectors.toList());
////        String str = "active";
////        //when(jdbcTemplate.query(any(String.class),any(HaiServices.HaiMapper.class))).thenReturn(tempList);
////        when(jdbcTemplate.query(eq("select * from account where account_status=?"), eq(new Object[]{str}), any(RowMapper.class))).thenReturn(tempList);
//////        Customer c1=new Customer(45,"surya","active","Blore",456789567,)
////        //assertEquals(h2,services.listAll().get(1));
////        assertEquals(a1, bankService.ListActiveAccounts("yesh"));
////
////    }
//    @Test
//    public void testlistCustomers(){
//        Customer c2=new Customer(401,"Yesh","active","156,indiranagar,Bangalore",854678997,"ram",0,"admin");
//        Customer c3=new Customer(456,"sann","active","blore",345678956,"sann",0,"admin");
//        Customer c4=new Customer(457,"sur","active","blore",34524899,"sur",0,"admin");
////        Account a1 = new Account(12, "savings", 345678, 45679, "active");
//        List<Customer> tempList = Stream.of(c2, c3, c4).collect(Collectors.toList());
//        when(jdbcTemplate.query(eq("select * from customer"),any(RowMapper.class))).thenReturn(tempList);
//        assertEquals(0, bankService.listCustomers().indexOf(c2));
//    }
//}
