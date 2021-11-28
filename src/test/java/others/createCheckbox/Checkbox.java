package others.createCheckbox;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WrapsElement;

public class Checkbox implements WrapsElement {

    private final SelenideElement element;

    public Checkbox(SelenideElement element) {
        this.element = element;
    }

    public Checkbox selectCheckbox() {
        element.click();
        return this;
    }

    public Checkbox unselectCheckbox() {
        element.click();
        return this;
    }

    public Checkbox checkboxShouldBeSelected() {
        element.shouldBe(Condition.checked);
        return this;
    }

    public Checkbox checkboxShouldBeUnselected() {
        element.shouldNotBe(Condition.checked);
        return this;
    }

    @Override
    public SelenideElement getWrappedElement() {
        return element;
    }

    public Checkbox when(){
        return this;
    }

    public Checkbox then(){
        return this;
    }

    public Checkbox and(){
        return this;
    }
}