package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("RepeatedModelTests")
public interface ModelRepeatedTests {

    @BeforeEach
    default void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(testInfo.getTestClass()
            + "." + testInfo.getTestMethod()
            + " as " + testInfo.getDisplayName()
            + ": " + repetitionInfo.getCurrentRepetition()
            + " of " + repetitionInfo.getTotalRepetitions());
    }
}
