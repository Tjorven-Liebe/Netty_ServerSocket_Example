package de.tjorven.packet.packets;

import de.tjorven.packet.Packet;

/**
 * This is how a packet could look like. But I'm not completely sure about the
 * structure of a packet yet.
 * @see AnotherPacket
 * @see Packet
 *
 * @param <T> a generic Type for a better usage
 */
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
