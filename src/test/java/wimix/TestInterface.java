package wimix;

import java.util.Locale;

public class TestInterface {

    public static void main(String[] args) {
        InterfaceTest interfaceTest = (a) -> System.out.println(a);

        interfaceTest.test("Hello world!");

        String var = "adb";
        System.out.println(var.toUpperCase(Locale.ROOT));
    }
}
