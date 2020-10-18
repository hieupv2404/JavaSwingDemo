package nuce.anh.view;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import nuce.anh.model.Student;
import nuce.anh.service.impl.StudentServiceImpl;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class StudentView extends JFrame implements ActionListener, ListSelectionListener {
    private StudentServiceImpl studentServiceImpl;
    private List<Student> studentList;
    private StudentDefaultTableModel studentDefaultTableModel;
    private JTable studentTable;
    private JScrollPane studentScrollPane;
    private JButton addButton;
    private JButton editButton;
    private JButton clearButton;
    private JButton deleteButton;
    private JButton searchButton;

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JLabel addressLabel;

    private JTextField idText;
    private JTextField nameText;
    private JTextField phoneText;
    private JTextField addressText;

    public JTextField getIdText() {
        return idText;
    }

    public StudentView setIdText(JTextField idText) {
        this.idText = idText;
        return this;
    }

    public JTextField getNameText() {
        return nameText;
    }

    public StudentView setNameText(JTextField nameText) {
        this.nameText = nameText;
        return this;
    }

    public JTextField getPhoneText() {
        return phoneText;
    }

    public StudentView setPhoneText(JTextField phoneText) {
        this.phoneText = phoneText;
        return this;
    }

    public JTextField getAddressText() {
        return addressText;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public StudentView setAddButton(JButton addButton) {
        this.addButton = addButton;
        return this;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public StudentView setEditButton(JButton editButton) {
        this.editButton = editButton;
        return this;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public StudentView setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
        return this;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public StudentView setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
        return this;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    public StudentView setAddressText(JTextField addressText) {
        this.addressText = addressText;
        return this;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public StudentView setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        return this;
    }

    public JTable getStudentTable() {
        return studentTable;
    }

    public StudentView setStudentTable(JTable studentTable) {
        this.studentTable = studentTable;
        return this;
    }

    public JScrollPane getStudentScrollPane() {
        return studentScrollPane;
    }

    public StudentView setStudentScrollPane(JScrollPane studentScrollPane) {
        this.studentScrollPane = studentScrollPane;
        return this;
    }

    private String[] columnNames = new String[]{
            "ID", "Name", "Phone", "Address"};
    private Object[][] data = new Object[][]{};

    public StudentView() {
        initComponents();
    }

    private void initComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // tao phim button
        addButton = new JButton("ADD");
        editButton = new JButton("EDIT");
        clearButton = new JButton("CLEAR");
        deleteButton = new JButton("DELETE");
        searchButton = new JButton("SEARCH");

        // tao bang student
        Component table;
        studentScrollPane = new JScrollPane();

        studentTable = new JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };

        // tao cac label
        idLabel = new JLabel("ID");
        nameLabel = new JLabel("NAME");
        phoneLabel = new JLabel("PHONE");
        addressLabel = new JLabel("ADDRESS");

        //tao truong nhap du lieu
        idText = new JTextField();
        idText.setEditable(false);
        nameText = new JTextField();
        phoneText = new JTextField();
        addressText = new JTextField();

        // cai dat cot va du lieu bang
        studentTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        studentScrollPane.setViewportView(studentTable);
        studentScrollPane.setPreferredSize(new Dimension(500,300));

        // tao spring springLayout
        SpringLayout springLayout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(800, 420);
        panel.setLayout(springLayout);

        panel.add(studentScrollPane);

        // add them button, components cho panel.
        panel.add(idLabel);
        panel.add(idText);
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(phoneLabel);
        panel.add(phoneText);
        panel.add(addressLabel);
        panel.add(addressText);

        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(searchButton);

        // cai dat vi tri cho cac component
        springLayout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.WEST, phoneLabel, 10, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, phoneLabel, 70, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, addressLabel, 100, SpringLayout.NORTH, panel);
//        springLayout.putConstraint(SpringLayout.WEST, gpaLabel, 10, SpringLayout.WEST, panel);
//        springLayout.putConstraint(SpringLayout.NORTH, gpaLabel, 200, SpringLayout.NORTH, panel);

        springLayout.putConstraint(SpringLayout.WEST, idText, 100, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, idText, 10, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.WEST, nameText, 100, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, nameText, 40, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.WEST, phoneText, 100, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, phoneText, 70, SpringLayout.NORTH, panel);
//        springLayout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 100, SpringLayout.WEST, panel);
//        springLayout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 100, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.WEST, addressText, 100, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, addressText, 100, SpringLayout.NORTH, panel);

        springLayout.putConstraint(SpringLayout.EAST, idText, -20, SpringLayout.WEST, studentScrollPane);
        springLayout.putConstraint(SpringLayout.EAST, nameText, -20, SpringLayout.WEST, studentScrollPane);
        springLayout.putConstraint(SpringLayout.EAST, phoneText, -20, SpringLayout.WEST, studentScrollPane);
        springLayout.putConstraint(SpringLayout.EAST, addressText, -20, SpringLayout.WEST, studentScrollPane);


        springLayout.putConstraint(SpringLayout.WEST, studentScrollPane, 300, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, studentScrollPane, 10, SpringLayout.NORTH, panel);

        springLayout.putConstraint(SpringLayout.WEST, addButton, 20, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, addButton, 250, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.WEST, editButton, 60, SpringLayout.WEST, addButton);
        springLayout.putConstraint(SpringLayout.NORTH, editButton, 250, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.NORTH, deleteButton, 250, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.WEST, deleteButton, 60, SpringLayout.WEST, editButton);
        springLayout.putConstraint(SpringLayout.NORTH, clearButton, 250, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.WEST, clearButton, 80, SpringLayout.WEST, deleteButton);
        springLayout.putConstraint(SpringLayout.NORTH, searchButton, 200, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.EAST, searchButton, 290, SpringLayout.NORTH, studentScrollPane);
//        springLayout.putConstraint(SpringLayout.WEST, sortStudentGPABtn, 300, SpringLayout.WEST, panel);
//        springLayout.putConstraint(SpringLayout.NORTH, sortStudentGPABtn, 330, SpringLayout.NORTH, panel);
//        springLayout.putConstraint(SpringLayout.WEST, sortStudentNameBtn, 115, SpringLayout.WEST, sortStudentGPABtn);
//        springLayout.putConstraint(SpringLayout.NORTH, sortStudentNameBtn, 330, SpringLayout.NORTH, panel);


        // add vao jframe
        this.add(panel);
        this.pack();
        this.setTitle("Student Information");
        this.setSize(800, 420);

        //disable edit and delete button
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);

        // enable add button
        addButton.setEnabled(true);
    }



    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void getAllStudent(List<Student> studentList){
        int size = studentList.size();
//        Object[][] students =new Object[size][Student.class.getDeclaredFields().length];
        Object[][] students =new Object[size][4];

        for(int i=0; i<size; i++)
        {
            students[i][0] = studentList.get(i).getId();
            students[i][1] = studentList.get(i).getName();
            students[i][2] = studentList.get(i).getPhone();
            students[i][3] = studentList.get(i).getAddress();
        }
        this.studentList = studentList;
        studentTable.setModel(new DefaultTableModel(students,columnNames));
    }

    public void findById(List<Student> studentList){
        int size = studentList.size();
//        Object[][] students =new Object[size][Student.class.getDeclaredFields().length];
        Object[][] students =new Object[size][4];

        for(int i=0; i<size; i++)
        {
            students[i][0] = studentList.get(i).getId();
            students[i][1] = studentList.get(i).getName();
            students[i][2] = studentList.get(i).getPhone();
            students[i][3] = studentList.get(i).getAddress();
        }
        studentTable.setModel(new DefaultTableModel(students,columnNames));
    }

    public void fillStudentFromSelectedRow() {
        // lấy chỉ số của hàng được chọn
        int row = studentTable.getSelectedRow();
        if (row >= 0) {
            idText.setText(studentTable.getModel().getValueAt(row, 0).toString());
            nameText.setText(studentTable.getModel().getValueAt(row, 1).toString());
            phoneText.setText(studentTable.getModel().getValueAt(row, 2).toString());
            addressText.setText(studentTable.getModel().getValueAt(row, 3).toString());
            // enable Edit and Delete buttons
            editButton.setEnabled(true);
            deleteButton.setEnabled(true);
            // disable Add button
            addButton.setEnabled(false);
        }
    }

    public void clearStudentInfo() {
        idText.setText("");
        nameText.setText("");
        phoneText.setText("");
        addressText.setText("");

        // disable Edit and Delete buttons
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
        // enable Add button
        addButton.setEnabled(true);
    }

    public Student getStudentInfo(){
        if(!validateName() || !validatePhone() || !validateAddress() )
            return null;
        try {
            Student student = new Student();
            if (idText.getText() != null && !"".equals(idText.getText())) {
                student.setId(Integer.parseInt(idText.getText()));
            }
            student.setName(nameText.getText().trim());
            student.setPhone(phoneText.getText().trim());
            student.setAddress(addressText.getText().trim());
            return student;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    public Student getStudentInfoSearch(){
        try {
            Student student = new Student();
            student.setName(nameText.getText().trim());
            student.setPhone(phoneText.getText().trim());
            student.setAddress(addressText.getText().trim());
            return student;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    private boolean validateName() {
        String name = nameText.getText();
        if (name == null || "".equals(name.trim())) {
            nameText.requestFocus();
            showMessage("Name không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateAddress() {
        String address = addressText.getText();
        if (address == null || "".equals(address.trim())) {
            addressText.requestFocus();
            showMessage("Address không được trống.");
            return false;
        }
        return true;
    }

    private boolean validatePhone() {
        try {
            String phone = phoneText.getText().trim();
            if (phone.length() < 8 || phone.length() > 10) {
                phoneText.requestFocus();
                showMessage("Phone không hợp lệ, phone nên trong khoảng 8 đến 10.");
                return false;
            }
        } catch (Exception e) {
            phoneText.requestFocus();
            showMessage("Phone  không hợp lệ!");
            return false;
        }
        return true;
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    public void addStudentListener(ActionListener listener){
        addButton.addActionListener(listener);
    }

    public void editStudentListener(ActionListener listener){
        editButton.addActionListener(listener);
    }

    public void deleteStudentListener(ActionListener listener){
        deleteButton.addActionListener(listener);
    }

    public void clearStudentListener(ActionListener listener){
        clearButton.addActionListener(listener);
    }

    public void searchStudentListener(ActionListener listener){
        searchButton.addActionListener(listener);
    }

    public  void chooseStudentListener(MouseAdapter mouseAdapter){
        studentTable.addMouseListener(mouseAdapter);
    }

}
