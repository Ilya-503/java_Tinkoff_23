package edu.project1;

import edu.project1.Game.Game;
import edu.project1.Game.status.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static edu.project1.Game.status.GameStatus.DEFEAT;
import static edu.project1.Game.status.GameStatus.PLAYING;
import static edu.project1.Game.status.GameStatus.WIN;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Nested
    @DisplayName("Check finished game status")
    class GameStatusGuess {

        @DisplayName("Check game status when not final guess")
        @ParameterizedTest(name = "word= {0}")
        @MethodSource("playingGameArgsProvider")
        public void playingGameStatusTest(String word, List<Character> letters) {
            Game game = new Game(word, 3);

            for (char letter: letters) {
                game.tryGuess(letter);
                var gameStatus = game.getGameStatus();
                assertThat(game.getGameStatus()).isEqualTo(PLAYING);
            }
        }

        private static Stream<Arguments> playingGameArgsProvider() {
            return Stream.of(
              Arguments.of("java", List.of('a', 'v', 'k')),
              Arguments.of("ab", List.of('a', 't'))
            );
        }

        @DisplayName("Check finished game status")
        @ParameterizedTest(name = "word= {0}")
        @MethodSource("finishedGameArgsProvider")
        public void winGameStatusTest(String word, List<Character> letters, GameStatus status) {
            Game game = new Game(word, 1);

            for (char letter: letters) {
                game.tryGuess(letter);
                var gameStatus = game.getGameStatus();
            }
            assertThat(game.getGameStatus()).isEqualTo(status);
        }

        private static Stream<Arguments> finishedGameArgsProvider() {
            return Stream.of(
                Arguments.of("java", List.of('a', 'b'), DEFEAT),
                Arguments.of("ab", List.of('k'), DEFEAT),
                Arguments.of("pop", List.of('p', 'o'), WIN)
            );
        }
    }


}
