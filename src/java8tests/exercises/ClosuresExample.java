package java8tests.exercises;

/**
 * Created by ffoglia on 12/18/16.
 */
public class ClosuresExample {

    public static void main(String[] args) {
        int a = 10;
        int b = 2;

        doProcess(a, i -> System.out.println(i + b));
    }

    private static void doProcess(int i, Process p) {
        p.process(i);
    }
}

interface Process {
    void process(int i);
}
