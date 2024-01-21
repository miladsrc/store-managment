package repository;

import connection.util.Connector;
import model.Brand;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepository {

    private final Connection connection;
    public CategoryRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean createCategory(Category category) throws SQLException {

        String sql = "insert into category(name,description)values (?,? )";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, category.getName());
        preparedStatement.setString(2, category.getDescription());

        int result = preparedStatement.executeUpdate();
        return (result == 1) ? true : false;
    }

    public Category readCategory(int int_Category) throws SQLException {
        String sql = "select * from category where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Category category = null;
        preparedStatement.setInt(1, int_Category);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);

            category = new Category(id, name, description);
        }
        return category;
    }

    public boolean updateCategory(Category category) throws SQLException {
        String sql = "update category set\n" +
                "name = ? , description = ?\n" +
                "where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, category.getName());
        preparedStatement.setString(2, category.getDescription());
        preparedStatement.setInt(3, category.getId());

        int result = preparedStatement.executeUpdate();
        return (result == 1) ? true : false;
    }

    public boolean dropBrand(int id) throws SQLException {
        String sql = "delete from category\n" +
                "where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int resutl = preparedStatement.executeUpdate();
        return (resutl == 1) ? true : false;
    }

    public void categoryList() throws SQLException {
        String sql = "select * from category order by id";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);
            System.out.printf("\n%s ->\nname : %s\ndescription : %s\n",
                    id, name, description);
        }

    }



}
