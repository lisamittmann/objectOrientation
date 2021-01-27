package de.neuefische.testpackage;

import de.neuefische.testpackage.model.ItStudent;
import de.neuefische.testpackage.model.StudentDb;

public class AppMain {

    public static void main(String[] args) {
        ItStudent testStudent = new ItStudent("Marvin", "Student", 567);

        StudentDb studentDb = new StudentDb(new ItStudent[]{new ItStudent("Marvin", "Kekse", 224),
                new ItStudent("Steven", "Mueller", 776)});

        System.out.println(studentDb.getRandomStudent());
    }
}
