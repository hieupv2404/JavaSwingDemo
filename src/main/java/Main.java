import nuce.anh.controller.LoginController;
import nuce.anh.controller.StudentController;
import nuce.anh.view.LoginView;
import nuce.anh.view.StudentView;

import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        StudentView studentView = new StudentView();
//        StudentController studentController = new StudentController(studentView);
//        studentController.getAllStudents();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView view = new LoginView();
                LoginController controller = null;
                try {
                    controller = new LoginController(view);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                // hiển thị màn hình login
                controller.showLoginView();
            }
        });
    }
}
