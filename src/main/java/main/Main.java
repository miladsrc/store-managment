package main;

import java.sql.SQLException;

public class Main {

    private static Menu menu = new Menu();
    public static void main(String[] args) throws SQLException {
        menu.loginMenu();
    }
}