package pocketcarage.com.pocketcarage;

import pocketcarage.com.pocketcarage.Registration;

/**
 * Created by basse on 12/10/2017.
 */

public class users extends Registration {
    private String name ;
    private String email;
    private String password;
    private String c_password;
    private int phone ;
    private String address;

    public users(String u_name, String u_email, String u_password, String u_cpassword, String u_phone, String u_address) {
    }

    public users(String name, String email, String password, String c_password, int phone, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.c_password = c_password;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getC_password() {
        return c_password;
    }

    public void setC_password(String c_password) {
        this.c_password = c_password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
