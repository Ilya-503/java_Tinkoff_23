package edu.hw2;

import edu.homeworks.hw2.Task3.connection.Connection;
import edu.homeworks.hw2.Task3.connection.FaultyConnection;
import edu.homeworks.hw2.Task3.connection.StableConnection;
import edu.homeworks.hw2.Task3.connectionManager.DefaultConnectionManager;
import edu.homeworks.hw2.Task3.connectionManager.FaultyConnectionManager;
import edu.homeworks.hw2.Task3.exceptions.ConnectionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class Task3Test {

    @DisplayName("Check Faulty connection throwing")
    @ParameterizedTest(name = "fail chance = {0}")
    @CsvSource({
        "0, 0",
        "1, 10"
    })
    public void test(double failChance, int expectedFailedConnections) {
        var faultyConnection = new FaultyConnection(failChance);
        int failedConnections = 0;

        for (int i = 0; i < 10; i++) {
            try {
                faultyConnection.execute("command");
            } catch (ConnectionException e) {
                failedConnections++;
            }
        }
        assertThat(failedConnections).isEqualTo(expectedFailedConnections);
    }

    @DisplayName("Check faulty connection manager")
    @RepeatedTest(5)
    public void faultyConnectionManagerTest() {
        var manager = new FaultyConnectionManager(1);
        var connection = manager.getConnection();

        assertThat(connection).isInstanceOf(FaultyConnection.class);
        assertThatExceptionOfType(ConnectionException.class)
            .isThrownBy(() -> connection.execute("command"));
    }

    @DisplayName("Check default connection manager")
    @ParameterizedTest(name = "faulty connection chance = {0}")
    @MethodSource("defaultManagerArgsProvider")
    public void defaultConnectionManagerTest
        (double getFaultyConnectionChance, Class<Connection> connectionType) {

        var manager = new DefaultConnectionManager(getFaultyConnectionChance, 1);
        for (int i = 0; i < 5; i++) {
            var connection = manager.getConnection();
            assertThat(connection).isInstanceOf(connectionType);
        }
    }

    private static Stream<Arguments> defaultManagerArgsProvider() {
        return Stream.of(
            Arguments.of(0, StableConnection.class),
            Arguments.of(1, FaultyConnection.class)
        );
    }
}
