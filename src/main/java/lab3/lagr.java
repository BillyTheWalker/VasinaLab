package lab3;

public class lagr {
    private double x[] = {0.1, 0.6, 1.2, 1.8, 2.6};
    private double y[] = {1.10517, 1.82212, 3.32012, 6.04965, 13.4637};

    public void run(double x1) {
        double v, w, s;
        int i, j;
        s = 0;
        for (i = 0; i < y.length; i++) {
            v = 1;
            w = 1;
            for (j = 0; j < y.length; j++)
                if (i != j) {
                    v = v * (x1 - x[j]);
                    w = w * (x[i] - x[j]);
                }
            s = s + y[i] * v / w;
        }
        System.out.println("y(x) = " + s);
    }
}