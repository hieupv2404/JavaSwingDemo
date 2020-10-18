package nuce.anh.service;

import nuce.anh.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    List<Student> findByName(String searchString) throws SQLException;
    List<Student> selectStudent(Integer id) throws SQLException;
    List<Student> findByProperty(Student student) throws SQLException;
    boolean save(Student student) throws SQLException;
    boolean update(Student student) throws SQLException;
    boolean delete(Student student) throws SQLException;

}
