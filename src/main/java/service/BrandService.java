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
        String name, website, description;

        System.out.println("enter brand name :");
        name = scanner.next();

        do {
            System.out.println("enter your website :");
            website = scanner.next();
        } while (!ValidationUtil.websiteValidation(website));


        System.out.println("enter description of brand :");
        scanner.nextLine();
        description = scanner.nextLine();


        Brand brand = new Brand(name, website, description);

        Boolean result = brandRepository.createBrand(brand);
        while (result) {
            System.out.printf("\nbrand %s registered !", name);
            break;
        }
    }

    public void readBrandById() throws SQLException {
        System.out.println("\nchoose brand to read information :");
        int brand_id = scanner.nextInt();
        System.out.println(brandRepository.readBrand(brand_id).toString());
    }


    public void updateBrand() throws SQLException {
        /*gets id with new fields of brand to change in db*/

        String name, website, description;
        int id;

        brandRepository.branderList();

        System.out.println("\n\nenter id of brand to change fields :");
        id = scanner.nextInt();

        System.out.println("change brand's  name :");
        name = scanner.next();

        do {
            System.out.println("change brand's  website :");
            website = scanner.next();
        } while (!ValidationUtil.websiteValidation(website));

        System.out.println("change brand's description :");
        scanner.nextLine();
        description = scanner.nextLine();

        Brand brand = new Brand(id,name, website, description);

        Boolean result = brandRepository.updateBrand(brand);
        while (result) {
            System.out.printf("\nbrand %s updated !", name);
            break;
        }

    }


    public void deleteBrand() throws SQLException {

        int id ;
        brandRepository.branderList();
        System.out.println("\n\nenter brand id :");
        id = scanner.nextInt();
        Boolean b = brandRepository.dropBrand(id);
        while (b){
            System.out.printf("%s is removed",id);
            break;
        }
    }
}