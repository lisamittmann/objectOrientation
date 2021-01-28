package de.neuefische.testpackage.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StudentDbTest {

    @ParameterizedTest
    @MethodSource("studentList")
    public void testStudentDbListStudentNames(ArrayList<Student> studentList, ArrayList<Student> expectedStudents) {
        assertEquals(new StudentDb(studentList).listStudents(), expectedStudents);
    }

    private static Stream<Arguments> studentList() {

        ArrayList<Student> actual = new ArrayList<Student>();
        actual.add(new ItStudent("Marvin", "Kekse", 224));
        actual.add(new ItStudent("Steven", "Mueller", 776));

        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(new ItStudent("Marvin", "Kekse", 224));
        expected.add(new ItStudent("Steven", "Mueller", 776));

        return Stream.of(

                arguments(actual, expected)
        );
    }


    @ParameterizedTest
    @MethodSource("studentAddList")
    public void testAddStudent(StudentDb studentDb, Student addStudent, StudentDb expected) {
        studentDb.addStudent(addStudent);
        assertEquals(expected, studentDb);
    }

    private static Stream<Arguments> studentAddList() {


        return Stream.of(
                arguments(new StudentDb(new ArrayList<Student>(List.of(
                        new ItStudent("Marvin", "Kekse", 224),
                        new BiologyStudent("Steven", "Mueller", 776)
                        ))),
                        new ItStudent("Mavor", "Green", 889),
                        new StudentDb(new ArrayList<Student>(List.of(
                                new ItStudent("Marvin", "Kekse", 224),
                                new BiologyStudent("Steven", "Mueller", 776),
                                new ItStudent("Mavor", "Green", 889)
                        ))))
        );
    }

    @ParameterizedTest
    @MethodSource("studentRemoveList")
    public void testRemoveStudent(StudentDb studentDb, ItStudent removeStudent, StudentDb expected) {
        studentDb.removeStudent(removeStudent);
        assertEquals(expected, studentDb);
    }

    private static Stream<Arguments> studentRemoveList() {

        return Stream.of(
                arguments(new StudentDb(new ArrayList<Student>() {{
                            add(new ItStudent("Marvin", "Kekse", 224));
                            add(new ItStudent("Steven", "Mueller", 776));
                            add(new ItStudent("Mavor", "Green", 889));
                            add(new ItStudent("Dimitriov", "Schaf", 779));
                            add(new ItStudent("Kasimir", "Flausch", 665));
                        }}),
                        new ItStudent("Mavor", "Green", 889),
                        new StudentDb(new ArrayList<Student>() {{
                            add(new ItStudent("Marvin", "Kekse", 224));
                            add(new ItStudent("Steven", "Mueller", 776));
                            add(new ItStudent("Dimitriov", "Schaf", 779));
                            add(new ItStudent("Kasimir", "Flausch", 665));
                        }}))
        );
    }

    @Test
    public void testAddStudentWithExistingStudent() {

        StudentDb actual = new StudentDb(new ArrayList<Student>(List.of(
                new ItStudent("Marvin", "Kekse", 224),
                new BiologyStudent("Steven", "Mueller", 776),
                new ItStudent("Mavor", "Green", 889)
        )));
        Student student = new ItStudent("Mavor", "Green", 889);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            actual.addStudent(student);
        });

        String expectedMessage = "Student number already exists";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void testAddStudentWithExistingStudentWithTryCatch() {

        StudentDb actual = new StudentDb(new ArrayList<Student>(List.of(
                new ItStudent("Marvin", "Kekse", 224),
                new BiologyStudent("Steven", "Mueller", 776),
                new ItStudent("Mavor", "Green", 889)
        )));
        Student student = new ItStudent("Mavor", "Green", 889);

        try {
            actual.addStudent(student);
            fail();
        } catch (Exception exception) {
            assertEquals(exception.getMessage(), "Student number already exists");
        }
    }

    @ParameterizedTest
    @MethodSource("optionalStudents")
    public void testFindByIdWithOptional(StudentDb studentDb, int id, Optional<Student> expected) {

        assertEquals(studentDb.findById(id), expected);

    }

    private static Stream<Arguments> optionalStudents() {
        StudentDb actual = new StudentDb(new ArrayList<Student>(List.of(
                new ItStudent("Marvin", "Kekse", 224),
                new BiologyStudent("Steven", "Mueller", 776),
                new ItStudent("Mavor", "Green", 889)
        )));

        return Stream.of(
                arguments(actual, 779, Optional.empty()),
                arguments(actual, 776, Optional.of(new  BiologyStudent("Steven", "Mueller", 776)))
        );
    }
}
