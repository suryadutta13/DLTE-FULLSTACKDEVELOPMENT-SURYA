package Studentss;

public class Student{
    private int Reg_no;
    private String Name;
    private int Age;
    private String Email;
    private String address_id;


    public void setReg_no(int reg_no) {
        this.Reg_no = reg_no;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public void setDoor_no(String door_no) {
        this.door_no = door_no;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    private String door_no;
    private String locality;

    public String getAddress_id() {
        return address_id;
    }

    private String city;
    private int pincode;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public  Student(){

    }

    public int getReg_no() {
        return Reg_no;
    }

    public String getName() {
        return getName();
    }

    public int getAge() {
        return getAge();
    }

    public String getEmail() {
        return getEmail();
    }

    public String getDoor_no() {
        return getDoor_no();
    }

    public String getLocality() {
        return getLocality();
    }

    public String getCity() {
        return getCity();
    }

    public int getPincode() {
        return getPincode();
    }
}
