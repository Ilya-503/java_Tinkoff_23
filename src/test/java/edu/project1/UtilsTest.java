package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static edu.project1.Utils.parseWordByChars;
import static edu.project1.Utils.isMatchingRegex;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class UtilsTest {

    @DisplayName("Test parsing word by chars")
    @ParameterizedTest(name = "word = {0}")
    @MethodSource("wordsToParseProvider")
    public void wordParsingByCharsTest(String word, Map<Character, ArrayList<Integer>> expectedResult) {
        var result = parseWordByChars(word);
        assertThat(result).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> wordsToParseProvider() {
        return Stream.of(
            Arguments.of("java",
                Map.of(
                    'j', List.of(0),
                    'a', List.of(1, 3),
                    'v', List.of(2))
            ),
            Arguments.of("VK",
                Map.of(
                    'V', List.of(0),
                    'K', List.of(1)
                )
            ),
            Arguments.of("", new HashMap<>())
        );
    }

    @DisplayName("Check regex matching")
    @ParameterizedTest(name = "leg= {0}, illeg= {1}, reg= {2}")
    @MethodSource("matchingWordsProvider")
    public void regexMatchingTest(String legalWord, String illegalWord, String reg) {
        boolean isLegalWordMatching = isMatchingRegex(legalWord, reg);
        boolean isIllegalWordMatching = isMatchingRegex(illegalWord, reg);

        assertAll(
            () -> assertThat(isLegalWordMatching).isTrue(),
            () -> assertThat(isIllegalWordMatching).isFalse()
        );
    }

    private static Stream<Arguments> matchingWordsProvider() {
        return Stream.of(
            Arguments.of("alex", "ale x", "^[a-zA-Z]+$"),
            Arguments.of("normal_login-123", "ImCOOL", "^[a-z0-9_-]{3,16}$"),
            Arguments.of("  ", "", "^[\\s]+$")
        );
    }
}
