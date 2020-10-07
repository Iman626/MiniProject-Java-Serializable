package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class mainMenuPage extends JPanel {

    private MainFrame parent;

    private JButton addButton;
    private JButton listStudents;
    private JButton deleteStudents;
    private JButton exitButton;

    private ArrayList<Students> studentsList = new ArrayList<Students>();

    public mainMenuPage(MainFrame parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        addButton = new JButton("Add Button");
        addButton.setSize(300,30);
        addButton.setLocation(100,100);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getMainMenuPage().setVisible(false);
                parent.getAddButtonPage().setVisible(true);
            }
        });


        listStudents = new JButton("List of Students");
        listStudents.setSize(300,30);
        listStudents.setLocation(100,150);
        add(listStudents);
        listStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setStudentsList(studentsList = parent.readStudents());
                parent.getListStudentsPage().generateTable(studentsList);
                parent.getMainMenuPage().setVisible(false);
                parent.getListStudentsPage().setVisible(true);
            }
        });

        deleteStudents = new JButton("Delete Student");
        deleteStudents.setSize(300,30);
        deleteStudents.setLocation(100,200);
        add(deleteStudents);
        deleteStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setStudentsList(studentsList = parent.readStudents());
                parent.getDeleteStudentPage().generateTable(studentsList);
                parent.getMainMenuPage().setVisible(false);
                parent.getDeleteStudentPage().setVisible(true);
            }
        });

        exitButton = new JButton("Exit");
        exitButton.setSize(300,30);
        exitButton.setLocation(100,250);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

}
