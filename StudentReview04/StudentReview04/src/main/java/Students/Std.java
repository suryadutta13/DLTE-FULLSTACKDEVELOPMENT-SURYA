package Students;

import Operations.Address;
import Operations.DAOoperations;
import Operations.Student;

public class Std {
    public static void main(String[] args) {
        Student student=new Student(109,"surya",22,"surya@gmail.com");
        Address address1=new Address(123,"rlayout","blore",4567,"current");
        Address address2=new Address(3788,"rlayout","blore",4567,"permanent");
        student.getAddress().add(address1);
        student.getAddress().add(address2);
        DAOoperations daOoperations=new DAOoperations();
        System.out.println(daOoperations.insert(student));
    }
}
