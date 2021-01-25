package de.neuefische.testpackage.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StudentDb {

    private Student[] studentList;


    public StudentDb(Student[] input) {

        this.studentList = input;

    }

    public String[] listStudentNames() {

        String[] studentNames = new String[this.studentList.length];

        for(int i = 0; i < this.studentList.length; i++) {
            String studentName = studentList[i].getLastName();
            studentNames[i] = studentName;
        }

        return studentNames;
    }

    @Override
    public String toString() {
        String studentListString = "";
        for(int i = 0; i < this.studentList.length; i++){
            String studentName = this.studentList[i].toString();
            studentListString += "(" + studentName + ")";
        }
        return studentListString;
    }
}
