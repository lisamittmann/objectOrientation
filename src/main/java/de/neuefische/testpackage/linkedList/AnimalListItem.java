package de.neuefische.testpackage.linkedList;

import java.util.LinkedList;
import java.util.Objects;

public class AnimalListItem {

    Animal value;
    AnimalListItem next;

    public AnimalListItem(Animal value) {
        this.value = value;
    }

    public AnimalListItem getNext() {
        return next;
    }

    public void setNext(AnimalListItem next) {
        this.next = next;
    }

    public Animal getValue() {
        return value;
    }

    public void setValue(Animal value) {
        this.value = value;
    }

    public void add(Animal animal) {

        if (this.next == null) {
            AnimalListItem newListItem = new AnimalListItem(animal);
            this.setNext(newListItem);
        } else {
            this.next.add(animal);
        }
    }

/*    Possible different recursive solution with if statements

        public void remove(Animal animal) {

        if(Objects.equals(this.value, animal) && this.next == null){
            this.value = null;
            return;
        }
        if(this.next == null){
            return;
        }
        if (this.next.getValue().equals(animal) && this.next.next != null){
            this.next = next.next;
            return;
        }
        if(this.next.getValue().equals(animal) && this.next.next == null){
            this.next = null;
            return;
        }
        if(Objects.equals(this.value, animal)){
            this.value = this.next.value;
            this.next = this.next.next;
            return;
        }

        this.next.remove(animal);

    }*/

    public void remove(Animal animal) {

        if (this.value.equals(animal)) {
            if (this.next == null) {
                this.value = null;
            } else {
                this.value = this.next.value;
                this.next = this.next.next;
            }
        }

        AnimalListItem currentItem = this;

        while (currentItem != null && currentItem.next != null) {
            if (currentItem.next.value.equals(animal)) {
                currentItem.next = currentItem.next.next;
            }
            currentItem = currentItem.next;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalListItem that = (AnimalListItem) o;
        return Objects.equals(value, that.value) && Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }

    @Override
    public String toString() {

        if (this.next == null) {
            return this.value.toString();
        } else {
            return this.value.toString() + " -> " + this.next.toString();
        }
    }
}
