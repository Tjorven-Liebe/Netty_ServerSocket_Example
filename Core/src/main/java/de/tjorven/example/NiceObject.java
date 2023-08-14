package de.tjorven.example;

import java.io.Serializable;

/**
 * Example object for showcase
 */
public class NiceObject implements Serializable {

    private final String test;
    private final int integer;

    public NiceObject(String test, int integer) {
        this.test = test;
        this.integer = integer;
    }

    public int getInteger() {
        return integer;
    }

    public String getTest() {
        return test;
    }

    @Override
    public String toString() {
        return "TollesObject{" +
                "test='" + test + '\'' +
                ", integer=" + integer +
                '}';
    }
}
