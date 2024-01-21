package model;

import lombok.*;

import java.util.Arrays;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Product {

    private int id;
    private String name;
    private Date createDate;
    private int categoryId;
    private int brandId;

    //CONSTRUCTOR
    public Product(String name, Date createDate, int categoryId, int brandId) {
        this.name = name;
        this.createDate = createDate;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }
}
