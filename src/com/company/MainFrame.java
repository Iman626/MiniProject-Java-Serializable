package com.company;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private com.company.mainMenuPage mainMenuPage;
    private addButtonPage addButtonPage;
    private com.company.listStudentsPage listStudentsPage;
    private com.company.deleteStudentPage deleteStudentPage;

    private ArrayList<Students> studentsList = new ArrayList<Students>();

    public MainFrame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("miniDesktopApp");
        setSize(500, 500);
        setLayout(null);



        mainMenuPage = new mainMenuPage(this);
        mainMenuPage.setVisible(true);
        add(mainMenuPage);

        addButtonPage = new addButtonPage(this);
        addButtonPage.setVisible(false);
        add(addButtonPage);

        listStudentsPage = new listStudentsPage(this);
        listStudentsPage.setVisible(false);
        add(listStudentsPage);

        deleteStudentPage = new deleteStudentPage(this);
        deleteStudentPage.setVisible(false);
        add(deleteStudentPage);

    }

    public com.company.mainMenuPage getMainMenuPage() {
        return mainMenuPage;
    }

    public addButtonPage getAddButtonPage() {
        return addButtonPage;
    }

    public com.company.listStudentsPage getListStudentsPage() {
        return listStudentsPage;
    }

    public com.company.deleteStudentPage getDeleteStudentPage(){
        return deleteStudentPage;
    }


    public ArrayList<Students> getStudentList() {
        return studentsList;
    }

    public void setStudentsList(ArrayList<Students> students) {
        this.studentsList = studentsList;
    }
    public static void saveStudent(ArrayList<Students> studentsList){
        try{
            ObjectOutputStream outputStream =
                    new ObjectOutputStream(new FileOutputStream("studentslist.dat"));
            outputStream.writeObject(studentsList);
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Students> readStudents(){
        ArrayList<Students> studentsList = new ArrayList<Students>();
        try{
            ObjectInputStream inputStream =
                    new ObjectInputStream(new FileInputStream("studentslist.dat"));
            studentsList = (ArrayList<Students>) inputStream.readObject();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return studentsList;
    }
}
