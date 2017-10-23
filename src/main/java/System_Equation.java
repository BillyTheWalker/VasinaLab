import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kishka on 22.10.2017.
 */
public class System_Equation {
    private static NumberFormat format = new DecimalFormat("#0.000000");

    public List<Double> x = new ArrayList<Double>();
    public List<List<Double>> a = new ArrayList<List<Double>>();

    public void methodGauss() {
        List<List<Double>> c = new ArrayList<List<Double>>();
        for (int k = 0; k < a.size()-1; k++) {
            c.add(new ArrayList<Double>());
            for (int i = 0; i < k; i++) {
                c.get(k).add(i, 1.0);
            }
            for (int i = k; i < a.get(k).size(); i++) {
                c.get(k).add(a.get(k).get(i) / a.get(k).get(k));
            }
            for (int i = k + 1; i < a.size(); i++) {
                for (int j = k + 1; j < a.get(0).size(); j++) {
                    a.get(i).set(j, a.get(i).get(j) - a.get(i).get(k) * c.get(k).get(j));
                }
            }
            for (int i = k; i < a.size();i++) {
                a.get(i).set(k, .0);
            }
            x.add(.0);
        }



        printMatrix(a);
        printMatrix(c);
    }

    private void printMatrix(List<List<Double>> c) {
        for (List<Double> list : c) {
            for (Double el : list) {
                System.err.print(" " + format.format(el));
            }
            System.err.println("");
        }
        System.err.println("");
    }
}
