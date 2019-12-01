package tclanalyzer.reader;

import tclanalyzer.event.Event;
import tclanalyzer.net.Link;
import tclanalyzer.net.Packet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author Vahid Mavaji
 */
public class TraceReader {
    private String traceFileName;
    private Link srcLink;
    private Link destLink;
    private double totalDelay = 0;

    public TraceReader(String traceFileName, Link srcLink, Link destLink) {
        this.traceFileName = traceFileName;
        this.srcLink = srcLink;
        this.destLink = destLink;
    }

    public Link getSrcLink() {
        return srcLink;
    }

    public Link getDestLink() {
        return destLink;
    }

    public double getTotalDelay() {
        return totalDelay;
    }

    public void build() {
        HashMap<String, Packet> tmpPackets = new HashMap<String, Packet>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(traceFileName)));

            StringTokenizer tokenizer;
            String type;
            String time;
            String src;
            String dest;
            String pktType;
            String pktSize;
            String flags;
            String fid;
            String srcAdd;
            String destAdd;
            String seqNum;
            String pktId;

            while (reader.ready()) {
                tokenizer = new StringTokenizer(reader.readLine());

                type = tokenizer.nextToken();
                time = tokenizer.nextToken();
                src = tokenizer.nextToken();
                dest = tokenizer.nextToken();
                pktType = tokenizer.nextToken();
                pktSize = tokenizer.nextToken();
                flags = tokenizer.nextToken();
                fid = tokenizer.nextToken();
                srcAdd = tokenizer.nextToken();
                destAdd = tokenizer.nextToken();
                seqNum = tokenizer.nextToken();
                pktId = tokenizer.nextToken();

                Link link = new Link(src, dest);
                if (!(link.equals(srcLink) || link.equals(destLink))) continue;

                Event event = new Event(type, time, flags, fid, srcAdd, destAdd);
                Packet packet = new Packet(pktId, seqNum, pktType, pktSize, event);

                if (link.equals(srcLink) && type.equals("+")) {
                    tmpPackets.put(packet.getId(), packet);
                    link = srcLink;
                } else if (link.equals(destLink) && type.equals("r")) {
                    double rcvTime = Double.valueOf(time);
                    Packet srcPkt = tmpPackets.remove(packet.getId());
                    double enqTime = Double.valueOf(srcPkt.getEvent().getTime());
                    totalDelay += (rcvTime - enqTime);
                    link = destLink;
                }

                if (type.equals("r")) {
                    link.addNumReceivedPackets(1);

                } else if (type.equals("+")) {
                    link.addNumEnqueuedPackets(1);

                } else if (type.equals("-")) {
                    link.addNumDequeuesPackets(1);

                } else if (type.equals("d")) {
                    link.addNumDroppedPackets(1);

                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
