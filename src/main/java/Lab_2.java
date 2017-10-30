import java.util.ArrayList;

/**
 * Created by Kishka on 22.10.2017.
 */
public class Lab_2 {

    public static void main(String[] args) {
        System_Equation system_equation = new System_Equation();

        system_equation.a.add(new ArrayList<Double>());
        system_equation.a.get(0).add(1.02);
        system_equation.a.get(0).add(2.0);
        system_equation.a.get(0).add(3.0);
        system_equation.a.get(0).add(-2.0);
        system_equation.a.get(0).add(6.0);

        system_equation.a.add(new ArrayList<Double>());
        system_equation.a.get(1).add(2.0);
        system_equation.a.get(1).add(-.02);
        system_equation.a.get(1).add(-2.0);
        system_equation.a.get(1).add(-3.0);
        system_equation.a.get(1).add(8 * 1.02);

        system_equation.a.add(new ArrayList<Double>());
        system_equation.a.get(2).add(3.0);
        system_equation.a.get(2).add(2.0);
        system_equation.a.get(2).add(-1.0);
        system_equation.a.get(2).add(-1.98);
        system_equation.a.get(2).add(.08);

        system_equation.a.add(new ArrayList<Double>());
        system_equation.a.get(3).add(2.0);
        system_equation.a.get(3).add(-3.0);
        system_equation.a.get(3).add(2.0);
        system_equation.a.get(3).add(1.0);
        system_equation.a.get(3).add(-8 * 1.06);

        system_equation.methodGauss();
    }

}
