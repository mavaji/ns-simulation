package tclanalyzer.net;

/**
 * @author Vahid Mavaji
 */
public class Link {
    private String id;
    private double numReceivedPackets = 0;
    private double numEnqueuedPackets = 0;
    private double numDequeuesPackets = 0;
    private double numDroppedPackets = 0;


    public Link(String srcNode, String destNode) {
        this.id = srcNode + ":" + destNode;
    }

    public Link(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getNumReceivedPackets() {
        return numReceivedPackets;
    }

    public void setNumReceivedPackets(double numReceivedPackets) {
        this.numReceivedPackets = numReceivedPackets;
    }

    public void addNumReceivedPackets(int x) {
        numReceivedPackets += x;
    }

    public double getNumEnqueuedPackets() {
        return numEnqueuedPackets;
    }

    public void setNumEnqueuedPackets(double numEnqueuedPackets) {
        this.numEnqueuedPackets = numEnqueuedPackets;
    }

    public void addNumEnqueuedPackets(int x) {
        numEnqueuedPackets += x;
    }

    public double getNumDequeuesPackets() {
        return numDequeuesPackets;
    }

    public void setNumDequeuesPackets(double numDequeuesPackets) {
        this.numDequeuesPackets = numDequeuesPackets;
    }

    public void addNumDequeuesPackets(int x) {
        numDequeuesPackets += x;
    }

    public double getNumDroppedPackets() {
        return numDroppedPackets;
    }

    public void setNumDroppedPackets(double numDroppedPackets) {
        this.numDroppedPackets = numDroppedPackets;
    }

    public void addNumDroppedPackets(int x) {
        numDroppedPackets += x;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Link)) {
            return false;
        }
        Link other = (Link) obj;
        return this.id.equals(other.getId());
    }
}
