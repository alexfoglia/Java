package java8tests.exercises;

/**
 * Created by ffoglia on 12/18/16.
 */
public class MethodReferenceExampleOne {

    public static void main(String[] args) {
        // One way of using lambda expression
//        Thread myThread = new Thread(() -> printMessage());
//        myThread.start();

        // Another way of using lambda expression. Using method references: input params and passing params need to match
        // NameOfClass :: methodName. It can be a shortcut, sometimes it is more writing, like in this case
        Thread myThread = new Thread(MethodReferenceExampleOne::printMessage); // () -> method()
        myThread.start();
    }

    public static void printMessage() {
        System.out.println("Hello");
    }
}
