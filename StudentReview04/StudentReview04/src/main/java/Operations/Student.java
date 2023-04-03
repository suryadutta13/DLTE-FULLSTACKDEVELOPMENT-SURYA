package Operations;

import Operations.Address;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Student {
    private int reg_no;
    private  String name;
    private int age;

    public int getReg_no() {
        return reg_no;
    }

    public void setReg_no(int reg_no) {
        this.reg_no = reg_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Address> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<Address> address) {
        this.address = address;
    }

    private  String email;
    private ArrayList<Address> address = new ArrayList<>();

    public Student(int reg_no, String name, int age, String email) {
        this.reg_no = reg_no;
        this.name = name;
        this.age = age;
        this.email = email;

    }

    public Student() {
    }
}
