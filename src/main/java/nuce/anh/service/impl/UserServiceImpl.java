package nuce.anh.service.impl;

import nuce.anh.dao.JDBCConnector;
import nuce.anh.dao.StudentDAO;
import nuce.anh.dao.UserDAO;
import nuce.anh.model.User;
import nuce.anh.service.UserService;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private JDBCConnector jdbcConnector = new JDBCConnector();
    private Connection connection = jdbcConnector.getConnection();
    private UserDAO userDAO = new UserDAO(connection);

    public UserServiceImpl() throws SQLException {
    }

    @Override
    public boolean findUserForLogin(User user) {
        return userDAO.checkUser(user);
    }
}
