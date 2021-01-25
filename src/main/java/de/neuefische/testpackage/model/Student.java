package de.neuefische.testpackage.model;

public class Student {

    private String firstName;
    private String lastName;
    private int matriculationNumber;

    public Student(String firstName, String lastName, int matriculationNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.matriculationNumber = matriculationNumber;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(int matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public String getStudentInformation() {
        return "Student name: " + this.firstName + " " + this.lastName + ", matriculation number: " + this.matriculationNumber;
    }
}
