package model;

import java.util.Arrays;
import java.util.Date;

public class Product {

    private int id;
    private String name;
    private Date createDate;
    private Category[] category;
    private Brand[] brand;

    //constructor

    public Product(){}

    public Product(int id, String name, Date createDate, Category[] category, Brand[] brand) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.category = category;
        this.brand = brand;
    }

    public Product(String name, Date createDate, Category[] category, Brand[] brand) {
        this.name = name;
        this.createDate = createDate;
        this.category = category;
        this.brand = brand;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Category[] getCategory() {
        return category;
    }

    public void setCategory(Category[] category) {
        this.category = category;
    }

    public Brand[] getBrand() {
        return brand;
    }

    public void setBrand(Brand[] brand) {
        this.brand = brand;
    }

    //method


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", category=" + Arrays.toString(category) +
                ", brand=" + Arrays.toString(brand) +
                '}';
    }
}
