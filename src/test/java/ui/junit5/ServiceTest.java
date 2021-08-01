package ui.junit5;

import com.codeborne.selenide.Selenide;
import com.ui.ContainerHeader;
import com.ui.enums.MenuItems;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.CONCURRENT)
@ResourceLock("ui.junit5.ServiceTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTest extends BaseTest {

    private final ContainerHeader containerHeader = new ContainerHeader();

    @Test
    public void openHomePage() {
        String name = MenuItems.HOME.value;
        containerHeader.selectHeaderMenu(name);
        assertTrue(containerHeader.isMenuItemSelected(name));
    }

    @Test
    public void openContactUsPage() {
        String name = MenuItems.CONTACT_US.value;
        containerHeader.selectHeaderMenu(name);
        assertTrue(containerHeader.isMenuItemSelected(name));
    }

    @AfterEach
    void sleep() {
        Selenide.sleep(1000);
    }
}