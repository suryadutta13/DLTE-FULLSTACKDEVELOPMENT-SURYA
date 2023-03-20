package hibernate.dltemethods.model;

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
    private int intRate;
    private int tenureSuccess;
    private int tenureFailure;
    @NonNull
    private String loanType;

//    public int getLoanNumber() {
//        return loanNumber;
//    }
//
//    public void setLoanNumber(int loanNumber) {
//        this.loanNumber = loanNumber;
//    }
//
//    public int getLoanAmount() {
//        return loanAmount;
//    }
//
//    public void setLoanAmount(int loanAmount) {
//        this.loanAmount = loanAmount;
//    }
//
//    @NonNull
//    public String getCustName() {
//        return custName;
//    }
//
//    public void setCustName(@NonNull String custName) {
//        this.custName = custName;
//    }
//
//    public int getInt_rate() {
//        return int_rate;
//    }
//
//    public void setInt_rate(int int_rate) {
//        this.int_rate = int_rate;
//    }
//
//    public int getTenureSuccess() {
//        return tenureSuccess;
//    }
//
//    public void setTenureSuccess(int tenureSuccess) {
//        this.tenureSuccess = tenureSuccess;
//    }
//
//    public int getTenureFailure() {
//        return tenureFailure;
//    }
//
//    public void setTenureFailure(int tenureFailure) {
//        this.tenureFailure = tenureFailure;
//    }
//
//    @NonNull
//    public String getLoanType() {
//        return loanType;
//    }

//    public void setLoanType(@NonNull String loanType) {
//        this.loanType = loanType;
//    }
}
