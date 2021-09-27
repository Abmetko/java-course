package ui.junit5;

import com.ui.ContainerHeader;
import com.ui.Tab;
import com.ui.enums.MenuItems;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @see TestInstance.Lifecycle#PER_METHOD - it means that every annotated @test method will have its own
 * instance of test class -> in our case
 * @see ClientsTest
 * The main idea is to make every test method isolated from each other.
 * @see TestInstance.Lifecycle#PER_CLASS - it means that all annotated @test methods will have the same(single)
 * instance of test class.
 *
 *
 * @see ExecutionMode#SAME_THREAD it's alternatively way to make the same as
 * junit-platform.properties --> junit.jupiter.execution.parallel.mode.classes.default=same_thread
 * what means all annotated @test methods in class will be executed sequentially.
 */

@Slf4j
@Execution(ExecutionMode.CONCURRENT)
@ResourceLock("ui.junit5.ClientsTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientsTest extends BaseTest {

    private final ContainerHeader containerHeader = new ContainerHeader();
    private final Tab tab = new Tab();

    /**
     * To demonstrate, how Junit5 use
     *
     * @see TestInstance.Lifecycle#PER_METHOD - we use @BeforeEach annotation
     * before each annotated @test method where it returns hashCode() method of each instance of test class.
     * At the same time, if we use
     * @see TestInstance.Lifecycle#PER_CLASS - all calls of hashCode() method, will return the same result,
     * because we have single object for all annotated @test methods.
     */
    @BeforeEach
    public void beforeEach() {
        System.out.println(this.hashCode());
    }

    @Order(1)
    @Test
    public void openClientsPage() {
        String name = MenuItems.CLIENTS.value;
        containerHeader.selectHeaderMenu(name);
        assertTrue(containerHeader.isMenuItemSelected(name));
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
    @ValueSource(strings = {"Your Dedicated Team", "Web solutions", "Mobile Applications"})
    public void openTab(String tabName) {
        tab.openTab(tabName);
        assertTrue(tab.isTabSelected(tabName));
    }
}