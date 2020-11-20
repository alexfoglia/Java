package java8tests;

/**
 * Created by ffoglia on 12/17/16.
 */
/*
 Lambda expressions need to implement an interface with one method with same arguments and return types. This is a
 functional interface that enforces that this interface only has one abstract method.
  */
@FunctionalInterface
interface Greeting {

    void perform();

    default void anotherMethod() {
        System.out.println("Hello from default method!");
    }
}
