package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class listStudentsPage extends JPanel {
    private MainFrame parent;

    private JLabel label;
    private JButton back;

    private String header[] = {"id","Name","Surname","age"};
    private JTable table;
    private JScrollPane scrollPane;

    public listStudentsPage(MainFrame parent){

        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        label = new JLabel("listStudentsPage");
        label.setSize(300,30);
        label.setLocation(100,100);
        add(label);

        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(300,200);
        scrollPane.setLocation(100,200);
        add(scrollPane);

        back = new JButton("Back");
        back.setSize(300,30);
        back.setLocation(100,150);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getListStudentsPage().setVisible(false);
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

