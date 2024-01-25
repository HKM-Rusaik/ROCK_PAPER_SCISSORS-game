package org.rusaik.gesturegames.engine;

public class Gesture {
    private final String name;

    public Gesture(String gesture) {
        this.name = gesture.toUpperCase();
    }
    public String getName() {
        return this.name;
    }
}
