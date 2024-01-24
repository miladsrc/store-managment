package service;

import connection.util.Connector;
import model.Product;
import repository.BrandRepository;
import repository.ProductRepository;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductService {

    Scanner input = new Scanner(System.in);
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void createProduct() throws SQLException {
        try {
            System.out.println("enter product name :");
            String name = input.next();

            java.util.Date date = strToDate(getDate());
            System.out.println("******************************************************");
            productRepository.categoryList();
            System.out.println("\nenter your category id :");
            int categoryId = input.nextInt();
            System.out.println("******************************************************");
            productRepository.branderList();
            System.out.println("\nenter your brand id :");
            int brandId = input.nextInt();

            Product product = new Product(name, date, categoryId, brandId);

            Boolean result = productRepository.createProduct(product);
            while (result) {
                System.out.println("product was added !");
                break;
            }
        }catch (Exception e){
            System.out.println("error !");
        }
    }

    public void readProduct() throws SQLException {
        try {
            productRepository.productList();
            System.out.println("\nchoose product id to read information :");
            int product_id = input.nextInt();
            System.out.println(productRepository.readProduct(product_id).toString());
        }catch (Exception e){
            System.out.println("enter valid id ");
        }
    }

    public void updateProduct() throws SQLException {
        try {
            productRepository.productList();
            System.out.println("\nenter product id : ");
            int product_id = input.nextInt();

            System.out.println("enter product name :");
            String name = input.next();

            java.util.Date date = strToDate(getDate());
            System.out.println("******************************************************");
            productRepository.categoryList();
            System.out.println("\nenter your category id :");
            int categoryId = input.nextInt();
            System.out.println("******************************************************");
            productRepository.branderList();
            System.out.println("\nenter your brand id :");
            int brandId = input.nextInt();

            Product product = new Product(product_id, name, date, categoryId, brandId);

            Boolean result = productRepository.createProduct(product);
            while (result) {
                System.out.println("product was updated !");
                break;
            }
        }catch (Exception e){
            System.out.println("error !");
        }
    }

    public void dropProduct() throws SQLException {
        try {
            productRepository.productList();
            System.out.println("\nchoose product id to drop information :");
            int product_id = input.nextInt();
            while (productRepository.dropProduct(product_id)) {
                System.out.println("product is dropped from database !");
                break;
            }
        }catch (Exception e){
            System.out.println("enter valid id !");
        }
    }

    private static String getDate() {
        try {
            System.out.println("enter year :");
            int year = new Scanner(System.in).nextInt();
            System.out.println("enter month :");
            int month = new Scanner(System.in).nextInt();
            System.out.println("enter date :");
            int date = new Scanner(System.in).nextInt();

            if ((year > 1000 && year < 2024) && (month > 0 && month < 13) && (date > 0 && date < 31)) {
                System.out.println("" + year + "-" + month + "-" + date + "");
                String dateIn = "" + year + "-" + month + "-" + date + "";
                return dateIn;
            } else {
                System.out.println("please try again and input proper value");
                return null;
            }
        }catch (Exception e){
            System.out.println("error !");
            return null;
        }
    }

    private static java.util.Date strToDate(String str) {
        try {
            Date date = null;
            java.util.Date date1 = new java.util.Date();
            date1 = Date.valueOf(str);
            return date1;
        }catch (Exception e){
            System.out.println("error !");
            return null;
        }
    }


}
