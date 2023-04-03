package org.example;

import java.util.Date;

public class Loan {
    private int loanNumber;
    private String borrowerName;
    private String loanType;
    private int loanAmount;
    private Date loanIssuedDate;

    public int getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getLoanIssuedDate() {
        return loanIssuedDate;
    }

    public void setLoanIssuedDate(Date loanIssuedDate) {
        this.loanIssuedDate = loanIssuedDate;
    }
}
