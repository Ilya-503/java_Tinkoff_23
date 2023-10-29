package edu.homeworks.hw2.Task3.connectionManager;

public final class ConnectionManagerProvider {

    private final double getFaultyManagerChance;
    private final double connectionFailChance;

    public ConnectionManagerProvider(double getFaultyConnectionChance, double connectionFailChance) {
        checkChance(getFaultyConnectionChance);
        checkChance(connectionFailChance);
        this.getFaultyManagerChance = getFaultyConnectionChance;
        this.connectionFailChance = connectionFailChance;
    }

    public FaultyConnectionManager getFaultyConnection() {
        return new FaultyConnectionManager(connectionFailChance);
    }

    public DefaultConnectionManager getDefaultConnectionManager() {
        return new DefaultConnectionManager(getFaultyManagerChance, connectionFailChance);
    }

    private void checkChance(double chance) throws IllegalArgumentException {
        if (chance < 0 || chance > 1) {
            throw new IllegalArgumentException("Illegal chance value: " + chance);
        }
    }
}
