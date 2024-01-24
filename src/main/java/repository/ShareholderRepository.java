package repository;

import connection.util.Connector;
import model.Shareholder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShareholderRepository {
    private final Connection connection;

    public ShareholderRepository(Connection connection) {
        this.connection = connection;
    }


    public boolean createShareholder(Shareholder shareholder) throws SQLException {

        String sql = "insert into shareholder(name,phone_number,national_code)values (?,?,? )";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, shareholder.getName());
        preparedStatement.setString(2, shareholder.getPhoneNumber());
        preparedStatement.setInt(3, shareholder.getNationalCode());

        int result = preparedStatement.executeUpdate();
        return (result == 1) ? true : false;
    }

    public Shareholder readShareholder(int shareholder_id) throws SQLException {
        String sql = "select * from shareholder where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Shareholder shareholder = null;
        preparedStatement.setInt(1, shareholder_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String phoneNumber = resultSet.getString(3);
            int nationalCode = resultSet.getInt(4);

            shareholder = new Shareholder(id, name, phoneNumber, nationalCode);
        }
        return shareholder;
    }

    public boolean updateShareholder(Shareholder shareholder) throws SQLException {
        String sql = "update shareholder set\n" +
                "name = ? , phone_number = ? , national_code = ?\n" +
                "where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, shareholder.getName());
        preparedStatement.setString(2, shareholder.getPhoneNumber());
        preparedStatement.setInt(3, shareholder.getNationalCode());
        preparedStatement.setInt(4, shareholder.getId());

        int result = preparedStatement.executeUpdate();
        return (result == 1) ? true : false;
    }

    public boolean dropShareholder(int id) throws SQLException {
        foreignKeyDrop(id);
        String sql = "delete from shareholder\n" +
                "where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int resutl = preparedStatement.executeUpdate();
        return (resutl == 1) ? true : false;
    }

    public void shareholderList() throws SQLException {
        String sql = "select * from shareholder order by id";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String phoneNumber = resultSet.getString(3);
            int nationalCode = resultSet.getInt(4);
            System.out.printf("\n%s ->name : %s   |   phone number : %s   |   national code : %s",
                    id, name, phoneNumber, nationalCode);
        }

    }


    private void foreignKeyDrop(int id) throws SQLException {
        String sql = "delete from shareholder_brand where shareholder_id_fk = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

}
