package de.neuefische.testpackage.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StudentDbTest {

    @ParameterizedTest
    @MethodSource("studentList")
    public void testStudentDblistStudentNames(Student[] studentList, String[] studentNames) {
        assertTrue(Arrays.equals(studentNames, new StudentDb(studentList).listStudentNames()));
    }

    private static Stream<Arguments> studentList(){

        return Stream.of(

                arguments(new Student[]{new Student("Marvin", "Kekse", 224),
                                new Student("Steven", "Mueller", 776)},
                        new String[]{"Kekse", "Mueller"})
        );
    }
}
