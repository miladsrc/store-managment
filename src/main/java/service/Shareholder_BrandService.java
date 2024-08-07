package service;

import connection.util.Connector;
import model.Shareholder_Brand;
import repository.Shareholder_BrandRepository;

import java.nio.file.LinkPermission;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Shareholder_BrandService {

    Scanner input = new Scanner(System.in);
    private final Shareholder_BrandRepository shareholderBrandRepository;

    public Shareholder_BrandService(Shareholder_BrandRepository shareholderBrandRepository) {
        this.shareholderBrandRepository = shareholderBrandRepository;
    }

    public void create_BS() throws SQLException {
        try {
            shareholderBrandRepository.shareholderList();
            System.out.println("\nchoose shareholder id :");
            int sh_id = input.nextInt();
            shareholderBrandRepository.branderList();
            System.out.println("\nchoose brand id :");
            int br_id = input.nextInt();

            Shareholder_Brand shareholderBrand = new Shareholder_Brand(sh_id, br_id);

            if (shareholderBrandRepository.createSh_Br(shareholderBrand)) {
                System.out.println("shareholder now has share of brand !");
            }
        } catch (Exception e) {
            System.out.println("error !");
        }
    }

    public void update_SB() throws SQLException {
        try {
            shareholderBrandRepository.shareholderList();
            System.out.println("\nchoose shareholder id to change :");
            int sh_id = input.nextInt();
            int sh_id1 = sh_id;
            shareholderBrandRepository.readShareholdersBrand(sh_id);
            System.out.println("\nchoose previous brand id :");
            int br_id = input.nextInt();
            shareholderBrandRepository.branderList();
            System.out.println("\nchoose next brand id :");
            int br_id1 = input.nextInt();

            Shareholder_Brand shareholderBrand = new Shareholder_Brand(sh_id, br_id);
            Shareholder_Brand shareholderBrand2 = new Shareholder_Brand(sh_id1, br_id1);

            if (shareholderBrandRepository.updateSh_Br(shareholderBrand, shareholderBrand2)) {
                System.out.println("change saved !");
            }
        } catch (Exception e) {
            System.out.println("error !");
        }
    }

    public void delete_SB() throws SQLException {
        try {
            shareholderBrandRepository.shareholderList();
            System.out.println("\nenter shareholder id :");
            int sh_id = input.nextInt();
            shareholderBrandRepository.readShareholdersBrand(sh_id);
            System.out.println("\nchoose brand id :");
            int br_id = input.nextInt();

            Shareholder_Brand shareholderBrand = new Shareholder_Brand(sh_id, br_id);

            if (shareholderBrandRepository.dropSh_Br(shareholderBrand)) {
                System.out.println("share dropped !");
            }
        } catch (Exception e) {
            System.out.println("error !");
        }
    }

    public void show_SB() throws SQLException {
        try {
            shareholderBrandRepository.shareholderList();
            System.out.println("\nchoose shareholder id to see brand(s) :");
            int id = input.nextInt();
            shareholderBrandRepository.readShareholdersBrand(id);
        } catch (Exception e) {
            System.out.println("error !");
        }
    }

    public void show_BS() throws SQLException {
        try {
            shareholderBrandRepository.branderList();
            System.out.println("\nchoose brand id to see shareholder(s) :");
            int id = input.nextInt();
            shareholderBrandRepository.readBrandsShareholder(id);
        } catch (Exception e) {
            System.out.println("error !");
        }
    }
}
