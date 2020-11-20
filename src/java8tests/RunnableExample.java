package java8tests;

/**
 * Created by ffoglia on 12/17/16.
 */
public class RunnableExample {

    public static void main(String[] args) {

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed inside Runnable");
            }
        });

        // This calls run method of Runnable
//        myThread.run();

        // This creates a new thread and starts runs it
        myThread.start();

        // We can do the same as above but using Lambdas. This works because Runnable only has one method, otherwise we
        // cannot use lambdas
        Thread myLambdaThread = new Thread(() -> System.out.println("Printed inside Runnable with Lambda"));
        myLambdaThread.start();
    }
}
