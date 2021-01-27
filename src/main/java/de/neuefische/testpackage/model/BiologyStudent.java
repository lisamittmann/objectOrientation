package de.neuefische.testpackage.model;

public class BiologyStudent implements Student{

    private String firstName;
    private String lastName;
    private int matriculationNumber;

    public BiologyStudent(String firstName, String lastName, int matriculationNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.matriculationNumber = matriculationNumber;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMatriculationNumber(int matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    @Override
    public String toString() {
        return "Student name: " + this.firstName + " " + this.lastName + ", matriculation number: " + this.matriculationNumber;
    }
}
