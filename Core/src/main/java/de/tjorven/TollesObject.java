package de.tjorven;

import java.io.Serializable;

public class TollesObject implements Serializable {

    private final String test;
    private final int integer;

    public TollesObject(String test, int integer) {
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
