package ui.checkbox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

public class Checkbox implements WrapsElement {

    private final SelenideElement ELEMENT;

    public Checkbox(SelenideElement element) {
        this.ELEMENT = element;
    }

    public void toggle() {
        ELEMENT.click();
    }

    public boolean isChecked() {
        return ELEMENT.is(Condition.checked);
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
        return ELEMENT;
    }
}