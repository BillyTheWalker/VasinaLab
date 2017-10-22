package implementations;

import interfaces.Function;

/**
 * Created by Kishka on 22.10.2017.
 */
public class Function_1 implements Function {
    //    x є [0,1]
    public double calculate(double x) {
        return (Math.pow(2, x) + 5 * x - 3);
    }

    public double calculateP(double x) {
        return (2 * x + 5);
    }

    public double calculateFi(double x) {
        return ((3 + Math.pow(2, x)) / 5);
    }
}
