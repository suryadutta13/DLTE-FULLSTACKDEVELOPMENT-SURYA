package dlte.java;
import java.util.Scanner;
public class CalculateFD {
    public static void main(String[] args) {
        Scanner scannerObject=new Scanner(System.in);


        Integer amount=0,duration=0;
        Double maturity=0.0, interest=6.4;
        System.out.println("enter the prici amt:");
        amount=scannerObject.nextInt();

        System.out.println("enter duration");
        duration=scannerObject.nextInt();



        //maturity=amount+(duration)*interest;
        if(duration>1){

            maturity=amount+(amount*interest)/100;
            while(duration>1){
                maturity+=(maturity*interest)/100;
                duration--;
            }
            System.out.println(maturity
                    +"for amount"+ amount);
        }


    }
}
