package dlteassessment.exg.demo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends CrudRepository<CustomerssLoan,Integer> {
    @Modifying
    @Transactional
    @Query(value = "select * from PersonalLoanApplication where cibil>700 and profession=('selfemployed','salaried') and income=(amt*3)", nativeQuery = true)
    Optional<String> findPersonalLoanApplicationByStatus(int cibil, String profession, int income);

    @Query(value = "select * from PersonalLoanApplication where status=('rejected')", nativeQuery = true)
    Optional<String> findAllByStatus(String status);


}