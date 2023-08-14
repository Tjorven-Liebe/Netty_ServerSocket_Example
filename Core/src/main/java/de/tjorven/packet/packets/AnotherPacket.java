package de.tjorven.packet.packets;

import de.tjorven.packet.Packet;

import java.io.Serializable;

/**
 * You can of course use packets also
 * @see DefaultPacket
 * @see Packet
 *
 * @param another an example parameter
 * @param string ..
 */
public record AnotherPacket(String another, String string) implements Packet, Serializable {

    @Override
    public String toString() {
        return "AnotherPacket{" +
                "another='" + another + '\'' +
                ", string='" + string + '\'' +
                '}';
    }

    @Override
    public void run() {

    }
}
