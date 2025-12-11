package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTests {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    void index() {
        assertEquals("index", indexController.index());
    }

    @Test
    void oopsHandler() {
        assertThrows(CustomExceptionThrowingException.class, () -> {
            indexController.oopsHandler();
        });
    }

    @Disabled("Testing timeout")
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("Arrived at testTimeout");
        });
    }

    @Disabled("Testing timeout")
    @Test
    void testTimeoutPreempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("Arrived at testTimeoutPreempt");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueWorks() {
        assumeTrue("GURU".equalsIgnoreCase("Guru"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
        System.out.println("MAC OS");
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
        System.out.println("WINDOWS 11");
    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "Paul")
    @Test
    void testIfUserPJB() {
        System.out.println("User is " + System.getProperty("user.name"));
    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "derf")
    @Test
    void testIfUserDerf() {
        System.out.println("User is " + System.getProperty("user.name"));
    }

}