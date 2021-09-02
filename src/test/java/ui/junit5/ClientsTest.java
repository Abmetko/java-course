package ui.junit5;

import com.ui.ContainerHeader;
import com.ui.Tab;
import com.ui.enums.MenuItems;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@Execution(ExecutionMode.CONCURRENT)
@ResourceLock("ui.junit5.ClientsTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientsTest extends BaseTest {

    private final ContainerHeader containerHeader = new ContainerHeader();
    private final Tab tab = new Tab();

    @Order(1)
    @Test
    public void openClientsPage() {
        String name = MenuItems.CLIENTS.value;
        containerHeader.selectHeaderMenu(name);
        assertTrue(containerHeader.isMenuItemSelected(name));
        System.out.println("open client page [" + this.getClass().getSimpleName() + "]: " + LocalDateTime.now());
    }

    @Order(2)
    @Test
    public void openServicePage() {
        String name = MenuItems.SERVICE.value;
        containerHeader.selectHeaderMenu(name);
        assertTrue(containerHeader.isMenuItemSelected(name));
    }

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = { "Your Dedicated Team", "Web solutions", "Mobile Applications" })
    public void openTab(String tabName) {
        tab.openTab(tabName);
        assertTrue(tab.isTabSelected(tabName));
    }
}