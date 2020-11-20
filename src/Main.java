import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

class MyStack<T> {

    private Node<T> top;
    private int size;

    public MyStack(T data) {
        top = new Node<>(data);
        size = 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public T peak() {
        if (top == null || isEmpty()) throw new EmptyStackException();
        return top.getData();
    }

    public T pop() {
        if (top == null || isEmpty()) throw new EmptyStackException();
        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public void push(T data) {
        Node<T> node = new Node<>(data);
        Node<T> tempNode = top;
        top = node;
        top.setNext(tempNode);
        size++;
    }
}

class MyQueue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public MyQueue(T data) {
        first = new Node<>(data);
        last = first;
        size++;
    }

    public boolean isEmpty() {
        if (size == 0 || first == null) return true;
        return false;
    }

    public T peak() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.getData();
    }

    public void add(T data) {
        Node<T> node = new Node<>(data);
        Node<T> tempNode = last;
        last = node;
        if (size == 1) {
            first.setNext(last);
        } else {
            tempNode.setNext(last);
        }
        size++;
    }

    public T remove() {
        if (first == null || isEmpty()) throw new NoSuchElementException();
        T data = first.getData();
        first = first.getNext();
        size--;
        return data;
    }
}

public class Main {
    final static TreeMap<Integer, String> intToRoman = new TreeMap<>();

    static {
        intToRoman.put(1000, "M");
        intToRoman.put(900, "CM");
        intToRoman.put(500, "D");
        intToRoman.put(400, "CD");
        intToRoman.put(100, "C");
        intToRoman.put(90, "XC");
        intToRoman.put(50, "L");
        intToRoman.put(40, "XL");
        intToRoman.put(10, "X");
        intToRoman.put(9, "IX");
        intToRoman.put(5, "V");
        intToRoman.put(4, "IV");
        intToRoman.put(1, "I");
    }

    public static String integerToRoman(int number) {
        int l =  intToRoman.floorKey(number);
        if (number == l) {
            return intToRoman.get(number);
        }
        return intToRoman.get(l) + integerToRoman(number-l);
    }

    public static String RomanNumerals(int Int) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
            int matches = Int/entry.getValue();
            res += repeat(entry.getKey(), matches);
            Int = Int % entry.getValue();
        }
        return res;
    }
    public static String repeat(String s, int n) {
        if(s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static Integer findMax(Integer[] integers) {
        List<Integer> convertedArray = Arrays.asList(integers);
        return Collections.max(convertedArray);
    }

    public static Set<Integer> removeIntDuplicates(Integer[] numbers) {
        Set<Integer> noDuplicates = new LinkedHashSet<>();
        List<Integer> collectionOfInteger = Arrays.asList(numbers);

        for (Integer number : collectionOfInteger) {
            noDuplicates.add(number);
        }

        return noDuplicates;
    }

    public static String removeDuplicates(String str) {
        if (str == null || str.isEmpty()) return "";

        Set<Character> noDuplicates = new LinkedHashSet<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            noDuplicates.add(c);
        }

        StringBuilder stringNoDuplicates = new StringBuilder(noDuplicates.size());
        for (Character c : noDuplicates) {
            stringNoDuplicates.append(c);
        }

        return stringNoDuplicates.toString();
    }

    public static String removeChaFromString(String str, char c) {
        if (str == null || str.isEmpty()) return "";
        return str.replaceAll(Character.toString(c), "");
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty() || str.length() < 2) return false;
        StringBuffer reverseStr = new StringBuffer(str).reverse();
        return reverseStr.toString().equals(str);
    }

    public static boolean isPalindromeTwo(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String reverseString(String str) {
        if (str == null || str.isEmpty()) return "";
        return new StringBuffer(str).reverse().toString();
    }

    // Calculates fibonnaci number recursively. f(n) = (n-1) + (n-2); f(0) = 0 and f(1) = 1
    public static int fibonacci(int num) {
        if (num <= 1) return num;
        return (fibonacci(num - 1) + fibonacci(num - 2));
    }

    public static int fibonnacciFaster(int num) {
        return fib(num, 0, 1);
    }

    public static int fib(int n, int x, int y) {
        if (n == 0) return x;
        if (n == 1) return y;
        return fib(n - 1, y, x + y);
    }

    public static int answer(int x) {
        String xToString = String.valueOf(x);
        int sum = 0;

        for (int i = 0; i < xToString.length(); i++) {
            sum += Integer.valueOf(String.copyValueOf(xToString.toCharArray(), i, 1));
        }

        if (sum > 9) return answer(sum);

        return sum;

        /* When I try to verify solution, I get:
        public static method answer with parameters (int) not found in com.google.challenges.Answer
        Alright, after reading online I found out that the static method's signature is wrong.
        It automatically created a method with long parameter instead of int. I initially was doing all
        calculations for long and returning and int that previously was casted from long more safely...
        */
    }

    public static Set<List<Integer>> findPairsToTarget(int[] intValues, Integer targetNumber) {
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> intSet = new HashSet<>();

        for (Integer value : intValues) {
            intSet.add(value);
        }

        for (Integer value : intValues) {
            Integer searchNumber = targetNumber - value;
            if (intSet.contains(searchNumber)) {
                List<Integer> tempIntList = new ArrayList<>();
                if (value >= searchNumber) {
                    tempIntList.add(searchNumber);
                    tempIntList.add(value);
                } else {
                    tempIntList.add(value);
                    tempIntList.add(searchNumber);
                }
                result.add(tempIntList);
            }
        }

        return result;
    }

    public static boolean isPermutation(String wordOne, String wordTwo) {
        if (wordOne.length() != wordTwo.length()) {
            return false;
        }

        int[] letterCounter = new int[128];
        char[] wordOneArray = wordOne.toCharArray();

        for (char c : wordOneArray) {
            letterCounter[c]++;
        }

        char[] wordTwoArray = wordTwo.toCharArray();

        for (char c : wordTwoArray) {
            letterCounter[c]--;
            if (letterCounter[c] < 0) {
                return false;
            }
        }

        return true;
    }

    public static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int value = Character.getNumericValue(c);

        if (value >= a && value <= z) {
            return value - a;
        }
        return -1;
    }

    public static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            table[x]++;
        }

        return table;
    }

    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] charFrequencyTable = buildCharFrequencyTable(phrase);
        boolean isFoundOddNumber = false;

        for (int count : charFrequencyTable) {
            if (count % 2 == 1) {
                if (isFoundOddNumber) {
                    return false;
                }
                isFoundOddNumber = true;
            }
        }

        return isFoundOddNumber;
    }

    public static int countPalindromes(String str) {
        if (str == null || str.length() < 2) return 0;

        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                // This next statement will make this a O(n3) algorithm
                if (isPalindrome(str.substring(i, j))) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public static int binarySearch(int[] intArray, int key) {
        if (intArray == null || intArray.length == 0) {
            throw new NoSuchElementException();
        }

        int low = 0;
        int high = intArray.length - 1;
        int mid = high / 2;

        while (key != intArray[mid]) {
            if (key < intArray[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (high + low) / 2;

            if (low > high) {
                throw new NoSuchElementException();
            }
        }

        return intArray[mid];
    }

    public static void mergesort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    public static void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergesort(array, helper, low, middle); // Sort left half
            mergesort(array, helper, middle+1, high); // Sort right half
            merge(array, helper, low, middle, high); // Merge them
        }
    }

    public static void merge(int[] array, int[] helper, int low, int middle, int high) {
		/* Copy both halves into a helper array */
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

		/* Iterate through helper array. Compare the left and right
		 * half, copying back the smaller element from the two halves
		 * into the original array. */
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else { // If right element is smaller than left element
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

		/* Copy the rest of the left side of the array into the
		 * target array */
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

    public static byte reverseByte(byte number) {
        return (byte)(number ^ 255);
    }

    public static void main(String[] args) {
        int num = 17;
        System.out.println("Fibonacci of " + num + ": " + fibonacci(num));

        String str = "Hola, como va?";
        System.out.println("Reverse of " + str + ": " + reverseString(str));

        String str2 = "ABCCBA";
        System.out.println("Is " + str2 + " palindrome? " + isPalindrome(str2));

        String str3 = "abccccaacc";
        char c = 'c';
        System.out.println("Remove " + c + " from " + str3 + ": " + removeChaFromString(str3, c));

        String str4 = "abccccaacc";
        System.out.println("Remove duplicates from " + str4 + ": " + removeDuplicates(str4));

        int a = 3;
        int b = 5;
        System.out.println("Swap a = " + a + " with b = " + b + ": ");
        swap(a, b);
        System.out.println("Result: a = " + a + " and b = " + b);

        System.out.println("Google Challenge 1: " + answer(12323444));

        System.out.println("-------------x--------------");

        for (int i = 1; i < 10; i++){
            System.out.println("Convert Integer " + i + " to Roman: " + integerToRoman(i));
        }

        System.out.println("-------------x--------------");
        Integer[] numbers = new Integer[]{1, 223, 3, 4, 5};
        System.out.println("Max: " + findMax(numbers));

        System.out.println("-------------x--------------");
        Integer[] numbersWithDuplicates = new Integer[]{1, 223, 3, 4, 5, 5, 5 , 6, 6};
        System.out.println("No duplicates: " + removeIntDuplicates(numbersWithDuplicates));

        for (int i = 1;i<256;i++) {
            System.out.println("i=" + i+ " -> " + RomanNumerals(i));
        }

        System.out.println("-------------x--------------");
        Trie trieTree = new Trie();
        trieTree.insert("home");
        trieTree.insert("work");
        System.out.println("Search for home: " + trieTree.search("home"));

        String word = "ACBA";
        System.out.println("Is " + word + " palindrome? " + isPalindromeTwo(word));

        Set<List<Integer>> result = findPairsToTarget(new int[]{1 , 2 , 7 , 2, 4 , 3, 5 , 0, 5, 4}, 5);
        System.out.println("Find pair that sum target 5: " + result.toString());

        int number = 1000;
        System.out.println("Fibonacci of " + number + ": " + fibonnacciFaster(number));

        String strOne = "aabbcc";
        String strTwo = "aabbbcc";
        System.out.println("Is " + strOne + " a permutation of " + strTwo + "? " + isPermutation(strOne, strTwo));

        String permutationOfPalindrome = "aabbbcc";
        System.out.println("Is " + strOne + " a permutation of palindrome? " + isPermutationOfPalindrome(permutationOfPalindrome));

        String testStr = "aabbbcc";
        System.out.println("Number of palindromes in " + testStr + ": " + countPalindromes(testStr));

        MyStack<String> myStack = new MyStack<>("0");
        myStack.push("1");
        myStack.push("2");
        myStack.push("3");
        myStack.push("4");
        myStack.push("5");
        myStack.push("6");
        System.out.println("My Stack Peek after many Push operations: " + myStack.peak());

        while (!myStack.isEmpty()) {
            System.out.println("My Stack: " + myStack.pop());
        }

        System.out.println("");

        MyQueue<String> myQueue = new MyQueue<>("1");
        myQueue.add("2");
        myQueue.add("3");
        myQueue.add("4");
        System.out.println("My Queue Peak after add operations: " + myQueue.peak());

        while (!myQueue.isEmpty()) {
            System.out.println("My Queue: " + myQueue.remove());
        }

        System.out.println("");

        int[] intArray = new int[] {1, 2, 3, 4, 5};
        int key = 1;
        System.out.println("Finding key in array: " + binarySearch(intArray, key));

        System.out.println("");

        int[] sortArray = new int[] {10, 100, 4, 5, 12 ,54, 4, 1 , 3, 0};

        System.out.println("Before Merge Sort");
        for (int element : sortArray) {
            System.out.print(element + " ");
        }

        mergesort(sortArray);

        System.out.println("");
        System.out.println("After Merge Sort");
        for (int element : sortArray) {
            System.out.print(element + " ");
        }

        System.out.println("");

        byte testByte = Byte.parseByte("00100110", 2); // Java uses sign bit
        System.out.println("Reversing byte " + testByte + ": " + reverseByte(testByte));
    }
}
