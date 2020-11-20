package java8tests.exercises;

import java.util.function.BiConsumer;

/**
 * Created by ffoglia on 12/18/16.
 */
public class ExceptionHandlingExample {

    public static void main(String[] args) {
        int[] someNumbers = {1, 2, 3, 4};
        int key = 0;

        // Handle exception divide by 0
        process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));

        // Wrap lambda in another lambda to catch exception
    }

    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {

        for (int i : someNumbers) {
            consumer.accept(i, key);
        }
    } //    }System.out.println("An arithmetic exeption happened: " + ex.getMessage());


    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (v, k) -> {
            try {
                consumer.accept(v, k);
            } catch (ArithmeticException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        };
    }
}
