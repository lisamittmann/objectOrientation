package de.neuefische.testpackage.model;

import java.util.Objects;

public class BiologyStudent extends Student{

    String[] modules;

    public BiologyStudent(String firstName, String lastName, int matriculationNumber) {
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
        BiologyStudent that = (BiologyStudent) o;
        return matriculationNumber == that.matriculationNumber && firstName.equals(that.firstName) && lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, matriculationNumber);
    }
}
