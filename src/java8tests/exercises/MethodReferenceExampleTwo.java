package java8tests.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by ffoglia on 12/18/16.
 */
public class MethodReferenceExampleTwo {
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

        System.out.println("Printing all people");
        // Another example where we can replace p -> System.out.println(p) with method reference
        printConditionally(people, p -> true, System.out::println); // p -> method(p)
    }

    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person person : people) {
            if (predicate.test(person)) {
                consumer.accept(person);
            }
        }
    }
}
