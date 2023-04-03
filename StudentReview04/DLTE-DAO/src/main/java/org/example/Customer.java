package org.example;

public class Customer {
    private int customerId;
    private String customerName,email,pan;
    private int contact;
    private String pin;

    public Customer(int customerId, String customerName, String email, String pan, int contact, String pin) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.pan = pan;
        this.contact = contact;
        this.pin = pin;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", pan='" + pan + '\'' +
                ", contact=" + contact +
                ", pin='" + pin + '\'' +
                '}';
    }

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
}
