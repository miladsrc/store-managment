package repository;

import model.Product;
import model.Shareholder_Brand;

import java.sql.*;

public class Shareholder_BrandRepository {
private final Connection connection;
    public Shareholder_BrandRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean createSh_Br(Shareholder_Brand shareholderBrand) throws SQLException {

        String sql = "insert into shareholder_brand(shareholder_id_fk, brand_id_fk) values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, shareholderBrand.getShareholder_id());
        preparedStatement.setInt(2, shareholderBrand.getBrand_id());

        preparedStatement.executeUpdate();
            return true;

    }

    public void readShareholdersBrand(int shareholder_id) throws SQLException {
        String sql ="select shareholder_id_fk,shareholder.name,brand_id_fk, b.name\n" +
                "from shareholder\n" +
                "         inner join shareholder_brand sb on shareholder.id = sb.shareholder_id_fk\n" +
                "         inner join brand b on b.id = sb.brand_id_fk\n" +
                "GROUP BY shareholder.id, shareholder.name, phone_number, national_code, shareholder_id_fk, brand_id_fk, b.id, b.name,\n" +
                "         website, description\n" +
                "having shareholder.id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, shareholder_id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int shareId = resultSet.getInt(1);
            String share_name = resultSet.getString(2);
            int brandId = resultSet.getInt(3);
            String brand_name = resultSet.getString(4);
            System.out.printf("\nid : %s ->shareholder_name : %s  | id :%s -> brand : %s",shareId,share_name,brandId,brand_name);
        }
    }


    public void readBrandsShareholder(int brand_id) throws SQLException {
        String sql = "select brand_id_fk, brand.name,shareholder_id_fk, s.name\n" +
                "from brand\n" +
                "         inner join shareholder_brand sb on brand.id = sb.brand_id_fk\n" +
                "         join shareholder s on s.id = sb.shareholder_id_fk\n" +
                "group by brand_id_fk, brand.name, shareholder_id_fk, s.name\n" +
                "HAVING brand_id_fk = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, brand_id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int brandId = resultSet.getInt(1);
            String share_name = resultSet.getString(2);
            int shareId = resultSet.getInt(3);
            String brand_name = resultSet.getString(4);
            System.out.printf("\nid : %s -> brand : %s  | id : %s ->  shareholder : %s",brandId,brand_name,shareId,share_name);
        }
    }


    public boolean updateSh_Br(Shareholder_Brand setShareholderBrand1 , Shareholder_Brand shareholderBrand2) throws SQLException {
        String sql = "delete from shareholder_brand where shareholder_id_fk = ? and brand_id_fk = ?;\n" +
                "insert into shareholder_brand(shareholder_id_fk, brand_id_fk) values (?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, setShareholderBrand1.getShareholder_id());
        preparedStatement.setInt(2, setShareholderBrand1.getBrand_id());
        preparedStatement.setInt(3, shareholderBrand2.getShareholder_id());
        preparedStatement.setInt(4, shareholderBrand2.getBrand_id());

        int result = preparedStatement.executeUpdate();
        return (result == 1) ? true : false;
    }

    public boolean dropSh_Br(Shareholder_Brand shareholderBrand) throws SQLException {
        String sql = "delete from shareholder_brand \n" +
                "where shareholder_id_fk = ? and brand_id_fk = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, shareholderBrand.getShareholder_id());
        preparedStatement.setInt(2, shareholderBrand.getBrand_id());

        int resutl =preparedStatement.executeUpdate();
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


    public void shareholderList() throws SQLException {
        String sql="select * from shareholder order by id";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String phoneNumber = resultSet.getString(3);
            int nationalCode = resultSet.getInt(4);
            System.out.printf("\n%s ->name : %s   |   phone number : %s   |   national code : %s",
                    id,name,phoneNumber,nationalCode);
        }

    }

}
