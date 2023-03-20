package hibernate.dltemethods.controls;

import hibernate.dltemethods.model.Loan;
import hibernate.dltemethods.services.LoanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class LoanControllers {
    @Autowired
    private LoanServices loanService;

    @PostMapping("/insert")
    public Loan callingSave(@RequestBody Loan loan) {
        return loanService.implementationOfSave(loan);
    }
    /*GetMapping("/name/{CustName}")
    public Optional<Loan> callFetchName(@PathVariable("CustName") String name){
        return loanService.implementOfName(name);
    }*/
    @GetMapping("/rate/{int_rate}")
    public Optional<Loan> callFetchRate(@PathVariable("int_rate")int rate){
        return loanService.implementationOfRate(rate);
    }
    @GetMapping("/btw/{int_rates}")
    public Optional<Loan> callMinimumBalance(@PathVariable("int_rates") int min,int max){
        return loanService.implementBetweenRates( min,max);
    }
    @PutMapping("/change")
    public Loan callUpdate(@RequestBody Loan loan){
        return loanService.implementationOfSave(loan);
    }

    @DeleteMapping("/suspend/{loanNumber}")
    public String callDeleteById(@PathVariable("loanNumber") int loanNumber){
        return loanService.implementOfDeleteById(loanNumber);
    }

    @GetMapping("/account/{loanNumber}")
    public Optional<Loan> callingFindById(@PathVariable("loanNumber") int loanNumber){
        return loanService.implementOfFindById(loanNumber);
    }

    @GetMapping("/retrieve")
    public List<Loan> callingFindAll(){
        return loanService.implementOfFindAll();
    }
}