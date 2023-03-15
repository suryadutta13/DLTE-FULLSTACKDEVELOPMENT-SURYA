package Students;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class details implements StudentEvents {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> studentList = new ArrayList<String>();
    File file = new File("StudentInformation.txt");

    public void insertFile(Students student) throws IOException {

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);

        //   while(scanner.nextBoolean()){
        // /     studentList.add(scanner.next());
        //  }


    }
    public void insertData() throws IOException {
        System.out.println("Enter your Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Registration number:");
        int regNo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the age:");
        int age = scanner.nextInt();
//
        System.out.println("Enter your email:");
        String email = scanner.next();
        System.out.println("Enter your address:");
        String address = scanner.next();
        insertFile(new Students(regNo,name,age,email,address));
    }

    @Override
    public void displayData() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        System.out.println(ois.readObject());
    }
}