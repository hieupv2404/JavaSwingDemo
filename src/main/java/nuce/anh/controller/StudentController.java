package nuce.anh.controller;

import nuce.anh.model.Student;
import nuce.anh.service.impl.StudentServiceImpl;
import nuce.anh.view.StudentView;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

public class StudentController {
    private StudentServiceImpl studentServiceImpl;
    private StudentView studentView;

    public StudentController(StudentView studentView) throws SQLException {
        this.studentServiceImpl = new StudentServiceImpl();
        this.studentView = studentView;

        // add event cho view
        studentView.addStudentListener(new AddStudentListener());
        studentView.clearStudentListener(new ClearStudentListener());
        studentView.editStudentListener(new EditStudentListener());
        studentView.deleteStudentListener(new DeleteStudentListener());
        studentView.searchStudentListener(new SearchStudentListener());
        studentView.chooseStudentListener(new ChooseStudentListener());
    }
    public void showStudentView() {
        List<Student> studentList = null;
        try {
            studentList = studentServiceImpl.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        studentView.setVisible(true);
        studentView.getAllStudent(studentList);
    }

    public void selectStudent() throws SQLException {
        int index = studentView.getStudentTable().getSelectedRow();
        List<Student> studentList = studentServiceImpl.selectStudent(index);
        studentView.setVisible(true);
    }

    class  AddStudentListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if(student!=null)
            {
                try {
                    if(!studentServiceImpl.save(student))
                        studentView.showMessage("Them thanh cong!");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            try {
                studentView.getAllStudent(studentServiceImpl.findAll());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    class ClearStudentListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            studentView.clearStudentInfo();
            try {
                studentView.getAllStudent(studentServiceImpl.findAll());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    class EditStudentListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if(student!=null)
            {
                try {
                    if(!studentServiceImpl.update(student))
                    {
                        studentView.showMessage("Sua thanh cong!");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            try {
                studentView.getAllStudent(studentServiceImpl.findAll());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    class DeleteStudentListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if(student!=null)
            {
                try {
                    if (!studentServiceImpl.delete(student))
                    {
                        studentView.showMessage("Xoa thanh cong!");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            try {
                studentView.clearStudentInfo();
                studentView.getAllStudent(studentServiceImpl.findAll());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    class SearchStudentListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfoSearch();
            if (student!= null)
            {
                try {
                    studentView.getAllStudent(studentServiceImpl.findByProperty(student));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    class ChooseStudentListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            int index = studentView.getStudentTable().getSelectedRow();
            Student student = studentView.getStudentList().get(index);
            studentView.getIdText().setText(String.valueOf(student.getId()));
            studentView.getNameText().setText(student.getName());
            studentView.getPhoneText().setText(student.getPhone());
            studentView.getAddressText().setText(student.getAddress());

            studentView.getAddButton().setEnabled(false);
            studentView.getEditButton().setEnabled(true);
            studentView.getDeleteButton().setEnabled(true);
            studentView.getClearButton().setEnabled(true);
        }
    }

 }



