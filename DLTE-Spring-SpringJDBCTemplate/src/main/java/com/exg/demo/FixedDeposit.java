package com.exg.demo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixedDeposit {

    private int deposit_id;
    private int deposit_amount;
    private int deposit_tenure;
    private Date deposit_date;
    private int int_rate;
    private Date mature_date;
    private String mode_if_divi;

    public int getDeposit_id() {
        return deposit_id;
    }

    public void setDeposit_id(int deposit_id) {
        this.deposit_id = deposit_id;
    }

    public int getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(int deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    public int getDeposit_tenure() {
        return deposit_tenure;
    }

    public void setDeposit_tenure(int deposit_tenure) {
        this.deposit_tenure = deposit_tenure;
    }

    public Date getDeposit_date() {
        return deposit_date;
    }

    public void setDeposit_date(Date deposit_date) {
        this.deposit_date = deposit_date;
    }

    public int getInt_rate() {
        return int_rate;
    }

    public void setInt_rate(int int_rate) {
        this.int_rate = int_rate;
    }

    public Date getMature_date() {
        return mature_date;
    }

    public void setMature_date(Date mature_date) {
        this.mature_date = mature_date;
    }

    public String getMode_if_divi() {
        return mode_if_divi;
    }

    public void setMode_if_divi(String mode_if_divi) {
        this.mode_if_divi = mode_if_divi;
    }
}
