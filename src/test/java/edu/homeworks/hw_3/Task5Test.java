package edu.homeworks.hw_3;

import edu.homeworks.hw_3.Task5.Contact;
import edu.homeworks.hw_3.Task5.SortDirection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static edu.homeworks.hw_3.Task5.SortDirection.ASC;
import static edu.homeworks.hw_3.Task5.SortDirection.DESC;
import static edu.homeworks.hw_3.Task5.Task5.parseContacts;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class Task5Test {

    @DisplayName("Check contacts parsing")
    @ParameterizedTest()
    @MethodSource("legalContactsParsingArgsProvider")
    public void parseContactsTest(String[] names, SortDirection direction, Contact[] expectedContacts) {
        var contacts = parseContacts(names, direction);

        assertThat(contacts).isEqualTo(expectedContacts);
    }

    private static Stream<Arguments> legalContactsParsingArgsProvider() {
        return Stream.of(
          Arguments.of(
              new String[] {"John Locke", "Thomas Aquinas", "David Hume"}, ASC,
              new Contact[] {
                  new Contact("Thomas", "Aquinas"),
                  new Contact("David", "Hume"),
                  new Contact("John", "Locke")}
              ),
            Arguments.of(
                new String[] {"David", "Davidus", "david Blake"}, ASC,
                new Contact[] {
                    new Contact("david", "Blake"),
                    new Contact("David", ""),
                    new Contact("Davidus", "")}
             ),
            Arguments.of(
                new String[] {"AnnE Zuzu", "THOMAS", "zak"}, DESC,
                new Contact[] {
                    new Contact("AnnE", "Zuzu"),
                    new Contact("zak", ""),
                    new Contact("THOMAS", "")}
            ),
            Arguments.of(null, ASC, new Contact[0]),
            Arguments.of(new String[0], DESC, new Contact[0])
            );
    }

    @DisplayName("Check illegal contacts parsing")
    @ParameterizedTest()
    @MethodSource("illegalContactsParsingArgsProvider")
    public void illegalParseContactsTest(String[] names) {
        assertThatIllegalArgumentException().isThrownBy(
            () -> parseContacts(names, DESC)
        );
    }

    private static Stream<Arguments> illegalContactsParsingArgsProvider() {
        return Stream.of(
            Arguments.of((Object) new String[] {"Josha_12"}),
            Arguments.of((Object) new String[] {"   "}),
            Arguments.of((Object) new String[] {"anne 09"})
        );
    }

}
