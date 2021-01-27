package de.neuefische.testpackage.linkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AnimalListItemTest {

    @Test
    public void testAnimalListItemAdd() {
        // Given
        AnimalListItem firstAnimalListItem = new AnimalListItem(new Animal("capybara"));

        firstAnimalListItem.add(new Animal("hedgehog"));

        // When
        firstAnimalListItem.add(new Animal("squirrel"));

        // Then
        assertTrue(firstAnimalListItem.getNext().getNext().getValue().equals(new Animal("squirrel")));
    }

    @Test
    public void testToString() {

        // Given
        AnimalListItem firstAnimalListItem = new AnimalListItem(new Animal("capybara"));
        firstAnimalListItem.add(new Animal("hedgehog"));
        firstAnimalListItem.add(new Animal("squirrel"));

        // When
        String result = firstAnimalListItem.toString();

        // Then
        assertEquals("capybara -> hedgehog -> squirrel", result);

    }



    @ParameterizedTest
    @MethodSource("animalList")
    public void testAnimalListItemRemove(AnimalListItem head, String remove, String expected) {

        head.remove(new Animal(remove));
        String result = head.toString();

        // Then
        assertEquals(expected, result);

    }

    private static Stream<Arguments> animalList(){

        return Stream.of(
                arguments(returnHead(), "squirrel", "capybara -> hedgehog -> guineaPig"),
                arguments(returnHead(), "capybara", "hedgehog -> squirrel -> guineaPig"),
                arguments(returnHead(), "guineaPig", "capybara -> hedgehog -> squirrel")
        );
    }

    private static AnimalListItem returnHead(){
        AnimalListItem head = new AnimalListItem(new Animal("capybara"));
        head.add(new Animal("hedgehog"));
        head.add(new Animal("squirrel"));
        head.add(new Animal("guineaPig"));
        return head;
    }

    @Test
    public void testSingleElementWithNullValue() {
        AnimalListItem head = new AnimalListItem(new Animal("cat"));
        AnimalListItem expected = new AnimalListItem(new Animal("cat"));
        head.remove(new Animal("dog"));

        assertEquals(expected, head);

    }

    @Test
    public void testRemoveSingleElement() {
        AnimalListItem head = new AnimalListItem(new Animal("cat"));
        AnimalListItem expected = new AnimalListItem(null);
        head.remove(new Animal("cat"));

        assertEquals(expected, head);

    }
}