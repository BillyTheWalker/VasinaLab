package implementations;

import interfaces.Function;

/**
 * Created by Kishka on 22.10.2017.
 */
public class Function_2 implements Function {
    public double calculate(double x) {
        return (Math.log(1.5 * x) - (1.7 * x) + 3.0);
    }

    public double calculateP(double x) {
        return ((1 / (1.5 * x)) - 1.7);
    }

    public double calculateFi(double x) {
        return ((Math.log(1.5*x)+3)/1.7);
    }
}
