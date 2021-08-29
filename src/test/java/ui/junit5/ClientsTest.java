package ui.junit5;

import com.ui.ContainerHeader;
import com.ui.enums.MenuItems;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@Execution(ExecutionMode.CONCURRENT)
@ResourceLock("ui.junit5.ClientsTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientsTest extends BaseTest {

    private final ContainerHeader containerHeader = new ContainerHeader();

    @Test
    public void openClientsPage() {
        String name = MenuItems.CLIENTS.value;
        containerHeader.selectHeaderMenu(name);
        assertTrue(containerHeader.isMenuItemSelected(name));
        System.out.println("open client page [" + this.getClass().getSimpleName() + "]: " + LocalDateTime.now());
    }

    @Test
    public void openServicePage() {
        String name = MenuItems.SERVICE.value;
        containerHeader.selectHeaderMenu(name);
        assertTrue(containerHeader.isMenuItemSelected(name));
    }
}