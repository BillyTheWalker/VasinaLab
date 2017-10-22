import interfaces.Function;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Kishka on 22.10.2017.
 */
public class LabUtils {

    private static NumberFormat format = new DecimalFormat("#0.000000");


    public static void bisection(double x_left, double x_right, double e, Function function) {
        if (function.calculate(x_left) * function.calculate(x_right) > 0)
            return;
        int iter = 0;
        while ((x_right - x_left) > e) {
            double x = (x_left + x_right) / 2;
            if (function.calculate(x) * function.calculate(x_left) < 0) {
                x_right = x;
            } else {
                x_left = x;
            }
            iter++;
        }
        System.err.println(String.format("bisection: Rozv = %s, iter = %d, poh = %s", format.format((x_left + x_right) / 2),
                iter, format.format(function.calculate((x_left + x_right) / 2))));
    }

    public static void hord(double x_left, double x_right, double fixed, double e, Function function) {
        double res = .0, res_temp = .0;
        int iter = 0;
        res = (fixed == x_left) ? x_right : x_left;
        do {
            res_temp = res;
            res = res - ((function.calculate(res) * (fixed - res)) / (function.calculate(fixed) - function.calculate(res)));
            iter++;
        } while (Math.abs(res - res_temp) > e);
        System.err.println(String.format("hord: Rozv = %s, iter = %d, poh = %s", format.format(res),
                iter, format.format(function.calculate(res))));
    }

    public static void touch(double x, double e, Function function) {
        double x_temp = .0;
        int iter = 0;
        do {
            x_temp = x;
            x = x - (function.calculate(x) / function.calculateP(x_temp));
            iter++;
        } while (Math.abs(x - x_temp) > e);
        System.err.println(String.format("touch: Rozv = %s, iter = %d, poh = %s", format.format(x),
                iter, format.format(function.calculate(x))));
    }

    public static void hord_touch(double x_left, double x_right, double fixed, double e, Function function) {
        double temp;
        int iter = 0;
        if (fixed == x_left) {
            temp = x_left;
            x_left = x_right;
            x_right = temp;
        }
        do {
            x_left = x_left - (function.calculate(x_left) * (x_right - x_left)) / (function.calculate(x_right) - function.calculate(x_left));
            x_right = x_right - function.calculate(x_right) / function.calculateP(x_right);
            iter++;
        } while (Math.abs(x_left - x_right) > e);
        System.err.println(String.format("hord-touch: Rozv = %s, iter = %d, poh = %s", format.format((x_left + x_right) / 2),
                iter, format.format(function.calculate((x_left + x_right) / 2))));
    }

    public static void iteration(double x, double e, Function function) {

        double temp;
        int iter = 0;

        do {
            temp = x;
            x = function.calculateFi(x);
            iter++;
        } while (Math.abs(x - temp) > e);

        System.err.println(String.format("iteration: Rozv = %s, iter = %d, poh = %s", format.format(x),
                iter, format.format(x - function.calculateFi((x)))));

    }

}
