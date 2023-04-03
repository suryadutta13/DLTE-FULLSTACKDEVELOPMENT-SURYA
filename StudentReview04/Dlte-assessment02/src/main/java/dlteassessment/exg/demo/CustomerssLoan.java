package dlteassessment.exg.demo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class CustomerssLoan {
    @Id
    @NonNull
    private int loanrequest;
    @NonNull
    private int requestedAmount;
    @NonNull
    private int cibil;
    @NonNull
    private String pan;
    @NonNull
    private int aadhaar;
    @NonNull
    private String status;
    @NonNull
    private String profession;
    @NonNull
    private int income;
    @Temporal(TemporalType.DATE)
    @NonNull
    private Date dateOfRequest;


}
