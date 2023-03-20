package dlte.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int loanNumber;
    @NonNull
    private int loanAmount;
    @NonNull
    private String custName;
    @NonNull
    private int int_rate;
    private int tenureSuccess;
    private int tenureFailure;
    @NonNull
    private String loanType;

}

