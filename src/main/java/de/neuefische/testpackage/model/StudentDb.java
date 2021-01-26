package de.neuefische.testpackage.model;

import java.util.Arrays;

public class StudentDb {

    private Student[] studentList;


    public StudentDb(Student[] input) {

        this.studentList = input;

    }

    public Student[] listStudents() {

        return this.studentList;
    }

    @Override
    public String toString() {
        String studentListString = "";
        for(int i = 0; i < this.studentList.length; i++){
            studentListString += "(" + this.studentList[i] + ")";
        }
        return studentListString;
    }

    public String getRandomStudent() {
        return this.studentList[(int)(Math.random()*studentList.length)].toString();
    }

    public void addStudent(Student student) {

        Student[] newList = new Student[this.studentList.length + 1];

        for(int i = 0; i < this.studentList.length; i++) {
            newList[i] = this.studentList[i];
        }

        newList[this.studentList.length] = student;
        this.studentList = newList;

    }

    public void removeStudent(Student student) {

        Student[] newList = new Student[this.studentList.length - 1];
        int changeIndex = 0;

        for(int i = 0; i < this.studentList.length; i++) {
            if(this.studentList[i].equals(student)) {
                changeIndex += 1;
            } else {
                newList[i - changeIndex] = this.studentList[i];
            }
        }

        this.studentList = newList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDb studentDb = (StudentDb) o;
        return Arrays.equals(studentList, studentDb.studentList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(studentList);
    }
}
