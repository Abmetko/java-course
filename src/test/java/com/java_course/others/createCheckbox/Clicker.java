package com.java_course.others.createCheckbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class Clicker extends AbstractWebDriverEventListener {

    // $x(".//..//..") is the same as .parent().parent()

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        handlePopup();
    }

    public void handlePopup() {
        System.out.println("click");
    }
}