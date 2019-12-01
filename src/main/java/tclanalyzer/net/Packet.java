package tclanalyzer.net;

import tclanalyzer.event.Event;

/**
 * @author Vahid Mavaji
 */
public class Packet {
    private String id;
    private String seqNumber;
    private String type;
    private String size;

    private Event event;

    public Packet(String id) {
        this.id = id;
    }

    public Packet(String id, String seqNumber, String type, String size, Event event) {
        this.id = id;
        this.seqNumber = seqNumber;
        this.type = type;
        this.size = size;
        this.event = event;
    }

    public String getId() {
        return id;
    }

    public String getSeqNumber() {
        return seqNumber;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public Event getEvent() {
        return event;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Packet)) {
            return false;
        }
        Packet other = (Packet) obj;
        return this.getId().equals(other.getId());
    }
}
