package ui.checkbox;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CkeckboxTest extends Runner {

    @BeforeAll
    void setUp() {
        open("https://smartwebby.com/PHP/Phptips2.asp");
    }

    @Order(1)
    @Test
    void testCheckboxes() {
        List<Checkbox> checkboxes = $$("input[type='checkbox']")
                .stream()
                .map(Checkbox::new)
                .collect(Collectors.toList());
        //checkbox implements WebElement

        assertTrue(checkboxes.get(0).isChecked());
        assertTrue(checkboxes.get(1).isChecked());
        assertTrue(checkboxes.get(2).isChecked());
        assertFalse(checkboxes.get(3).isChecked());
        assertFalse(checkboxes.get(4).isChecked());
    }

    @Order(2)
    @Test
    void checkboxShouldBeChecked() {
        Checkbox checkbox = new Checkbox($$("input[type='checkbox']").get(0));
        checkbox.uncheck();
        Assertions.assertFalse(checkbox.isChecked());
    }
}