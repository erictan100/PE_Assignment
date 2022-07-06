package com.example.pe_assignment.HelperClass;

public class UserHelperClass {

    private String email, name, ic, dob, address, state, phoneNo, pwd;

    public UserHelperClass() {

    }

    public UserHelperClass(String email, String name, String ic, String dob, String address, String state, String phoneNo, String pwd) {
        this.email = email;
        this.name = name;
        this.ic = ic;
        this.dob = dob;
        this.address = address;
        this.state = state;
        this.phoneNo = phoneNo;
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
