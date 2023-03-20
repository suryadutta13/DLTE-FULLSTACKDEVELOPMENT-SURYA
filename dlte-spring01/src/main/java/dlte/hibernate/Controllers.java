package dlte.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controllers {
    @Autowired
    private LoanService loanService;

    @PostMapping("/insert")
    public Loan callingSave(@RequestBody Loan loan){
        return loanService.implementationOfSave(loan);
    }
}