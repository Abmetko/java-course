package com.java_course.regularExpression;

public class TestRegularExpression {

    private static final String ORDER_NUMBER = "Order #8674423";

    private static final String CURRENT_PRICE_1 = "current balance 100,51$";
    private static final String CURRENT_PRICE_2 = "current balance 100.51$";

    private static final String TEST = "Waived by John Doe 03/04/2021, 2:27:23 PM Europe/Warsaw\nReason: test";

    //заменяем все кроме цифр на ""
    public static String getOnlyDigits() {
        return ORDER_NUMBER
                .replaceAll("[^\\d]", "");
    }

    public static String getOnlyDigitsAndDotComma(String value) {
        return value
                .replaceAll("[^\\d.,]", "");
    }

    //заменяем все цифры на ""
    public static String removeDigitsFromValue(String value) {
        return value
                .replaceAll("\\d", "");
    }

    public static void main(String[] args) {
        System.out.println(TEST.split("Waived by ")[1].split("\nReason")[0]);

        System.out.println(getOnlyDigits());
        System.out.println(getOnlyDigitsAndDotComma(CURRENT_PRICE_1));
        System.out.println(getOnlyDigitsAndDotComma(CURRENT_PRICE_2));
        System.out.println(removeDigitsFromValue(ORDER_NUMBER));
    }
}