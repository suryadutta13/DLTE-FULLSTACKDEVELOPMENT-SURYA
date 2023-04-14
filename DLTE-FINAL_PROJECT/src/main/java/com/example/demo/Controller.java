package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;


@RestController
public class Controller {
    @Autowired
    private BankService bankService;
    private Logger logger= (Logger) LoggerFactory.getLogger(Controller.class);

    @GetMapping("/")
    public List<Customers> callList(){
        logger.info("Controller about print All the records");
        return bankService.listAll();
    }
}

