package java8tests.exercises;

/**
 * Created by ffoglia on 12/18/16.
 */
public class ThisReferenceExample {

    public void doProcess(int i, Process process) {
        process.process(i);
    }

    public void execute() {
        doProcess(10, i -> {
            System.out.println("Value of i is: " + i);
            System.out.println(this); // This points to instance of object on which execute method is being called
        });
    }

    @Override
    public String toString() {
        return "This is the main ThisReferenceExample class instance";
    }

    public static void main(String[] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

        // Anonymous inner class
        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println("Value of i is: " + i);
                System.out.println(this); // This refers to anonymous inner class instance
            }

            @Override
            public String toString() {
                return "This is the anonymous inner class";
            }
        });

        // Lambda expression. This keyword is treated differently compared to anonymous inner class
        thisReferenceExample.doProcess(10, i -> {
            System.out.println("Value of i is: " + i);
            // Error. Lambda doesn't override the this instance. We are still in static context (main method)
//            System.out.println(this);
        });

        thisReferenceExample.execute();
    }
}
