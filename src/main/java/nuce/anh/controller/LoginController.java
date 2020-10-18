package nuce.anh.controller;

import nuce.anh.model.User;
import nuce.anh.service.impl.UserServiceImpl;
import nuce.anh.view.LoginView;
import nuce.anh.view.StudentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginController {
    private UserServiceImpl userServiceImpl;
    private LoginView loginView;
    private StudentView studentView;

    public LoginController(LoginView view) throws SQLException {
        this.loginView = view;
        this.userServiceImpl = new UserServiceImpl();
        view.addLoginListener(new LoginListener());
    }

    public void showLoginView() {
        loginView.setVisible(true);
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getLoginInfo();
            if(user!=null) {
                if (userServiceImpl.findUserForLogin(user)) {
                    // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
                    studentView = new StudentView();
                    StudentController studentController = null;
                    try {
                        studentController = new StudentController(studentView);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    studentController.showStudentView();
                    loginView.setVisible(false);
                } else {
                    loginView.showMessage("Username hoặc Password không đúng.");
                }
            }
        }
    }
}

