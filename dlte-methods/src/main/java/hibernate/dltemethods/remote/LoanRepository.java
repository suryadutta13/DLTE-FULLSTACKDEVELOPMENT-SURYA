package hibernate.dltemethods.remote;

import hibernate.dltemethods.model.Loan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {
    Optional<Loan> findByCustName(String name);
    Optional<Loan> findByIntRate(int rate);


    @Query("from Loan where intRate> :min and intRate< :max")

    Optional<Loan> findByInt_rates(int min,int max);
}
