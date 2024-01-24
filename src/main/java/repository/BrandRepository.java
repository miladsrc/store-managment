package repository;

import connection.util.Connector;
import model.Brand;
import model.Shareholder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRepository {
    private final Connection connection;

    public BrandRepository(Connection connection) {
        this.connection = connection;
    }


    public boolean createBrand(Brand brand) throws SQLException {

        String sql = "insert into Brand(name,website,description)values (?,?,? )";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, brand.getName());
        preparedStatement.setString(2, brand.getWebsite());
        preparedStatement.setString(3, brand.getDescription());

        int result = preparedStatement.executeUpdate();
        return (result == 1) ? true : false;
    }

    public Brand readBrand(int int_brand) throws SQLException {

        String sql = "select * from brand where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Brand brand = null;
        preparedStatement.setInt(1, int_brand);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String website = resultSet.getString(3);
            String description = resultSet.getString(4);

            brand = new Brand(id, name, website, description);
        }
        return brand;
    }

    public boolean updateBrand(Brand brand) throws SQLException {
        String sql = "update brand set\n" +
                "name = ? , website = ? , description = ?\n" +
                "where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, brand.getName());
        preparedStatement.setString(2, brand.getWebsite());
        preparedStatement.setString(3, brand.getDescription());
        preparedStatement.setInt(4, brand.getId());

        int result = preparedStatement.executeUpdate();
        return (result == 1) ? true : false;
    }

    public boolean dropBrand(int id) throws SQLException {
        foreignKeyDropProduct(id);
        foreignKeyDrop(id);
        String sql = "delete from brand\n" +
                "where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int resutl = preparedStatement.executeUpdate();
        return (resutl == 1) ? true : false;
    }

    public void branderList() throws SQLException {
        String sql = "select * from brand order by id";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String website = resultSet.getString(3);
            String description = resultSet.getString(4);
            System.out.printf("\n%s ->name : %s   website : %s   description : %s",
                    id, name, website, description);
        }


    }

    private void foreignKeyDrop(int id) throws SQLException {
        String sql = "delete from shareholder_brand where brand_id_fk = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }


    private void foreignKeyDropProduct(int id) throws SQLException {
        String sql = "delete from product where brand_id_fk = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}


