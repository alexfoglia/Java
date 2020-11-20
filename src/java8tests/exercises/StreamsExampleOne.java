package java8tests.exercises;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ffoglia on 12/18/16.
 */
public class StreamsExampleOne {

    /*
        - Lambdas enables functional programming where functions are passed around since they are treated as entities
        - Makes code readable and concise code
        - Easier-to-use APIs and libraries
        - Enables support for parallel processing (Collections to streams that can run parallel operations)
     */
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

        // Get a new list of people whose last name starts with letter F and then print the object
        people.stream()
                .filter(p -> p.getLastName().startsWith("F")) // First we filter
                .forEach(System.out::println); // Then, we print the person object

        // Another example
        long count = people.stream()
                .filter(p -> p.getLastName().startsWith("F"))
                .count();

        System.out.println(count);

        /*
            Streams also allows parallel operations, not only sequential ones like the ones above
            We can also do stream().parallel(), but parallelStream() is better since it already transforms the Collection
            into a parallel stream whereas stream().parallel() first sequentially creates a stream and then makes it
            parallel.
         */
        long countParallel = people.parallelStream()
                .filter(p -> p.getLastName().startsWith("F"))
                .count();

        System.out.println(countParallel);
    }
}
