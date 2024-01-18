package main;

import application.context.ApplicationContext;
import service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private final UserService userService = ApplicationContext.getUserService();




    public void runProgram() throws SQLException {
        System.out.println("-->");
        System.out.println("* welcome user *");
        System.out.println("1 : sign up\n" +
                "2 : logging in\n" +
                "3 : exit");
        System.out.print("-->\n");
        int choice = scanner.nextInt();

        switch (choice){
            case 1->{
                boolean signUp =userService.userSignUp();
                runProgram();
            }
            case 2->{
                boolean loggingIn = userService.userSignUp();
                if (loggingIn){
                    

                }else {
                    System.out.println("logging in failed");
                    runProgram();
                }
            }
        }
    }




}
