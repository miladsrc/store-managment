package service;

import connection.util.Connector;
import model.Category;
import repository.CategoryRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CategoryService {

    private final Scanner scanner = new Scanner(System.in);
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public void createCategory() throws SQLException {
        String name, description;
        System.out.println("enter category's name :");
        name = scanner.next();
        System.out.println("enter category's description:");
        scanner.nextLine();
        description = scanner.nextLine();
        Category category = new Category(name, description);
        Boolean result = categoryRepository.createCategory(category);
        while (result) {
            System.out.printf("\n%s is registered !", name);
            break;
        }
    }


    public void readCategory() throws SQLException {

        System.out.println("enter id to read :");
        int id = scanner.nextInt();

        System.out.println(categoryRepository.readCategory(id).toString());
    }


    public void updateCategory() throws SQLException {
        categoryRepository.categoryList();
        System.out.println("\nenter id :");
        int id = scanner.nextInt();
        System.out.println("enter name to change :");
        String name = scanner.next();
        System.out.println("enter description to change :");
        scanner.nextLine();
        String description = scanner.nextLine();

        Category category = new Category(id, name, description);
        Boolean result = categoryRepository.updateCategory(category);
        while (result) {
            System.out.println("category successfully changed !");
            break;
        }
    }


    public void deleteCategory() throws SQLException {
        categoryRepository.categoryList();

        System.out.println("\nenter id to delete category :");
        int id = scanner.nextInt();

        Boolean b = categoryRepository.dropCategory(id);

        while (b) {
            System.out.println("brand has been deleted !");
            break;
        }

    }

}
