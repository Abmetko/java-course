package wimix.createCheckbox;

import com.codeborne.selenide.Selenide;
import org.apache.commons.compress.archivers.sevenz.CLI;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCheckbox {

    @BeforeAll
    void setUp() {
        addListener(new Clicker());
        Selenide.open("https://smartwebby.com/PHP/Phptips2.asp");
    }

    @Test
    void checkboxesShouldBeChecked() {

        List<Checkbox> checkboxes = $$("input[type='checkbox']")
                .stream()
                .map(Checkbox::new)
                .collect(Collectors.toList());

        checkboxes.get(4).check();

        assertTrue(checkboxes.get(0).isChecked());
        assertTrue(checkboxes.get(1).isChecked());
        assertTrue(checkboxes.get(2).isChecked());
        assertFalse(checkboxes.get(3).isChecked());
        assertTrue(checkboxes.get(4).isChecked());

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
            c.check();
            sleep(500);
            c.check();
            sleep(500);
        });
    }
}