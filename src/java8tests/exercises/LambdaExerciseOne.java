package java8tests.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    Java 8 introduces a package called java.util.functions that contains out of the box interfaces for common scenarios
    so they can be used with lambdas. Look for interfaces already available in this package to use them in your lambdas
 */

/**
 * Created by ffoglia on 12/17/16.
 */
public class LambdaExerciseOne {

    public static void main(String[] args) {
        ArrayList<List<Integer>> group = new ArrayList<List<Integer>>();
        group.add(Arrays.asList(1, 2, 3));
        group.add(Arrays.asList(4, 5, 6));
        group.add(Arrays.asList(7, 8, 9));

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

        // In Java 7
//        Collections.sort(people, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getLastName().compareTo(o2.getLastName());
//            }
//        });

        // Java 8
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        // Step 2: Create method that prints all elements in the list

        // In Java 7
        System.out.println("Printing all people");
//       printAll(people);
        printConditionally(people, p -> true);

        // Step 3: Create method that prints all people that have last name beginning with letter 'C'

        // In Java 7
        System.out.println("Print people with last name beginning with C");
//        printConditionally(people, new Condition() {
//            @Override
//            public boolean test(Person person) {
//                return person.getLastName().startsWith("C");
//            }
//        });
        printConditionally(people, p -> p.getLastName().startsWith("C"));

        // Step 4: Create method that prints all people that have last name beginning with letter 'F'

        // In Java 7
        System.out.println("Print people with last name beginning with F");
//        printConditionally(people, new Condition() {
//            @Override
//            public boolean test(Person person) {
//                return person.getLastName().startsWith("F");
//            }
//        });
        printConditionally(people, p -> p.getLastName().startsWith("F"));
    }

//    private static void printAll(List<Person> people) {
//        for (Person person : people) {
//            System.out.println(person);
//        }
//    }

    private static void printConditionally(List<Person> people, Condition condition) {
        for (Person person : people) {
            if (condition.test(person)) {
                System.out.println(person);
            }
        }
    }
}

// In Java 8, we can use the interface Predicate that does the same as this interface
interface Condition {
    boolean test(Person person);
}
