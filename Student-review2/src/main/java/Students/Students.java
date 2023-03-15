package Students;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
@Data
public class Students implements Serializable {
    private int reg_no;
    private  String name;
    private int age;
    private  String email;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Students(int reg_no, String name, int age, String email, String address) {
        this.reg_no = reg_no;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address=address;
    }

    public Students() {

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
}