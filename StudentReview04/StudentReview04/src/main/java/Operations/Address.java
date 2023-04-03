package Operations;

import lombok.Data;

@Data
public class Address {
    private int door_no;
    private String locality;
    private String city;
    private int pincode;
    private  String type;

    public int getDoor_no() {
        return door_no;
    }

    public void setDoor_no(int door_no) {
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

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Address(int door_no, String locality, String city, int pincode, String type) {
        this.door_no = door_no;
        this.locality = locality;
        this.city = city;
        this.pincode = pincode;
        this.type = type;
    }

    public Address() {
    }
}

