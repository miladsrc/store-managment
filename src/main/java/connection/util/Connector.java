package connection.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static final Connection connection;

    static {
        try {
            connection = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/HW8","postgres","9010231394");
        } catch (SQLException e) {
            System.out.println("connection is not established !");
            throw new RuntimeException(e);
        }
    }

    public Connector() throws SQLException {
    }

    public static Connection getConnection(){
        return connection;
    }
}


