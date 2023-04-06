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

    @GetMapping("/status")
    public Optional<String> callFetchByStatus(@PathVariable("status") int cibil, String profession, int income ) {
        return loanService.implementOnStatus(cibil,profession,income);
    }
    @GetMapping("/rejected")
    public Optional<String> callToFetchSave(@PathVariable("rejected")String status){
        return loanService.implementOnSave(status);

    }

}