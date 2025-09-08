package src;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class StudentCRUDApp extends JFrame {
    private JTextField txtId, txtName;
    private JTextArea txtDisplay;
    private ArrayList<Student> studentList;
    private final String FILE_NAME = "students.dat";

    public StudentCRUDApp() {
        setTitle("Student CRUD App");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblId = new JLabel("Student ID:");
        lblId.setBounds(20, 20, 100, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(130, 20, 200, 25);
        add(txtId);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(20, 60, 100, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(130, 60, 200, 25);
        add(txtName);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(20, 100, 80, 25);
        add(btnAdd);

        JButton btnView = new JButton("View All");
        btnView.setBounds(110, 100, 100, 25);
        add(btnView);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(220, 100, 100, 25);
        add(btnSearch);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(20, 140, 100, 25);
        add(btnDelete);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(130, 140, 100, 25);
        add(btnUpdate);

        txtDisplay = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtDisplay);
        scroll.setBounds(20, 180, 340, 150);
        add(scroll);

        studentList = loadData();

        btnAdd.addActionListener(e -> addStudent());
        btnView.addActionListener(e -> viewStudents());
        btnSearch.addActionListener(e -> searchStudent());
        btnDelete.addActionListener(e -> deleteStudent());
        btnUpdate.addActionListener(e -> updateStudent());

        setVisible(true);
    }

    private void addStudent() {
        String id = txtId.getText().trim();
        String name = txtName.getText().trim();
        if (id.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill both fields.");
            return;
        }
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                JOptionPane.showMessageDialog(this, "Student ID already exists!");
                return;
            }
        }
        studentList.add(new Student(id, name));
        saveData();
        JOptionPane.showMessageDialog(this, "Student added.");
    }

    private void viewStudents() {
        txtDisplay.setText("");
        for (Student s : studentList) {
            txtDisplay.append(s + "\n");
        }
    }

    private void searchStudent() {
        String id = txtId.getText().trim();
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                txtDisplay.setText("Found: " + s);
                return;
            }
        }
        txtDisplay.setText("Student not found.");
    }

    private void deleteStudent() {
        String id = txtId.getText().trim();
        studentList.removeIf(s -> s.getId().equals(id));
        saveData();
        JOptionPane.showMessageDialog(this, "Student deleted (if existed).");
    }

    private void updateStudent() {
        String id = txtId.getText().trim();
        String name = txtName.getText().trim();
        for (Student s : studentList) {
            if (s.getId().equals(id)) {
                s.setName(name);
                saveData();
                JOptionPane.showMessageDialog(this, "Student updated.");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Student not found.");
    }

    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Student> loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Student>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        new StudentCRUDApp();
    }
}
