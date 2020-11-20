package java8tests.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
    Java 8 introduces a package called java.util.functions that contains out of the box interfaces for common scenarios
    so they can be used with lambdas. Look for interfaces already available in this package to use them in your lambda.
    For the most part, we dont need to create an interface for Java 8 - Check this package first
 */

/**
 * Created by ffoglia on 12/17/16.
 */
public class LambdaExerciseTwo {

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

        // Step 1: Sort list by last name

        // Java 8
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        // Step 2: Create method that prints all elements in the list

        // In Java 8
        System.out.println("Printing all people");
        performConditionally(people, p -> true, p -> System.out.println(p));

        // Step 3: Create method that prints all people that have last name beginning with letter 'C'

        // In Java 8
        System.out.println("Print people with last name beginning with C");
        performConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));

        // Step 4: Create method that prints all people that have last name beginning with letter 'F'

        // In Java 8
        performConditionally(people, p -> p.getLastName().startsWith("F"), p -> System.out.println(p.getFirstName()));
    }

    // We use two interfaces that come in Java 8  by default: Predicate and Consumer
    private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person person : people) {
            if (predicate.test(person)) {
//                System.out.println(person);
                consumer.accept(person);
            }
        }
    }
}
