package model;

import java.util.Arrays;

public class Shareholder {

    private int id;
    private String name;
    private String phoneNumber;
    private int nationalCode;


    //constructor

    public Shareholder() {
    }


    public Shareholder(int id, String name, String phoneNumber, int nationalCode) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }

    public Shareholder(String name, String phoneNumber, int nationalCode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }


    //get and set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(int nationalCode) {
        this.nationalCode = nationalCode;
    }


    //method

    @Override
    public String toString() {
        return "Shareholder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", nationalCode=" + nationalCode +
                '}';
    }
}
