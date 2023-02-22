package dlte.java;
import java.util.*;
public class PersonalCalculator {
    public static void main(String[] args) {
        Scanner scannerObject= new Scanner(System.in);
        Integer amount , tenure ;
        Double interest,EMI,Totalamount,totrepay;


        System.out.println("enter the  amt:");
        amount=scannerObject.nextInt();

        System.out.println("enter tenure");
        tenure=scannerObject.nextInt();
        tenure=tenure*12;

        System.out.println("enter rate");
        interest=scannerObject.nextDouble();
        interest=interest/(12*100);

        EMI=(amount*interest*Math.pow(1+interest,tenure))/(Math.pow(1+interest,tenure)-1);
        System.out.println("EMI is " +EMI);

        Totalamount=(EMI*tenure);
        System.out.println("total amount is " +Totalamount);
        System.out.println("total repay is " +(amount+Totalamount));



    }

}