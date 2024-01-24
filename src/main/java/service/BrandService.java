package service;

import application.context.ApplicationContext;
import application.context.ValidationUtil;
import connection.util.Connector;
import model.Brand;
import repository.BrandRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class BrandService {
    private Scanner scanner = new Scanner(System.in);
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void crateBrand() throws SQLException {
        try {
            String name, website, description, webAddress, domain;

            System.out.println("enter brand name :");
            name = scanner.next();

            do {
                domain = "https://";
                System.out.println("enter your website :");
                website = scanner.next();
                webAddress = domain + website;
            } while (!ValidationUtil.websiteValidation(webAddress));


            System.out.println("enter description of brand :");
            scanner.nextLine();
            description = scanner.nextLine();


            Brand brand = new Brand(name, webAddress, description);

            Boolean result = brandRepository.createBrand(brand);
            while (result) {
                System.out.printf("\nbrand %s registered !", name);
                break;
            }
        } catch (Exception e) {
            System.out.println("error !");
        }
    }

    public void readBrandById() throws SQLException {
        try {
            System.out.println("\nchoose brand id to read information :");
            int brand_id = scanner.nextInt();
            System.out.println(brandRepository.readBrand(brand_id).toString());
        } catch (Exception exception) {
            System.out.println("enter valid id");
        }
    }


    public void updateBrand() throws SQLException {
        /*gets id with new fields of brand to change in db*/
        try {
            String name, website, description, webAddress, domain;
            int id;

            brandRepository.branderList();

            System.out.println("\n\nenter id of brand to change fields :");
            id = scanner.nextInt();

            System.out.println("change brand's  name :");
            name = scanner.next();

            do {
                domain = "https://";
                System.out.println("enter your website :");
                website = scanner.next();
                webAddress = domain + website;
            } while (!ValidationUtil.websiteValidation(webAddress));


            System.out.println("change brand's description :");
            scanner.nextLine();
            description = scanner.nextLine();

            Brand brand = new Brand(id, name, webAddress, description);

            Boolean result = brandRepository.updateBrand(brand);
            while (result) {
                System.out.printf("\nbrand %s updated !", name);
                break;
            }
        } catch (Exception e) {
            System.out.println("enter valid id !");
        }
    }


    public void deleteBrand() throws SQLException {
        try {
            int id;
            brandRepository.branderList();
            System.out.println("\n\nenter brand id :");
            id = scanner.nextInt();
            Boolean b = brandRepository.dropBrand(id);
            while (b) {
                System.out.printf("%s is removed", id);
                break;
            }
        } catch (Exception e) {
            System.out.println("please enter valid id !");
        }
    }
}