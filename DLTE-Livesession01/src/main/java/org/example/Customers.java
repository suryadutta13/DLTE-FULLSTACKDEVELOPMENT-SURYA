package org.example;

import java.util.ArrayList;

public class Customers {
    private int customerId;
    private String customerName,email,pan;
    private int contact;
    private String pin;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public ArrayList<Loan> getLoanlist() {
        return Loanlist;
    }

    public void setLoanlist(ArrayList<Loan> loanlist) {
        Loanlist = loanlist;
    }

    ArrayList<Loan> Loanlist=new ArrayList<>();
}
