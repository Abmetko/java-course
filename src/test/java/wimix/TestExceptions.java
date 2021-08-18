package wimix;

public class TestExceptions {

    static int[] array = {1, 2, 3, 4, 5};

    public static void main(String[] args) throws NullPointerException {
        try {
            array[5] = 4;
        } catch (Exception e) {
            System.out.println("Expected behaviour");
            e.printStackTrace();
        } finally {
            System.out.println("FINAL");
        }
    }
}