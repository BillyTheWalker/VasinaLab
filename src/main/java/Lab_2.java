import java.util.ArrayList;

/**
 * Created by Kishka on 22.10.2017.
 */
public class Lab_2 {

    public static void main(String[] args) {
        System_Equation system_equation = new System_Equation();

        system_equation.a.add(new ArrayList<Double>());
        system_equation.a.get(0).add(2.68);
        system_equation.a.get(0).add(-.68);
        system_equation.a.get(0).add(.48);
        system_equation.a.get(0).add(3.868);

        system_equation.a.add(new ArrayList<Double>());
        system_equation.a.get(1).add(-.73);
        system_equation.a.get(1).add(2.92);
        system_equation.a.get(1).add(-.39);
        system_equation.a.get(1).add(4.329);

        system_equation.a.add(new ArrayList<Double>());
        system_equation.a.get(2).add(.58);
        system_equation.a.get(2).add(-1.12);
        system_equation.a.get(2).add(3.12);
        system_equation.a.get(2).add(7.532);

        system_equation.methodGauss();
    }

}
