package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.intellij.lang.annotations.RegExp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Task2Test {

    @DisplayName("Check area constancy")
    @ParameterizedTest()
    @MethodSource("legalRectanglesProvider")
    public void savingAreaTest(Rectangle rectangle) {
        double area = rectangle.getArea();
        rectangle
            .setWidth(10)
            .setHeight(11);
        double newArea = rectangle.getArea();

        assertThat(newArea).isEqualTo(area);
    }

    private static Stream<Arguments> legalRectanglesProvider() {
        return Stream.of(
            Arguments.of(new Rectangle(10, 10)),
            Arguments.of(new Square(0.43))
        );
    }


    @DisplayName("Check are after setting sides")
    @ParameterizedTest(name = "width= {0}, height= {1}")
    @CsvSource({
        "10, 12",
        "2, 0.54"
    })
    public void settingSidesTest(double width, double height) {
        var rectangle = new Rectangle(1, 2);
        var square = new Square(10);
        double expectedArea = width * height;


        double newRectArea = rectangle
            .setWidth(width)
            .setHeight(height)
            .getArea();

        double newSqArea = square
            .setHeight(height)
            .setWidth(width)
            .getArea();

        assertAll(
            () -> assertThat(newRectArea).isEqualTo(expectedArea),
            () -> assertThat(newSqArea).isEqualTo(expectedArea)
        );
    }

    @DisplayName("Check setting illegal sides")
    @ParameterizedTest(name = "width= {0}, height= {1}")
    @CsvSource({
        "10, -0.4",
        "0, 0",
        "-0.5, 1"
    })
    public void illegalSidesTest(double width, double height) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            var sq = new Square(1);
            sq
                .setWidth(width)
                .setHeight(height);
        }).withMessageEndingWith("must be positive");
    }
}
