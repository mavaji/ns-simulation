package tclanalyzer.net;

import java.util.Vector;

/**
 * @author Vahid Mavaji
 */
public class Path {
    private Vector<Link> links = new Vector<Link>();

    public Path() {
    }

    public Path(Vector<Link> links) {
        this.links = links;
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public void removeLink(Link link) {
        links.remove(link);
    }
    /*
     public double getPercentOfLostPackets() {
         double result = 0;

         HashMap<String, Packet> rcvPackets = links.lastElement().getReceivedPackets();
         HashMap<String, Packet> enqPackets = links.firstElement().getEnqueuedPackets();

         result = (double) (enqPackets.size() - rcvPackets.size()) / (double) enqPackets.size();

         return result;
     }

     public double getAverageDelay() {
         double totalDelay = 0;

         HashMap<String, Packet> rcvPackets = links.lastElement().getReceivedPackets();
         HashMap<String, Packet> enqPackets = links.firstElement().getEnqueuedPackets();

         for (Iterator<String> iter = rcvPackets.keySet().iterator(); iter.hasNext();) {

             Packet rcvPacket = rcvPackets.get(iter.next());
             double rcvTime = Double.valueOf(rcvPacket.getEvent().getTime()).doubleValue();

             Packet enqPacket = enqPackets.get(rcvPacket.getId());
             if (enqPacket != null) {
                 double enqTime = Double.valueOf(enqPacket.getEvent().getTime()).doubleValue();
                 totalDelay += (rcvTime - enqTime);
             }
         }

         return totalDelay / rcvPackets.size();
     }  */
}


