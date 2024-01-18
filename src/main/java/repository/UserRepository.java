package repository;

import connection.util.Connector;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private final Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }


    public boolean addUser(User user) throws SQLException {

        String sql = "INSERT  INTO  users(name, username, email, password) values (?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());
        int result = preparedStatement.executeUpdate();

        return (result == 1) ? true : false;
    }

    public boolean userExist(User user) throws SQLException {
        String sql = "select name from users where exists(select name from  users where  username = ? AND  password = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        return (resultSet.next()) ? true : false;
    }

    public boolean emailExist(String email) throws SQLException {
        String sql = "select name from users where exists(select email from users where email = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet result = preparedStatement.executeQuery();
        return (result.next())? true:false;
    }

    public boolean userNameExist(String name) throws SQLException {
        String sql = "select name from users where exists(select email from users where username = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        return (resultSet.next())?true:false;
    }

}
