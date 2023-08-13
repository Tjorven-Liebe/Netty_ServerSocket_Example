package de.tjorven.serialization;

import de.tjorven.packet.Packet;
import io.netty.handler.codec.base64.Base64Encoder;

import java.io.*;
import java.util.Base64;

public class PacketSerializer {

    private PacketSerializer() {}

    public static String packetToBase64(Packet packet) throws IOException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        CustomObjectOutputStream stream = new CustomObjectOutputStream(arrayOutputStream);
        stream.writeObject(packet);
        stream.close();
        arrayOutputStream.close();
        return Base64.getEncoder().encodeToString(arrayOutputStream.toByteArray());
    }

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

class CustomObjectOutputStream extends ObjectOutputStream {
    public CustomObjectOutputStream(OutputStream outputStream) throws IOException {
        super(outputStream);
        enableReplaceObject(true);
    }

    @Override
    protected Object replaceObject(Object obj) throws IOException {
        if ((obj instanceof Serializable))
            return obj;
        System.out.println("Skipping serialization of " + obj.getClass().getSimpleName());
        return null;
    }
}

class CustomObjectInputStream extends ObjectInputStream {

    public CustomObjectInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        enableResolveObject(true);
    }

    @Override
    protected Object resolveObject(Object obj) throws IOException {
        if ((obj instanceof Serializable))
            return obj;
        System.out.println("Skipping serialization of " + obj.getClass().getSimpleName());
        return null;
    }
}
