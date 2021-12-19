package ui.checkbox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

public class Checkbox implements WrapsElement {

    private final SelenideElement checkbox;

    public Checkbox(SelenideElement element) {
        this.checkbox = element;
    }

    public void toggle() {
        checkbox
                .click();
    }

    public boolean isChecked() {
        return checkbox
                .is(Condition.checked);
    }

    public void check() {
        if (!isChecked()) {
            toggle();
        }
    }

    public void uncheck() {
        if (isChecked()) {
            toggle();
        }
    }

    @Override
    public WebElement getWrappedElement() {
        return checkbox;
    }
}