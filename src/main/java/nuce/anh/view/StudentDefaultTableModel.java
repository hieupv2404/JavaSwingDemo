package nuce.anh.view;

import nuce.anh.model.Student;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentDefaultTableModel extends DefaultTableModel {
    List<Student> students = new ArrayList<>();

    public StudentDefaultTableModel(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public int getRowCount() {
        if (students != null) {
            return students.size();
        } else {
            return 0;
        }
    }
    @Override
    public int getColumnCount() {
        return new Student().getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student st = students.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = st.getId();
                break;
            case 1:
                value = st.getName();
                break;
            case 2:
                value = st.getPhone();
                break;
            case 3:
                value = st.getAddress();
                break;
        }
        return value;
    }

    @Override
    public String getColumnName(int column) {
        String name = "";
        switch (column) {
            case 0:
                name = "ID";
                break;
            case 1:
                name = "Name";
                break;
            case 2:
                name = "Phone";
                break;
            case 3:
                name = "Address";
                break;
        }
        return name;
    }
}
