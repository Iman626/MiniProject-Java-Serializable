package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class deleteStudentPage extends JPanel {
    private MainFrame parent;
    private JLabel label;
    private JTextField student_id_txt_field;
    private JButton delete_student_btn;
    private JButton back_btn;

    private String header[] = {"id","Name","Surname","age"};
    private JTable table;
    private JScrollPane scrollPane;

    private ArrayList<Students> studentsList = new ArrayList<Students>();

    public deleteStudentPage(MainFrame parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);
        label = new JLabel("Delete Student Page");
        label.setSize(300,30);
        label.setLocation(100,50);
        add(label);

        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(300,180);
        scrollPane.setLocation(100,100);
        add(scrollPane);

        student_id_txt_field = new JTextField();
        student_id_txt_field.setSize(300,30);
        student_id_txt_field.setLocation(100, 300);
        add(student_id_txt_field);

        delete_student_btn = new JButton("Delete Student");
        delete_student_btn.setSize(300,30);
        delete_student_btn.setLocation(100,350);
        add(delete_student_btn);
        delete_student_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer student_id =Integer.parseInt(student_id_txt_field.getText());
                if (!student_id.equals("")){
                    studentsList = parent.readStudents();
                    for (int i=0;i<studentsList.size();i++){
                        if (studentsList.get(i).getId() == (student_id)) {
                            studentsList.remove(i);
                        }
                    }
                    }
                    parent.saveStudent(studentsList);
                    label.setText("STUDENT WAS DELETED");
                    parent.getDeleteStudentPage().generateTable(studentsList);

                }
        });


        back_btn = new JButton("Back");
        back_btn.setSize(300,30);
        back_btn.setLocation(100,400);
        add(back_btn);
        back_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getDeleteStudentPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });


    }
    public void generateTable(ArrayList<Students> studentsList){
        Object data[][] = new Object[studentsList.size()][4];

        for (int i=0;i<studentsList.size();i++){
            data[i][0] = studentsList.get(i).getId();
            data[i][1] = studentsList.get(i).getName();
            data[i][2] = studentsList.get(i).getSurname();
            data[i][3] = studentsList.get(i).getAge();
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
    }
}
