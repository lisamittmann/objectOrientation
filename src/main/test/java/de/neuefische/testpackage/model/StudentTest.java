package de.neuefische.testpackage.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StudentTest {

    @ParameterizedTest
    @MethodSource("student")
    public void testStudentGetterAndSetterFirstName(String firstName, String lastName, int matriculationNumber) {
        Student student = new Student(firstName, lastName, matriculationNumber);
        assertEquals(firstName, student.getFirstName());
    }

    private static Stream<Arguments> student() {
        return Stream.of(
                arguments("Laura", "Mueller", 123),
                arguments("Katharina", "Meyer", 567),
                arguments("Roman", "Schmidt", 489)
        );
    }

    @ParameterizedTest
    @MethodSource("student")
    public void testStudentGetterAndSetterLastName(String firstName, String lastName, int matriculationNumber) {
        Student student = new Student(firstName, lastName, matriculationNumber);
        assertEquals(lastName, student.getLastName());
    }

    @ParameterizedTest
    @MethodSource("student")
    public void testStudentGetterAndSetterMatriculationNumber(String firstName, String lastName, int matriculationNumber) {
        Student student = new Student(firstName, lastName, matriculationNumber);
        assertEquals(matriculationNumber, student.getMatriculationNumber());
    }


}
