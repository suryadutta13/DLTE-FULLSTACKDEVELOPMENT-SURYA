package Students;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
@Data
public class Students implements Serializable {
    private int reg_no;
    private String name;
    private int age;
    private String email;
    private String address;
    private String door_no;
    private String locality;
    private String city;
    private int pincode;

    public Students() {

    }


    public void setCity(String city) {
        this.city = city;
    }



    public void setPincode(int pincode) {
        this.pincode = pincode;
    }


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDoor_no() {
        return door_no;
    }

    public void setDoor_no(String door_no) {
        this.door_no = door_no;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public int getPincode() {
        return pincode;
    }

    public Students(int reg_no, String name, int age, String email, String address, String door_no, String locality, int pincode, String city) {
        this.reg_no = reg_no;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
        this.door_no = door_no;
        this.locality = locality;
        this.pincode = pincode;
        this.city = city;


    }


}