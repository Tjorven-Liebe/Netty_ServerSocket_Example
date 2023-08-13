package de.tjorven.packet;

public class DefaultPacket<T> implements Packet {

    private final T type;
    private final String string;

    public DefaultPacket(String string, T type) {
        this.string = string;
        this.type = type;
    }

    @Override
    public void run() {
        System.out.println(getString() + ":" + getType());
    }

    public String getString() {
        return string;
    }

    public T getType() {
        return type;
    }

    @Override
    public String toString() {
        return "DefaultPacket{" +
                "type=" + type +
                ", string='" + string + '\'' +
                '}';
    }
}
