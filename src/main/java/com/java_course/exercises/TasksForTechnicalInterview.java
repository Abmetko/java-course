package com.java_course.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings({"InfiniteLoopStatement", "InfiniteRecursion"})
public class TasksForTechnicalInterview {

    public static void printEndLessTime1() {
        for (; ; ) {
            for (int i = 1; i < 11; i++) {
                System.out.println(i);
            }
        }
    }

    //in any moment the StackOverFlowError will be generated
    public static void printEndLessTime2() {
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }
        printEndLessTime2();
    }

    public static String returnReversedString(String text) {
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            char buffer = array[array.length - i - 1];
            array[array.length - i - 1] = array[i];
            array[i] = buffer;
        }
        return String.valueOf(array);
    }

    public static void methodGetsMethodAndPassingAllArgsThrowTheMethod(Executor executor, int[] args) {
        executor.execute(args);
    }

    public static void main(String[] args) {
        System.out.println(returnReversedString("USER"));


        methodGetsMethodAndPassingAllArgsThrowTheMethod((array) -> {
            for (int a : array) {
                System.out.println("The value passed to lambda expression: " + a);
            }
        }, new int[]{1, 2, 3, 4, 5, 6});


        System.out.println("Count of words in sentence: " + getCountOfWordsInSentence("  Hello world is the most popular phrase in the world. "));


        System.out.println("Is array as a rising arrangement: " + isTheArrayRisingArrangement(new int[]{1, 2, 3, 4, 5, 100}));


        changeValuesOfTwoVariables();


        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        System.out.println("Are two arrays equal: " + Arrays.stream(arr1).boxed().collect(Collectors.toList())
                .equals(Arrays.stream(arr2).boxed().collect(Collectors.toList())));//true


        System.out.println("Are two arrays equal: " + areTwoArraysEqual(new int[]{1, 2, 3}, new int[]{1, 2, 3}));//true
        System.out.println("Are two arrays equal: " + areTwoArraysEqual(new int[]{1, 2, 2}, new int[]{1, 2, 3}));//false

        iterateEntriesFromMap();
    }

    public static int getCountOfWordsInSentence(String sentence) {
        String trimmedSentence = sentence.trim();
        char[] charArray = trimmedSentence.toCharArray();
        int count = 0;
        for (char i : charArray) {
            if (i == ' ') {
                count++;
            }
        }
        count++;
        return count;
    }

    public static boolean isTheArrayRisingArrangement(int[] array) {
        boolean isRising = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                isRising = false;
                break;
            }
        }
        return isRising;
    }

    public static void changeValuesOfTwoVariables() {
        int a = 2;
        int b = 3;
        a = a * b / (b = (a * b) / b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static boolean areTwoArraysEqual(int[] arr1, int[] arr2) {
        boolean isEqual = true;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                isEqual = false;
                break;
            }
        }
        return isEqual;
    }

    public static void iterateEntriesFromMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Jim", 30);
        map.put("Sam", 29);
        map.put("Larry", 66);

        //way 1
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("Ma name is %s, and my age is %s%n", entry.getKey(), entry.getValue());
        }
        //way 2
        map.forEach((key, value) -> System.out.printf("Ma name is %s, and my age is %s%n", key, value));
    }
}

@FunctionalInterface
interface Executor {
    void execute(int[] args);
}

class QueueTest {
    private int getIndex;
    private int putIndex;
    private final char[] queue;

    public QueueTest(int queueSize) {
        putIndex = 0;
        getIndex = 0;
        this.queue = new char[queueSize + 1];
    }

    public char get() {
        if (getIndex == putIndex) {
            System.out.println("Queue is empty.");
            return 0;
        }
        char le = queue[getIndex];
        getIndex++;
        return le;
    }

    public void put(char element) {
        if (queue.length - 1 == putIndex) {
            System.out.println("Queue is full.");
            return;
        }
        queue[putIndex] = element;
        putIndex++;//для последующего элемента индекс будет инкрементирован
    }

    public static void main(String[] args) {
        QueueTest queueTest = new QueueTest(3);
        queueTest.put('a');
        queueTest.put('b');
        queueTest.put('c');
        queueTest.put('d');
        System.out.println(queueTest.get());
        System.out.println(queueTest.get());
        System.out.println(queueTest.get());
        System.out.println(queueTest.get());
    }
}