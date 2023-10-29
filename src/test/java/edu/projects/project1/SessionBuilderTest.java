package edu.projects.project1;

import edu.projects.project1.session.SessionBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class SessionBuilderTest {

    @DisplayName("Check Game run witl illegal input")
    @ParameterizedTest(name = "word= {0}, maxMistakes= {1}")
    @CsvSource({
        ", 100",
        ", 100",
        "a, 100",
        "AGAIN, 100",
        "pop_p, 100",
        "Pip p, 100",
        "java, 0",
        "java, -1",
        "java, 23",
    })
    public void illegalInputGameRunnerTest(String word, int maxMistakes) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            SessionBuilder.getNewSession(word, maxMistakes)
        );
    }
}
