package wimix.createCheckbox;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCheckbox {

    @BeforeAll
    void setUp() {
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
}