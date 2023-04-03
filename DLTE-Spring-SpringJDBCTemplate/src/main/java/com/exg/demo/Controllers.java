package com.exg.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controllers {
    @Autowired
    private DepositServices depService;

    @GetMapping("/created/{amount}")
    public List<FixedDeposit> callFetchDate(@PathVariable("amount") int amount) {
        return depService.fixedDepositList(amount);
    }
}