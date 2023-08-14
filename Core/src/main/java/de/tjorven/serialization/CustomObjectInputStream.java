package de.tjorven.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

class CustomObjectInputStream extends ObjectInputStream {

    public CustomObjectInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        enableResolveObject(true);
    }

    /**
     * In the serialization process, these Objects will be ignored.
     * If you especially want an object to be serialized, you need to add the interface
     * @see Serializable
     *
     * @param obj object to be substituted
     * @return null if serialization is skipped
     */
    @Override
    protected Object resolveObject(Object obj) {
        if ((obj instanceof Serializable))
            return obj;
        System.out.println("Skipping serialization of " + obj.getClass().getSimpleName());
        return null;
    }
}
