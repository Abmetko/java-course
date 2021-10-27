package wimix.createCheckbox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WrapsElement;

public class Checkbox implements WrapsElement {

    private final SelenideElement element;

    public Checkbox(SelenideElement element) {
        this.element = element;
    }

    public void check() {
        if (!isChecked()) {
            element.click();
        }
    }

    public boolean isChecked() {
        return element.is(Condition.checked);
    }

    @Override
    public SelenideElement getWrappedElement() {
        return element;
    }
}