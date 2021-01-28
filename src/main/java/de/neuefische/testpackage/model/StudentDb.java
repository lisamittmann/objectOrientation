package de.neuefische.testpackage.model;

import java.util.*;

public class StudentDb {

    private HashMap<Integer, Student> studentList = new HashMap<Integer, Student>();


    public StudentDb(ArrayList<Student> input) {

        for (Student student : input) {
            studentList.put(student.getMatriculationNumber(), student);
        }

    }

    public ArrayList<Student> listStudents() {

        ArrayList<Student> students = new ArrayList<Student>();

        studentList.forEach((k, v) -> {
            students.add(v);
        });

        return students;
    }

    @Override
    public String toString() {
        String studentListString = "";
        ArrayList<Student> studentArray = this.listStudents();

        for(int i = 0; i < studentArray.size(); i++){
            studentListString += "(" + studentArray.get(i) + ")";
        }
        return studentListString;
    }

    public String getRandomStudent() {
         ArrayList<Student> studentArray = this.listStudents();

        return studentArray.get((int)(Math.random()*studentArray.size())).toString();
    }

    public void addStudent(Student student) {

        if(containsStudent(student)){
            throw new RuntimeException("Student number already exists");
        }

        this.studentList.put(student.getMatriculationNumber(), student);

    }

    public Optional<Student> findById(int id) {
        if (this.studentList.containsKey(id)) {
            return Optional.of(this.studentList.get(id));
        } else {
            return Optional.empty();
        }
    }

    private boolean containsStudent(Student student) {
        return this.studentList.containsKey(student.getMatriculationNumber());
    }

    public void removeStudent(Student student) {

        this.studentList.remove(student.getMatriculationNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDb studentDb = (StudentDb) o;
        return Objects.equals(studentList, studentDb.studentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentList);
    }
}
