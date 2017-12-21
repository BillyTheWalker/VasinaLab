package lab3;

public class newton {
    private double y[] = {1.5, 2.9, 2.33, 1.85, 1.62};
    public void run(double x) {
        double x0 = 1, h = 0.5, u, s, t;
        int i, k;
        s = 0;
        for (k = 0; k < y.length - 1; k++) {
            u = y[k];
            for (i = k; i < y.length - 1; i++) {
                s = y[i + 1] - y[i];
                y[i] = u;
                u = s;
            }
            y[y.length - 1] = u;
        }
        t = (x - x0) / h;
        u = 1;
        s = y[0];
        for (i = 1; i < y.length; i++) {
            u *= t / i;
            s += u * y[i];
            t--;
        }
        System.out.println("y(x) = " + s);
    }
}
