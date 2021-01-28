package de.neuefische.testpackage;

import de.neuefische.testpackage.linkedList.Animal;
import de.neuefische.testpackage.linkedList.AnimalListItem;
import de.neuefische.testpackage.model.ItStudent;
import de.neuefische.testpackage.model.Student;
import de.neuefische.testpackage.model.StudentDb;

import java.util.ArrayList;

public class AppMain {

    public static void main(String[] args) {
        ItStudent testStudent = new ItStudent("Marvin", "Student", 567);

        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(new ItStudent("Marvin", "Kekse", 224));
        studentList.add(new ItStudent("Steven", "Mueller", 776));


        StudentDb studentDb = new StudentDb(studentList);

        for (int i = 0; i < 8; i++) {
            System.out.println(studentDb.getRandomStudent());
        }
    }
}
