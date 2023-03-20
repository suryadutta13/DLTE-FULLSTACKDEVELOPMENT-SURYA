package Students;


import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
       details obj = new details();
        boolean mainMenu = true;
        do{
            System.out.println("1. Insert new values \n2. Display Data\n3.Exit\n Enter your choice:");
            switch (scanner.nextInt()){
                case 1:
                    obj.insertData();
                    break;
                case 2:
                    obj.displayData();
                    break;
                case 3:
                    mainMenu = false;
                    break;
                default:
                    System.out.println("Invalid option selected");
            }
        }while (mainMenu);
    }
}