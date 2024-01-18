package application.context;

import connection.util.Connector;
import repository.UserRepository;
import service.UserService;

import java.sql.Connection;

public class ApplicationContext {


    private static final Connection CONNECTION;

    private static final UserRepository USER_REPOSITORY;

    private static final UserService USER_SERVICE;


    static {
        CONNECTION = Connector.getConnection();
        USER_REPOSITORY = new UserRepository(CONNECTION);
        USER_SERVICE = new UserService(USER_REPOSITORY);
    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }
}
