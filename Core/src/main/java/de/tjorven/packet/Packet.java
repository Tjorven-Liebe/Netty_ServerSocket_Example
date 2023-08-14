package de.tjorven.packet;

import java.io.Serializable;

public interface Packet extends Serializable {

    /**
     * Will run as default.
     * @see ProcessingHandler
     */
    void run();

}
