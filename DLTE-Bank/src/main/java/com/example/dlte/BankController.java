package com.example.dlte;


import com.example.dltefinal.BankService;
import com.example.dltefinal.Customers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@ComponentScan({"com.example.dltefinal"})
@RestController
public class BankController {
    @Autowired
    private BankService bankService;
    private Logger logger= LoggerFactory.getLogger(Customers.class);

    @GetMapping("/")
    public List<Customers> callList(){
        logger.info("Controller about print All the records");
        return bankService.listAll();
    }
    @GetMapping("/check/{user}/{pass}")
    public Optional<Customers> callUser(@PathVariable("user") String username,@PathVariable("pass") String password){
        logger.info("Username and password");
        return bankService.findByUsername(username,password);
    }
}

