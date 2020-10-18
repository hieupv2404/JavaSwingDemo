package nuce.anh.service.impl;

import nuce.anh.dao.JDBCConnector;
import nuce.anh.dao.StudentDAO;
import nuce.anh.model.Student;
import nuce.anh.service.StudentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private JDBCConnector jdbcConnector = new JDBCConnector();
    private Connection connection = jdbcConnector.getConnection();
    private StudentDAO studentDAO = new StudentDAO(connection);
//    private StudentDAO studentDAO;

    public StudentServiceImpl() throws SQLException {
    }

    public List<Student> findAll() throws SQLException {
        return studentDAO.findAll();
    }

    public List<Student> selectStudent(Integer index) throws SQLException {
        return studentDAO.findByRow(index);
    }

    public boolean save(Student student) throws SQLException {
        return studentDAO.save(student);
    }

    public boolean update(Student student) throws SQLException {
        return studentDAO.update(student);
    }

    public boolean delete(Student student) throws SQLException {
        return studentDAO.delete(student);
    }

    @Override
    public List<Student> findByProperty(Student student) throws SQLException {
        return studentDAO.findByProperty(student);
    }


    @Override
    public List<Student> findByName(String searchString) throws SQLException {
        Connection connection = jdbcConnector.getConnection();
        List<Student> students = new ArrayList<>();
        try {
            String sql = "select * from student where name like ? ";
            try {
                PreparedStatement preStatement = connection.prepareStatement(sql);
                preStatement.setString(1, "%" + searchString + "%");
                System.out.println(preStatement);
                ResultSet rs = preStatement.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setPhone(rs.getString("phone"));
                    student.setAddress(rs.getString("address"));
                    students.add(student);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return students;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return students;
    }


}
