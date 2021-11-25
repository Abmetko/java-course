package ui.junit5;

import com.ui.ContainerHeader;
import com.ui.Tab;
import com.ui.enums.MenuItems;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Two types of running test methods:
 * <pre>{@code
 *     @TestInstance(TestInstance.Lifecycle.PER_METHOD)
 * }</pre>
 * it means that every annotated @Test method will have its own
 * instance of test class, in our case it's {@link ClientsTest} class.
 * The main idea is to make every test method isolated from each other.
 * <pre>{@code
 *     @TestInstance(TestInstance.Lifecycle.PER_CLASS)
 * }</pre>
 * it means that all annotated @Test methods will have the same(single) instance of test class.
 * <pre>{@code
 *     @Execution(ExecutionMode.SAME_THREAD)
 * }</pre>
 * it's alternatively way to make the same as junit-platform.properties, with property
 * junit.jupiter.execution.parallel.mode.classes.default=same_thread
 * what means all annotated @Test methods in class will be executed sequentially.
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS) //just to demonstrate the annotation here
@ResourceLock("ClientsTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientsTest extends BaseTest {

    private final ContainerHeader containerHeader = new ContainerHeader();
    private final Tab tab = new Tab();

    /**
     * To demonstrate, how Junit5 use
     * {@link TestInstance.Lifecycle#PER_METHOD} - we use @BeforeEach annotation
     * before each annotated @Test method where it returns hashCode() method of each instance of test class.
     * At the same time, if we use
     * {@link TestInstance.Lifecycle#PER_CLASS} - all calls of hashCode() method, will return the same result,
     * because we have single object for all annotated @Test methods.
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

    @Disabled
    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"Your Dedicated Team", "Web solutions", "Mobile Applications"})
    public void openTab(String tabName) {
        tab.openTab(tabName);
        assertTrue(tab.isTabSelected(tabName));
    }
}