package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeatedTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonRepeatedTest implements ModelRepeatedTests {


    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} of {totalRepetitions}")
    @DisplayName("A Repeated Kinda Test")
    void myRepeatedTest() {
        //todo - impl
        assertTrue(1 == 1);
    }

    @RepeatedTest(value = 5, name = "{displayName} : {currentRepetition}")
    @DisplayName("Repeated Test With Way Too Much Information Attached... ")
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
    }
}
