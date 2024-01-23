package main;

import application.context.ApplicationContext;
import service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private final UserService userService = ApplicationContext.getUserService();


    public void loginMenu() throws SQLException {
        System.out.println("************** Log in menu **************");
        System.out.println("1 : sign up\n" +
                "2 : logging in\n" +
                "3 : exit");
        int choice = scanner.nextInt();
        System.out.println("*****************************************");

        switch (choice) {
            case 1 -> {
                boolean signUp = userService.userSignUp();
                loginMenu();
            }
            case 2 -> {
                boolean loggingIn = userService.userLoggingIn();
                if (loggingIn) {
                    while (true) {
                        menu();
                    }
                } else {
                    System.out.println("logging in failed");
                    loginMenu();
                }
            }case 3->{
                break;
            }
        }
    }


    private void menu() throws SQLException {

        System.out.println("\n\n" +
                "1 : Brand\n" +
                "2 : Category\n" +
                "3 : Shareholder\n" +
                "4 : Product\n" +
                "5 : Share information\n" +
                "6 : exit");
        int id = scanner.nextInt();
        switch (id) {
            case 1 -> {
                brandMenu();
                menu();
            }
            case 2 -> {
                categoryMenu();
                menu();
            }
            case 3 -> {
                shareholderMenu();
                menu();
            }
            case 4 -> {
                productMenu();
                menu();
            }
            case 5 -> {
                sh_brMenu();
                menu();
            }
            case 6 -> {
                loginMenu();
            }
        }
    }

    private void sh_brMenu() throws SQLException {
        System.out.println("\n1 : split share\n" +
                "2 : read brands share \n" +
                "3 : read shares brand \n" +
                "4 : drop share_brand\n" +
                "5 : update share_brand\n" +
                "6 : exit");
        int num = scanner.nextInt();

        switch (num){
            case 1 ->ApplicationContext.getShareholderBrandService().create_BS();
            case 2 ->ApplicationContext.getShareholderBrandService().show_BS();
            case 3 ->ApplicationContext.getShareholderBrandService().show_SB();
            case 4 ->ApplicationContext.getShareholderBrandService().delete_SB();
            case 5 ->ApplicationContext.getShareholderBrandService().update_SB();
            case 6 ->menu();
        }
    }

    private void productMenu() throws SQLException {
        System.out.println("\n1 : create Product\n" +
                "2 : read brand \n" +
                "3 : update Product \n" +
                "4 : drop Product\n" +
                "5 : exit");
        int num = scanner.nextInt();

        switch (num){
            case 1 ->ApplicationContext.getProductService().createProduct();
            case 2 ->ApplicationContext.getProductService().readProduct();
            case 3 ->ApplicationContext.getProductService().updateProduct();
            case 4 ->ApplicationContext.getProductService().dropProduct();
            case 5 ->menu();
        }
    }

    private void shareholderMenu() throws SQLException {
        System.out.println("\n1 : create Shareholder\n" +
                "2 : read Shareholder \n" +
                "3 : update Shareholder \n" +
                "4 : drop Shareholder\n" +
                "5 : exit");
        int num = scanner.nextInt();

        switch (num){
            case 1 ->ApplicationContext.getShareholderService().createShareholder();
            case 2 ->ApplicationContext.getShareholderService().readShareholder();
            case 3 ->ApplicationContext.getShareholderService().updateShareholder();
            case 4 ->ApplicationContext.getShareholderService().dropShareholder();
            case 5 ->menu();
        }
    }

    private void categoryMenu() throws SQLException {
        System.out.println("\n1 : create category\n" +
                "2 : read category \n" +
                "3 : update category \n" +
                "4 : drop category\n" +
                "5 : exit");
        int num = scanner.nextInt();

        switch (num){
            case 1 ->ApplicationContext.getCategoryService().createCategory();
            case 2 ->ApplicationContext.getCategoryService().readCategory();
            case 3 ->ApplicationContext.getCategoryService().updateCategory();
            case 4 ->ApplicationContext.getCategoryService().deleteCategory();
            case 5 ->menu();
        }
    }

    private void brandMenu() throws SQLException {
        System.out.println("\n1 : create brand\n" +
                "2 : read brand \n" +
                "3 : update brand \n" +
                "4 : drop brand\n" +
                "5 : exit");
        int num = scanner.nextInt();

        switch (num){
            case 1 ->ApplicationContext.getBrandService().crateBrand();
            case 2 ->ApplicationContext.getBrandService().readBrandById();
            case 3 ->ApplicationContext.getBrandService().updateBrand();
            case 4 ->ApplicationContext.getBrandService().deleteBrand();
            case 5 ->menu();
        }
    }


}
