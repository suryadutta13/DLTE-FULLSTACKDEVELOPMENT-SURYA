package bank;

import java.util.*;
    public class Gpay {
        public static void main(String[] args) {
            gpay gpayy=new gpay(4326652L, 213543, 5000, "ram" );
            System.out.println(gpayy.toString());
            System.out.println(gpayy.getName()+" "+gpayy.getAccountNumber()+" "+gpayy.getBalance()+" "+gpayy.getUpipin());
            gpayy.fundTransfer();
            gpayy.recharge();
            gpayy.recharge("KA34EG9843");
        }
    }
    //this Fund class includes getter and setter ,tostring method
    class gpay{

        Scanner scanner = new Scanner(System.in);

        private long accountNumber;
        private Integer upipin;
        private double balance;
        private String name;

        public gpay(long accountNumber, Integer upipin, double balance, String name) {
            this.accountNumber = accountNumber;
            this.upipin = upipin;
            this.balance = balance;
            this.name = name;
        }
        @Override
        public String toString() {
            return "gpay{" +
                    "accountNumber=" + accountNumber + ", upipin=" + upipin + ", balance=" + balance + ", name='" + name + '\'' + '}';
        }

        public long getAccountNumber(){
            return this.accountNumber;
        }

        public void setAccountNumber ( long accountNumber){
            this.accountNumber = accountNumber;
        }

        public Integer getUpipin () {
            return upipin;
        }

        public void setUpipin (Integer upipin){
            this.upipin = upipin;
        }

        public double getBalance () {
            return balance;
        }

        public void setBalance ( double balance){
            this.balance = balance;
        }

        public String getName () {
            return name;
        }

        public void setName (String name){
            this.name = name;
        }
        //method to transfer the fund
        public void fundTransfer(){
            System.out.println("Enter the Fund to be transfferd:");

            float amount = scanner.nextFloat();
            if(amount<=balance) {
                balance -= amount;

                System.out.println("Enter UPI ID");
                Integer upi = scanner.nextInt();
                if (upi.equals(this.upipin))
                    System.out.println(amount + " has been Successfully Transffered, Available balance Rs " + balance);
                else
                    System.out.println("Wrong pin entered");
            }
            else  System.out.println("fund transfer unsuccessful");
        }
        //method to recharge using method overriding concept
        public void recharge(){
            System.out.println("Enter the amount to be recharged:");
            int amount=scanner.nextInt();
            if(amount<=balance) {
                balance -= amount;
                System.out.println("Enter UPI ID");
                Integer upi = scanner.nextInt();
                if (upi.equals(this.upipin))
                    System.out.println("Recharge of " + amount + " is Successful, Available balance Rs " + balance);
                else
                    System.out.println("Pin entered is wrong");
            }
            else
                System.out.println("Recharge of "+amount+" failed");

        }
        //method to recharge  a FASTAG for vechile using concept of method overriding
        public void recharge(String vehicle ){
            System.out.println("Enter the fasttag amount to be recharged:");
            int amount=scanner.nextInt();
            if(amount<=balance) {
                balance -= amount;
                System.out.println("Enter UPI ID");
                Integer upi = scanner.nextInt();
                if (upi.equals(this.upipin))
                    System.out.println("Recharge of " + amount + " is Successfull for vechile No: " + vehicle+" Available balance Rs " + balance);
                else
                    System.out.println("Wrong pin entered");
            }
            else
                System.out.println("Recharge of  fasttag "+amount+" is unsuccessful!!");


        }

    }

