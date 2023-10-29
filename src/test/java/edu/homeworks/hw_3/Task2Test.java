package edu.homeworks.hw_3;

import edu.homeworks.hw_3.Task2.UnbalancedClusterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import java.util.stream.Stream;
import static edu.homeworks.hw_3.Task2.Task2.clusterize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class Task2Test {

    @DisplayName("Check legal clusterize")
    @ParameterizedTest(name = "str = {0}")
    @MethodSource("clusterizeLegalArgsProvider")
    public void clusterizeTest(String sequence, List<String> expectedClusters) {
        var clusters = clusterize(sequence);

        assertThat(clusters).isEqualTo(expectedClusters);
    }

    private static Stream<Arguments> clusterizeLegalArgsProvider() {
        return Stream.of(
            Arguments.of("()()()", List.of("()", "()", "()")),
            Arguments.of("((()))(())()()(()())", List.of("((()))", "(())", "()", "()", "(()())")),
            Arguments.of("", List.of())
        );
    }

    @DisplayName("Check illegal clusterize")
    @ParameterizedTest(name = "str = {0}")
    @ValueSource(strings = {"()()(()", ")()()", "()))))"})
    public void illegalClusterizeTest(String sequence) {
        assertThatExceptionOfType(UnbalancedClusterException.class)
            .isThrownBy(() -> clusterize(sequence));
    }

}
