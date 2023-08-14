package de.tjorven.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

class CustomObjectOutputStream extends ObjectOutputStream {

    public CustomObjectOutputStream(OutputStream outputStream) throws IOException {
        super(outputStream);
        enableReplaceObject(true);
    }

    /**
     * In the serialization process, these Objects will be ignored.
     * If you especially want an object to be serialized, you need to add the interface
     * @see Serializable
     *
     * @param obj object to be replaced
     * @return null if serialization is skipped
     */
    @Override
    protected Object replaceObject(Object obj) throws IOException {
        if ((obj instanceof Serializable))
            return obj;
        System.out.println("Skipping serialization of " + obj.getClass().getSimpleName());
        return null;
    }
}
