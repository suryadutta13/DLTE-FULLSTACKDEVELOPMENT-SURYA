package bank.project.app;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppApplicationTests {

    @Mock
    JdbcTemplate jdbcTemplate;

    @InjectMocks
    Controller controller;


    @Test
    public void testcallList() {


    }
}
