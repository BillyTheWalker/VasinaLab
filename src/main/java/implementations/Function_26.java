package implementations;

import interfaces.Function;

/**
 * Created by Kishka on 30.10.2017.
 */
public class Function_26 implements Function {
    @Override
    public double calculate(double x) {
        return Math.cos(x)-1.5*x;
    }

    @Override
    public double calculateP(double x) {
        return -Math.sin(x)-1.5;
    }

    @Override
    public double calculateFi(double x) {
        return Math.cos(x)/1.5;
    }
}
