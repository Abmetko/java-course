package others.createCheckbox;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.java_course.configuration.AppConfiguration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.addListener;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCheckbox {

    @BeforeAll
    void setUp() {
        addListener(new Clicker());
        Configuration.browser = AppConfiguration.getString("selenide.browser");
        Selenide.open("https://smartwebby.com/PHP/Phptips2.asp");
    }

    @Test
    void checkboxesShouldBeChecked() {
        List<Checkbox> checkboxes = $$("input[type='checkbox']")
                .stream()
                .map(Checkbox::new)
                .collect(Collectors.toList());

        checkboxes.get(4)
                .when()
                .selectCheckbox()
                .then()
                .checkboxShouldBeSelected()
                .and()
                .unselectCheckbox()
                .then()
                .checkboxShouldBeUnselected();

        System.out.println(checkboxes.get(0).getWrappedElement().getAttribute("value"));
        System.out.println(checkboxes.get(0).getWrappedElement().parent().getText());
    }

    @Test
    void checkboxesShouldBeChecked2() {
        List<Checkbox> checkboxes = $$("input[type='checkbox']")
                .stream()
                .map(Checkbox::new)
                .collect(Collectors.toList());

        checkboxes.stream().forEach(c -> {
            c.selectCheckbox();
            sleep(500);
            c.selectCheckbox();
            sleep(500);
        });
    }
}