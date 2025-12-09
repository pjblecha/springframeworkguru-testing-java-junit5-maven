package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l, "Joe", "Buck");
        owner.setCity("Saint Louis");
        owner.setTelephone("3145778181");

        assertAll("Properties Test",
            () -> assertAll("Person Properties",
                () -> assertEquals("Joe", owner.getFirstName(), "First Name Did Not Match"),
                () -> assertEquals("Buck", owner.getLastName(), "Last Name Did Not Match")),
            () -> assertAll("Owner Properties",
                () -> assertEquals("Saint Louis", owner.getCity(), "City Did Not Match"),
                () -> assertEquals("3145778181", owner.getTelephone(), "Telephone Did Not Match")
            ));
    }

}