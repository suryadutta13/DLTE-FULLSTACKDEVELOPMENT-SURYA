package dlteassessment.exg.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loan")
public class Controller {
    @Autowired
    private LoanService loanService;

    @GetMapping("/created/{state}")
    public Optional<String> callFetchByStatus(@PathVariable("state") int cibil, String profession, int income ) {
        return loanService.implementOnStatus(cibil,profession,income);
    }
    @GetMapping("/status")
    public Optional<String> callToFetchSave(@PathVariable("status")String status){
        return loanService.implementOnSave(status);

    }
    @PostMapping("/insert")
    public LoanService callingSave(@RequestBody LoanService loanService){
        return loanService.implementationOfSave(loanService);
    }
}