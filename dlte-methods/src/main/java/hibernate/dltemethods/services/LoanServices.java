package hibernate.dltemethods.services;

import hibernate.dltemethods.model.Loan;
import hibernate.dltemethods.remote.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LoanServices {
    @Autowired
    private LoanRepository repository;
    public Loan implementationOfSave(Loan loan){
        return repository.save(loan);
    }

    public String implementOfDeleteById(int loanNumber) {
        Loan loan=repository.findById(loanNumber).get();
        //String information= loan.getCu()+" has removed/suspended";
        repository.deleteById(loanNumber);
        return "Removed";
    }
    public Optional<Loan> implementOfName(String name){
        return repository.findByCustName(name);
    }
    public Optional<Loan> implementationOfRate(int rate){
        return repository.findByIntRate(rate);
    }
    public List<Loan> implementOfFindAll(){
        return (List<Loan>) repository.findAll();
    }

    public Optional<Loan> implementOfFindById(int loanNumber) {
        return repository.findById(loanNumber);
    }


    public Optional<Loan> implementBetweenRates(int min,int max) {
        return repository.findByInt_rates( min, max);
    }
}
