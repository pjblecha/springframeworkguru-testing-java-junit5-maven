package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {

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

        assertThat(owner.getCity(), is("Saint Louis"));
    }

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentSetNameOrArgumentsWithNames}")
    @ValueSource(strings = {"Spring", "FrameWork", "Guru"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentSetNameOrArgumentsWithNames}")
    @EnumSource(OwnerType.class)
    void testValueSource(OwnerType val) {
        System.out.println(val);
    }

    @DisplayName("CSV Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentSetNameOrArgumentsWithNames}")
    @CsvSource({"FL, 1, 1", "OH, 2, 2", "MI, 3, 3"})
    void csvInputTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    @DisplayName("CSV Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentSetNameOrArgumentsWithNames}")
    @CsvFileSource(resources = "/inputdata.csv", numLinesToSkip = 1)
    void csvInputFileTest(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    @DisplayName("Method Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentSetNameOrArgumentsWithNames}")
    @MethodSource("getArgs")
    void testMethodValue(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }

    @DisplayName("Custom Provider Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentSetNameOrArgumentsWithNames}")
    @ArgumentsSource(CustomArgsProvider.class)
    void testCustomMethodValue(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + ":" + val2);
    }


    static Stream<Arguments> getArgs() {
        return Stream.of(
            Arguments.of("FL", 1, 1),
            Arguments.of("OH", 2, 2),
            Arguments.of("MI", 3, 3));
    }

}