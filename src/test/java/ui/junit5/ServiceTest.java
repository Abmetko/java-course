package ui.junit5;

import com.ui.ContainerHeader;
import com.ui.enums.MenuItems;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.parallel.ResourceLock;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@ResourceLock("ServiceTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTest extends BaseTest {

    private final ContainerHeader containerHeader = new ContainerHeader();

    @BeforeEach
    public void beforeEach() {
        System.out.println("Service test class: " + threadName);
        System.out.println(this.hashCode());
    }

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
}