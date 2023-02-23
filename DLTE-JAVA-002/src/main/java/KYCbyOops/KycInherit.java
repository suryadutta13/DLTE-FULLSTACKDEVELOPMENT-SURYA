package KYCbyOops;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class KycInherit {
    public static void main(String[] args) {
        KycInherit kycc=new KycInherit();
        Scanner scanner=new Scanner(System.in);
    }
}

class Kyc{
    private String name;
    private long accno;
    private double balance;

}

class Transaction extends Kyc{

    public void details(int bal,int recharge,String ticket){
        System.out.println("enter balance, recharge amount and ticket");

    }
}