package edu.hw2;

import edu.homeworks.hw2.Task2.Rectangle;
import edu.homeworks.hw2.Task2.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @DisplayName("Check area calculating")
    @ParameterizedTest(name = "width= {0}, height={1}")
    @MethodSource("rectanglesProvider")
    public void areaCalcTest(int width, int height, Rectangle rectangle) {
        double area = rectangle.getArea();
        assertThat(area).isEqualTo(width * height);
    }

    private static Stream<Arguments> rectanglesProvider() {
        return Stream.of(
            Arguments.of(1, 2, new Rectangle(1, 2)),
            Arguments.of(4, 4, new Square(4))
        );
    }
}
