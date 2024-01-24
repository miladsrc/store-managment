package service;

import application.context.ValidationUtil;
import model.User;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {

    private final UserRepository userRepository;
    private final Scanner scanner = new Scanner(System.in);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public boolean userSignUp() throws SQLException {

        User user ;
        String name, email, password, username;

        //getName
        System.out.println("enter your name :");
        name = scanner.next();
        //getUsername
        do {
            System.out.println("enter your username :");
            username = scanner.next();
        } while (userRepository.userNameExist(username));
        //getPassword
        do {
            System.out.println("enter your password :");
            password = scanner.next();
        } while (!ValidationUtil.passwordValidator(password));
        //getEmail
        do {
            System.out.println("enter your email :");
            email = scanner.next();
        } while ((!ValidationUtil.emailValidation(email) || userRepository.emailExist(email)));

        user = new User(name,username,email,password);
        System.out.printf("%s registered\n",name);
        return userRepository.addUser(user);
    }


    public boolean userLoggingIn() throws SQLException {
        User user ;
        String  password, username;

        //getUsername
            System.out.println("enter your username :");
            username = scanner.next();

        //getPassword
            System.out.println("enter your password :");
            password = scanner.next();


        user = new User(username,password);
        return userRepository.userExist(user);

    }

}
