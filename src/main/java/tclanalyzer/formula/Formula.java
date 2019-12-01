package tclanalyzer.formula;

/**
 * @author Vahid Mavaji
 */
public class Formula {
    public static double expectedDelay(int N, int B, double lambda, double mu) {
        double delay = 0;

        double l = lambda;
        for (int i = 1; i <= N; i++) {

            double L = L(B, lambda, mu);

            double P = P(B, lambda, mu);

            double W = W(B, L, P, mu);

            delay += W;

            l *= ((1 - P));
        }

        return delay;
    }

    public static double expectedPacketLoss(int N, int B, double lambda, double mu) {
        double PL = 1;

        double l = lambda;
        for (int i = 1; i <= N; i++) {
            double p = P(B, l, mu);
            PL *= (1 - p);

            l *= (1 - p) / mu;
        }

        PL = 1 - PL;
        return PL;
    }

    public static double P_path_failure(int N, double LF) {
        return 1 - Math.pow(1 - LF, N - 1);
    }

    public static double P_existence_of_backup_path(int R, double P_path_failure) {
        return 1 - Math.pow(P_path_failure, R - 1);
    }

    public static double Survivability(double PL, double Delay, double P_path_failure,
                                       double P_existence_of_backup_path, double T, double T1) {
        double sur;

        sur = (1 - P_path_failure)
                /
                ((1 + Math.max(PL - T, 0) + Math.max(Delay - T1, 0))
                        * (1 - P_path_failure * P_existence_of_backup_path));

        return sur;
    }

    public static double L(int B, double lambda, double mu) {
        if (lambda == mu) {
            return (B + 1) / 2;
        }
        double ro = lambda / mu;
        return (ro / (1 - ro)) - ((B + 2) * Math.pow(ro, B + 2) / (1 - Math.pow(ro, B + 2)));
    }

    public static double P(int B, double lambda, double mu) {
        return Math.pow(lambda / mu, B + 1) * (1 - (lambda / mu)) / (1 - Math.pow(lambda / mu, B + 2));
    }

    public static double W(int B, double L, double P, double mu) {
        return (L - (B + 2) * P + 1) / (mu * (1 - P));
    }
}
