import java.util.ArrayList;

/**
 * Created by Kishka on 22.10.2017.
 */
public class Lab_2 {

    public static void main(String[] args) {
        System_Equation system_equation = new System_Equation();
        double k = 0.08;

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
        system_equation.a.get(2).add(-.58);
        system_equation.a.get(2).add(-1.12);
        system_equation.a.get(2).add(3.12);
        system_equation.a.get(2).add(7.532);

//        System_Equation system_equation = new System_Equation();
//        system_equation.run(new double[][]{{2.68,-.68,.48,3.868},{-.73,2.92,-.39,4.329},{-.58,-1.12,3.12,7.532}},0.001,20);

//        system_equation.a.add(new ArrayList<Double>());
//        system_equation.a.get(0).add(1.0+k);
//        system_equation.a.get(0).add(2.0);
//        system_equation.a.get(0).add(3.0);
//        system_equation.a.get(0).add(-2.0);
//        system_equation.a.get(0).add(6.0);
//
//        system_equation.a.add(new ArrayList<Double>());
//        system_equation.a.get(1).add(2.0);
//        system_equation.a.get(1).add(-k);
//        system_equation.a.get(1).add(-2.0);
//        system_equation.a.get(1).add(-3.0);
//        system_equation.a.get(1).add(8 * (1.0-k));
//
//        system_equation.a.add(new ArrayList<Double>());
//        system_equation.a.get(2).add(3.0);
//        system_equation.a.get(2).add(2.0);
//        system_equation.a.get(2).add(-1.0);
//        system_equation.a.get(2).add(-(2.0-k));
//        system_equation.a.get(2).add(4.0*k);
//
//        system_equation.a.add(new ArrayList<Double>());
//        system_equation.a.get(3).add(2.0);
//        system_equation.a.get(3).add(-3.0);
//        system_equation.a.get(3).add(2.0);
//        system_equation.a.get(3).add(1.0);
//        system_equation.a.get(3).add(-8 * (1+3*k));

        system_equation.methodGauss();
        system_equation.jakobi();
        system_equation.seidel();
    }

}
