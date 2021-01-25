package de.neuefische.testpackage;

import de.neuefische.testpackage.model.Student;

public class AppMain {

    public static void main(String[] args) {
        Student testStudent = new Student("Marvin", "Student", 567);

        System.out.println(testStudent.toString());
    }
}
