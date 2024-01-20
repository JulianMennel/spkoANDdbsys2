package de.htwg;

public class Uhrzeit extends Timeinterval {
    private String uhrzeit;

    public Uhrzeit(String uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

    public String getUhrzeit() {
        return this.uhrzeit;
    }

    @Override
    public String toString() {
        return this.uhrzeit;
    }
}
