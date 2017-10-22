package implementations;

import interfaces.Function;

/**
 * Created by Kishka on 22.10.2017.
 */
public class Function_7 implements Function{
    //3x-cosx-1
    public double calculate(double x) {
        return (3*x-Math.cos(x)-1);
    }

    public double calculateP(double x) {
        return (3+Math.sin(x));
    }

    public double calculateFi(double x) {
        return ((Math.cos(x)+1)/3);
    }
}
