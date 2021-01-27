package de.neuefische.testpackage.model;

public abstract class Student {

    String firstName;
    String lastName;
    int matriculationNumber;

    public Student(String firstName, String lastName, int matriculationNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.matriculationNumber = matriculationNumber;
    }

    public String getFirstName(){
        return firstName;
    };

    public String getLastName(){
        return lastName;
    };

    public int getMatriculationNumber(){
        return matriculationNumber;
    };

    public abstract String[] getModules();
}
