package nuce.anh.dao;

import nuce.anh.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection connection;
    private List<Student> studentList;


    public StudentDAO(Connection connection) {
        this.connection = connection;
        this.studentList = new ArrayList<>();
    }

    public List<Student> findAll() throws SQLException {
        studentList = new ArrayList<>();
        String sql = "select * from student";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next())
                {
                    Student student= new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setPhone(resultSet.getString("phone"));
                    student.setAddress(resultSet.getString("address"));
                    studentList.add(student);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
        }
        return studentList;
    }

    public List<Student> findByRow(Integer index) throws SQLException {
        String sql = "select * from student";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
              while (resultSet.next())
              {
                  Student student = new Student();
                  student.setId(resultSet.getInt("id"));
                  student.setName(resultSet.getString("name"));
                  student.setPhone(resultSet.getString("phone"));
                  student.setAddress(resultSet.getString("address"));
                  studentList.add(student);
              }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {

        }
        return studentList;
    }


    public boolean save(Student student) throws SQLException {
        String sql = "select max(id) as id from student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        int maxID =0;
        while(resultSet.next()) {
            maxID = resultSet.getInt("id");
        }

        sql = "insert into student (id,name,phone,address)" +
                "values (?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,maxID+1);
        preparedStatement.setString(2,student.getName());
        preparedStatement.setString(3,student.getPhone());
        preparedStatement.setString(4,student.getAddress());
        return preparedStatement.execute();
    }

    public boolean update(Student student) throws SQLException {
        String sql = "update student set name=?, phone=?, address=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,student.getName());
        preparedStatement.setString(2,student.getPhone());
        preparedStatement.setString(3,student.getAddress());
        preparedStatement.setInt(4,student.getId());
        return preparedStatement.execute();
    }

    public boolean delete(Student student) throws SQLException {
        String sql = "delete from student where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,student.getId());
        return preparedStatement.execute();
    }

    public List<Student> findByProperty(Student student) throws SQLException {
        studentList = new ArrayList<>();
        int check=1, search=1;
            String sqlAppend = "";
            StringBuilder sql = new StringBuilder("select * from student where ");
            if(!student.getName().equals("") && check==1){
                sqlAppend="name like '%"+student.getName()+"%'";
                sql.append(sqlAppend);
                if(!student.getPhone().equals("")){
                    sqlAppend =" and phone like '%"+student.getPhone()+"%'";
                    sql.append(sqlAppend);
                }
                if(!student.getAddress().equals("")){
                    sqlAppend =" and address like '%"+student.getAddress()+"%'";
                    sql.append(sqlAppend);
                }
                check=0;
                search=0;
            }
            if(!student.getPhone().equals("") && check==1){
                sqlAppend="phone like '%"+student.getPhone()+"%'";
                sql.append(sqlAppend);
                if(!student.getName().equals("")){
                    sqlAppend =" and name like '%"+student.getName()+"%'";
                    sql.append(sqlAppend);
                }
                if(!student.getAddress().equals("")){
                    sqlAppend =" and address like '%"+student.getAddress()+"%'";
                    sql.append(sqlAppend);
                }
                check=0;
                search=0;
            }
            if(!student.getAddress().equals("") && check==1){
                sqlAppend="address like '%"+student.getAddress()+"%'";
                sql.append(sqlAppend);
                if(!student.getName().equals("")){
                    sqlAppend =" and name like '%"+student.getName()+"%'";
                    sql.append(sqlAppend);
                }
                if(!student.getPhone().equals("")){
                    sqlAppend =" and phone like '%"+student.getPhone()+"%'";
                    sql.append(sqlAppend);
                }
                check=0;
                search=0;
            }
                if (search==1)
                {
                    sqlAppend="name like '%"+student.getName()+"%'";
                    sql.append(sqlAppend);
                }
                PreparedStatement preparedStatement = connection.prepareStatement(String.valueOf(sql));
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    Student student1= new Student();
                    student1.setId(resultSet.getInt("id"));
                    student1.setName(resultSet.getString("name"));
                    student1.setPhone(resultSet.getString("phone"));
                    student1.setAddress(resultSet.getString("address"));
                    studentList.add(student1);
                }
        return studentList;
    }
}
