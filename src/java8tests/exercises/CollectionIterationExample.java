package java8tests.exercises;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ffoglia on 12/18/16.
 */
public class CollectionIterationExample {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alex", "Foglia", 33),
                new Person("Brittain", "Ayres", 25),
                new Person("Olga", "Ghiglione", 65),
                new Person("Kenly", "Ayres", 22),
                new Person("Luis", "Foglia", 66),
                new Person("Michael", "Charleston", 31),
                new Person("Sara", "Conor", 25)
        );

        System.out.println();

        System.out.println("Using for loop");
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }

        System.out.println();

        System.out.println("Using for-in loop");
        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println();

        // New forEach in Java 8 combined with method reference for println method of System.out class
        // This is an internal iterator. Very easy to be ran in parallel or multi-threaded by JVM
        System.out.println("Using forEach loop");
        people.forEach(System.out::println);
    }
}
