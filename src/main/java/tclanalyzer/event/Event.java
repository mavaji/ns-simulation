package tclanalyzer.event;

/**
 * @author Vahid Mavaji
 */
public class Event {
    private String type;
    private String time;
    private String flags;
    private String fid;
    private String srcAddress;
    private String destAddress;

    public Event(String type, String time, String flags, String fid, String srcAddress, String destAddress) {
        this.type = type;
        this.time = time;
        this.flags = flags;
        this.fid = fid;
        this.srcAddress = srcAddress;
        this.destAddress = destAddress;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
    }

    public String getFlags() {
        return flags;
    }

    public String getFid() {
        return fid;
    }

    public String getSrcAddress() {
        return srcAddress;
    }

    public String getDestAddress() {
        return destAddress;
    }
}
