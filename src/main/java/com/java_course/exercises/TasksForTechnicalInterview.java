package com.java_course.exercises;

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
    }
}
@FunctionalInterface
interface Executor {
    void execute(int[] args);
}