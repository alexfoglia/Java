package java8tests;

/**
 * Created by ffoglia on 12/17/16.
 */
public class TypeInferenceExample {

    public static void printLambda(StringLengthLambda l) {
        System.out.println(l.getLength("Hello Lambda 2"));
    }

    public static void main(String[] args) {
        // JVM knows s is of Type String due to type inference - it knows the interface method takes a String. Also
        // parenthesis can be removed when there is one input argument, so we can reduce the amount of writing.
        StringLengthLambda myLabmda = s -> s.length();
        System.out.println(myLabmda.getLength("Hello Lambda"));

        // I can also pass the lambda and run it in a method
        printLambda(s -> s.length());
    }

    interface StringLengthLambda {
        int getLength(String s);
    }
}
