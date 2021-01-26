package de.neuefische.testpackage.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StudentDbTest {

    @ParameterizedTest
    @MethodSource("studentList")
    public void testStudentDblistStudentNames(Student[] studentList, Student[] expectedStudents) {
        assertArrayEquals(new StudentDb(studentList).listStudents(), expectedStudents);
    }

    private static Stream<Arguments> studentList() {

        return Stream.of(

                arguments(new Student[]{new ItStudent("Marvin", "Kekse", 224),
                                new ItStudent("Steven", "Mueller", 776)},
                        new Student[]{new ItStudent("Marvin", "Kekse", 224),
                                new ItStudent("Steven", "Mueller", 776)})
        );
    }


    @ParameterizedTest
    @MethodSource("studentAddList")
    public void testAddStudent(StudentDb studentDb, ItStudent addStudent, StudentDb expected) {
        studentDb.addStudent(addStudent);
        assertTrue(expected.equals(studentDb));
    }

    private static Stream<Arguments> studentAddList() {
        return Stream.of(
                arguments(new StudentDb(new ItStudent[]{new ItStudent("Marvin", "Kekse", 224),
                                new ItStudent("Steven", "Mueller", 776)}),
                        new ItStudent("Mavor", "Green", 889),
                        new StudentDb(new ItStudent[]{new ItStudent("Marvin", "Kekse", 224),
                                new ItStudent("Steven", "Mueller", 776),
                                new ItStudent("Mavor", "Green", 889)}))
        );
    }

    @ParameterizedTest
    @MethodSource("studentRemoveList")
    public void testRemoveStudent(StudentDb studentDb, ItStudent removeStudent, StudentDb expected) {
        studentDb.removeStudent(removeStudent);
        assertTrue(expected.equals(studentDb));
    }

    private static Stream<Arguments> studentRemoveList() {
        return Stream.of(
                arguments(new StudentDb(new ItStudent[]{new ItStudent("Marvin", "Kekse", 224),
                                new ItStudent("Steven", "Mueller", 776),
                                new ItStudent("Mavor", "Green", 889),
                                new ItStudent("Dimitriov", "Schaf", 779),
                                new ItStudent("Kasimir", "Flausch", 665)}),
                        new ItStudent("Mavor", "Green", 889),
                        new StudentDb(new ItStudent[]{new ItStudent("Marvin", "Kekse", 224),
                                new ItStudent("Steven", "Mueller", 776),
                                new ItStudent("Dimitriov", "Schaf", 779),
                                new ItStudent("Kasimir", "Flausch", 665)}))
        );
    }
}
