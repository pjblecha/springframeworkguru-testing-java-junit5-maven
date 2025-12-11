package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("Models")
public interface ModelTests {

    @BeforeAll
    default void beforeAll() {
        System.out.println("** Interface Calls BeforeAll **");
    }

    @BeforeEach
    default void beforeEach(TestInfo testInfo) {
        System.out.println("Running Test: " + testInfo.getDisplayName() + ": ");
    }

}
