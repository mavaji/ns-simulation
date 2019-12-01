package tclanalyzer.test;

import tclanalyzer.formula.Formula;

/**
 * @author Vahid Mavaji
 */
public class Test1 {
    public static void main(String[] args) {
        double PL = Double.valueOf(args[0]);
        double Delay = Double.valueOf(args[1]);
        int N = Integer.valueOf(args[2]);
        double LF = Double.valueOf(args[3]);
        int R = Integer.valueOf(args[4]);
        double T = Double.valueOf(args[5]);
        double T1 = Double.valueOf(args[6]);

        double P_path_failure = Formula.P_path_failure(N, LF);
        double P_existence = Formula.P_existence_of_backup_path(R, P_path_failure);

        double Survivability = Formula.Survivability(PL, Delay, P_path_failure, P_existence, T, T1);

        System.out.println("PL = " + PL);
        System.out.println("Delay = " + Delay);
        System.out.println("N = " + N);
        System.out.println("LF = " + LF);
        System.out.println("R = " + R);
        System.out.println("P_path_failure = " + P_path_failure);
        System.out.println("P_existence = " + P_existence);
        System.out.println("Survivability = " + Survivability);
    }
}
