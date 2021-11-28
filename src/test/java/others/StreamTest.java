package others;

import java.util.Arrays;
import java.util.List;

public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(list.stream().filter(i -> i.equals(5)).count() == 1);

        System.out.println(list.stream().filter(i -> i.equals(5)).reduce((u, v) -> {
            throw new IllegalStateException();
        }));
    }
}