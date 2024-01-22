package repository;

import connection.util.Connector;
import model.Brand;
import model.Category;
import model.Product;

import java.sql.*;

public class ProductRepository {
    private final Connection connection;


    public ProductRepository(Connection connection) {
        this.connection = connection;
    }


    public boolean createProduct(Product product) throws SQLException {

        String sql = "insert into product(name, create_date, category_id_fk, brand_id_fk) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDate(2, (Date) product.getCreateDate());
        preparedStatement.setInt(3, product.getCategoryId());
        preparedStatement.setInt(4, product.getBrandId());

        int result = preparedStatement.executeUpdate();
        return (result == 1) ? true : false;
    }

    public Product readProduct(int int_Product) throws SQLException {
        String sql = "select * from product where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Product product = null;
        preparedStatement.setInt(1, int_Product);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            Date date = resultSet.getDate(3);
            int categoryId = resultSet.getInt(4);
            int brandId = resultSet.getInt(5);
            product = new Product(id, name, date, categoryId, brandId);
        }
        return product;
    }

    public boolean updateProduct(Product product) throws SQLException {
        String sql = "update product set\n" +
                "name = ? , create_date = ?\n" +
                ",category_id_fk = ? , brand_id_fk = ?" +
                "where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDate(2, (Date) product.getCreateDate());
        preparedStatement.setInt(3, product.getCategoryId());
        preparedStatement.setInt(4, product.getBrandId());
        preparedStatement.setInt(5, product.getId());

        int result = preparedStatement.executeUpdate();
        return (result == 1) ? true : false;
    }

    public boolean dropProduct(int id) throws SQLException {
        String sql = "delete from product\n" +
                "where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int result = preparedStatement.executeUpdate();
        return (result == 1) ? true : false;
    }

    public void productList() throws SQLException {

        CategoryRepository categoryRepository = new CategoryRepository(connection);
        BrandRepository brandRepository = new BrandRepository(connection);
        String sql = "select * from product order by id";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            Date date = resultSet.getDate(3);
            int categoryId = resultSet.getInt(4);
            int brandId = resultSet.getInt(5);
            System.out.printf("\n%s ->\nname : %s\ndate : %s\nbrand : %s\ncategory : %s",
                    id, name, date, brandRepository.readBrand(brandId), categoryRepository.readCategory(categoryId));
        }
    }


    public static void main(String[] args) throws SQLException {
        Connection connection1 = Connector.getConnection();
        ProductRepository productRepository = new ProductRepository(connection1);
        String d = "1353-3-4";
        Date date = Date.valueOf(d);
        Product product = new Product("blacked", date, 3, 4);
        productRepository.createProduct(product);
        productRepository.dropProduct(2);
        System.out.println(productRepository.readProduct(3));
        productRepository.productList();
    }


    public void categoryList() throws SQLException {
        String sql = "select * from category order by id";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);
            System.out.printf("\n%s ->name : %s    description : %s",
                    id, name, description);
        }

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
}
