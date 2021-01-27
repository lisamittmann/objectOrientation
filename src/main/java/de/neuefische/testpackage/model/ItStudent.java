package de.neuefische.testpackage.model;

import java.util.Objects;

public class ItStudent extends Student {

    String[] modules;

    public ItStudent(String firstName, String lastName, int matriculationNumber) {
        super(firstName, lastName, matriculationNumber);
    }

    @Override
    public String[] getModules() {
        return modules;
    }

    public void setModules(String[] modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "Student name: " + this.firstName + " " + this.lastName + ", matriculation number: " + this.matriculationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItStudent student = (ItStudent) o;
        return matriculationNumber == student.matriculationNumber && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, matriculationNumber);
    }
}
