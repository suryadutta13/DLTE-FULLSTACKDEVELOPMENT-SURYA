package dlteassessment.exg.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LoanService {
    @Autowired
        private LoanRepository repository;

        public Optional<String> implementOnStatus(int cibil, String profession, int income){
            return repository.findPersonalLoanApplicationByStatus(cibil,profession,income);
        }

        public Optional<String> implementOnSave(String status){
            return repository.findAllByStatus(status);
        }



}
