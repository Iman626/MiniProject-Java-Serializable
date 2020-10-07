package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class addButtonPage extends JPanel {

    private MainFrame parent;
    private JLabel label;
    private JButton back_btn;

    private JTextField name_txt_field;
    private JTextField surname_txt_field;
    private JComboBox age_c_box;

    private  Integer[] ages = new Integer[100];

    private JButton add_student_btn;

    private ArrayList<Students> student = new ArrayList<Students>();

    public addButtonPage(MainFrame parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);
        label = new JLabel("Add Button Page");
        label.setSize(300,30);
        label.setLocation(100,50);
        add(label);



        name_txt_field = new JTextField();
        name_txt_field.setSize(300,30);
        name_txt_field.setLocation(100,150);
        add(name_txt_field);

        surname_txt_field = new JTextField();
        surname_txt_field.setSize(300,30);
        surname_txt_field.setLocation(100,200);
        add(surname_txt_field);

        for (Integer i=0;i<100;i++){
            ages[i] = i;
        }

        age_c_box = new JComboBox(ages);
        age_c_box.setSize(300,30);
        age_c_box.setLocation(100,250);
        add(age_c_box);

        add_student_btn = new JButton("Add");
        add_student_btn.setSize(300,30);
        add_student_btn.setLocation(100,300);
        add(add_student_btn);
        add_student_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String text_name = name_txt_field.getText();
                    String text_surname = surname_txt_field.getText();
                    Integer age = (Integer) age_c_box.getSelectedItem();
                    if (!text_name.equals("") && !text_surname.equals("")){
                        student = parent.
                                readStudents();
                        Integer id;
                        if(student.size()==0){
                            id = 1;
                        }else {
                            id = student.get(student.size()-1).getId()+1;
                        }
                        System.out.println(student.size());
                        student.add(new Students(id,text_name, text_surname, age));
                        parent.saveStudent(student);
                        label.setText("STUDENT WAS ADDED YOU CAN ADD NEXT STUDENT");
                    }
                }catch (Exception a){
                    a.printStackTrace();
                }

            }
        });

        back_btn = new JButton("Back");
        back_btn.setSize(300,30);
        back_btn.setLocation(100,350);
        add(back_btn);
        back_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAddButtonPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }
}
