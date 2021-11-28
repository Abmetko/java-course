package others;

import java.util.stream.Stream;

public class TestClass1 {

    public static void main(String[] args) {
        System.out.println(Stream.of("F","1","3","78","e","9").filter(i -> !i.equals("F") & !i.equals("e")).count());
    }
}
