package tclanalyzer.test;

import tclanalyzer.formula.Formula;

/**
 * @author Vahid Mavaji
 */
public class Test {
    public static void main(String[] args) {

        String traceFile = args[0];

        int N = Integer.valueOf(args[1]);
        int B = Integer.valueOf(args[2]);
        double lambda = Double.valueOf(args[3]);
        double mu = Double.valueOf(args[4]);

//        Link srcLink = new Link(args[5], args[6]);
//        Link destLink = new Link(args[7], args[8]);
//        double LF = Double.valueOf(args[9]);
//        int R = Integer.valueOf(args[10]);
        double LF = Double.valueOf(args[5]);
        int R = Integer.valueOf(args[6]);

//        TraceReader reader = new TraceReader(traceFile, srcLink, destLink);
//        reader.build();

        System.out.println("N = " + N);
        System.out.println("B = " + B);
        System.out.println("lambda = " + lambda);
        System.out.println("mu = " + mu);
        System.out.println("LF = " + LF);
        System.out.println("R = " + R);


//        double experimentalDelay = reader.getTotalDelay() / reader.getDestLink().getNumReceivedPackets();
        double formulaDelay = Formula.expectedDelay(N, B, lambda, mu);
        System.out.println();

//        double experimentalPacketLoss = (reader.getSrcLink().getNumEnqueuedPackets()
//                - reader.getDestLink().getNumReceivedPackets())
//                / reader.getSrcLink().getNumEnqueuedPackets();
        double formulaPacketLoss = Formula.expectedPacketLoss(N, B, lambda, mu);
        System.out.println();

        double P_path_failure = Formula.P_path_failure(N, LF);
        double P_existence = Formula.P_existence_of_backup_path(R, P_path_failure);
        //double Survivability = Formula.Survivability(experimentalPacketLoss, experimentalDelay, P_path_failure, P_existence);

        System.out.println("Experimental:");
//        System.out.println("experimentalPacketLoss = " + experimentalPacketLoss);
//        System.out.println("experimentalDelay = " + experimentalDelay);
        //System.out.println("Survivability = " + Survivability);

        //Survivability = Formula.Survivability(formulaPacketLoss, formulaDelay, P_path_failure, P_existence);
        System.out.println("Formula:");
        System.out.println("formulaPacketLoss = " + formulaPacketLoss);
        System.out.println("formulaDelay = " + formulaDelay);
        //System.out.println("Survivability = " + Survivability);
    }
}
