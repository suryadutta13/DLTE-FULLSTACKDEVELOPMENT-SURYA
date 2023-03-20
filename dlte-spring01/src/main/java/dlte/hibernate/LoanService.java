package dlte.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dlte.hibernate.LoanRepository;
import dlte.hibernate.Loan;

@Service
public class LoanService {
    @Autowired
    private LoanRepository repository;
    public Loan implementationOfSave(Loan loan){
        return repository.save(loan);
    }
}