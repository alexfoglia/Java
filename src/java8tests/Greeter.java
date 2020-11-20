package java8tests;

/**
 * Created by ffoglia on 12/17/16.
 */
public class Greeter {

    public void greet(Greeting myLambda) {
        myLambda.perform();
    }

    public void add(MyAdd addFunction) {
        System.out.println(addFunction.add(5, 4));
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();

        Greeting myLambda = () -> System.out.println("Hello World!");
        myLambda.perform(); // Running lambda function
        myLambda.anotherMethod();

        greeter.greet(myLambda); // Passing lambda function and then running it in method greet

        MyAdd addFunction = (int a, int b) -> a + b;
        greeter.add(addFunction);
    }
}

interface MyAdd {
    int add(int x, int y);
}
