package de.tjorven.serialization;

import de.tjorven.packet.Packet;

import java.io.*;
import java.util.Base64;

public class PacketSerializer {

    private PacketSerializer() {}

    /**
     * Conversion of a Packet into a Base64 string
     * @see CustomObjectOutputStream CustomObjectOutputStream - if you miss objects before sending a Packet through the pipeline
     *
     * @param packet the packet to convert
     * @return The Base64 value
     * @throws IOException if an I/O error occurs while writing stream header
     */
    public static String packetToBase64(Packet packet) throws IOException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        CustomObjectOutputStream stream = new CustomObjectOutputStream(arrayOutputStream);
        stream.writeObject(packet);
        stream.close();
        arrayOutputStream.close();
        return Base64.getEncoder().encodeToString(arrayOutputStream.toByteArray());
    }


    /**
     * Conversion of a Packet into a Base64 string
     * @see CustomObjectInputStream CustomObjectOutputStream - if you miss objects after sending a Packet through the pipeline
     *
     * @param base64 the string to convert
     * @return The Packet value
     * @throws IOException if an I/O error occurs while writing stream header
     */
    public static Packet base64ToPacket(String base64) throws IOException, ClassNotFoundException {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(base64));
        CustomObjectInputStream stream = new CustomObjectInputStream(arrayInputStream);
        Object object = stream.readObject();
        if (!(object instanceof Packet packet))
            return null;
        stream.close();
        arrayInputStream.close();
        return packet;
    }
}

