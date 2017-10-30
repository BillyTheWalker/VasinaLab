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
    List<List<Double>> c = new ArrayList<List<Double>>();
    List<List<Double>> aa = new ArrayList<>();

    public void methodGauss() {
        copy();
        for (int k = 0; k < a.size() - 1; k++) {
            c.add(new ArrayList<Double>());
            for (int i = 0; i < k; i++) {
                c.get(k).add(i, .0);
            }
            for (int i = k + 1; i < a.get(k).size(); i++) {
//                System.out.println("c.get(" + k + ").add(a.get(" + k + ").get(" + i + ")(" + format.format(a.get(k).get(i)) +
//                        ") / a.get(" + k + ").get(" + k + ")(" + format.format(a.get(k).get(k)) + ")) = " +
//                        format.format(a.get(k).get(i) / a.get(k).get(k)));
                c.get(k).add(a.get(k).get(i) / a.get(k).get(k));
            }
            for (int i = k + 1; i < a.size(); i++) {
                for (int j = k + 1; j < c.get(0).size(); j++) {
//                    System.out.println(c.get(k).size());
                    System.out.println("a[" + (i + 1) + "][" + (j + 1) + "](" + format.format(a.get(i).get(j)) +
                            ")=a[" + (i + 1) + "][" + (j + 1) + "](" + format.format(a.get(i).get(j)) +
                            ")-a[" + (i + 1) + "][" + (k + 1) + "](" + format.format(a.get(i).get(k)) +
                            ")*b[" + (k + 1) + "][" + (j + 1) + "](" + format.format(c.get(k).get(j)) +
                            ")(" + format.format(a.get(i).get(j) - a.get(i).get(k) * c.get(k).get(j)) + ")");
                    a.get(i).set(j, a.get(i).get(j) - a.get(i).get(k) * c.get(k).get(j));
                }
            }
            for (int i = k + 1; i < a.size(); i++) {
                a.get(i).set(k, .0);
            }
            x.add(.0);
        }
        x.add(.0);
        setX();
        System.err.println("x: ");
        printVector(x);
        System.err.println("a: ");
        printMatrix(aa);
        System.err.println("a': ");
        printMatrix(a);
        System.err.println("b: ");
        printMatrix(c);
        Double res = .0;
        for (List<Double> list : aa) {
            for (int i = 0; i < x.size(); i++) {
//                System.err.print("(" + format.format(list.get(i)) + ")*(" + format.format(x.get(i)) + ")+");
//                System.err.println("-----------a.get(0).get(i) * x.get(i): " + (list.get(i) * x.get(i)));
                res += list.get(i) * x.get(i);
//                System.err.println("res: " + res);
            }
            System.err.println("res = " + format.format(res) + " in a " + format.format(list.get(list.size() - 1)));
        }
    }

    private void setX() {
        System.out.println("x.size() " + x.size());
        x.set(x.size() - 1, a.get(a.size() - 1).get(a.get(0).size() - 1) / a.get(a.size() - 1).get(a.get(0).size() - 2));
        for (int i = x.size() - 2; i >= 0; i--) {
            System.out.println("c.get(" + i + ").size()" + c.get(i).size());
            Double value = c.get(i).get(i + 1);
            for (int j = x.size() - 1; j > i; j--) {
                value -= c.get(i).get(j) * x.get(j);
            }
            x.set(i, value);
        }
    }

    private void fillAs() {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            Double d = .0;
            for (int j = 0; j < a.get(i).size(); j++) {
                d += a.get(i).get(j);
            }
            list.add(d);
        }
    }

    private void copy() {
        for (List<Double> list : a) {
            List<Double> doubleList = new ArrayList<>();
            doubleList.addAll(list);
            aa.add(doubleList);
        }
    }

    private void printMatrix(List<List<Double>> c) {
        for (List<Double> list : c) {
            printVector(list);
        }
        System.err.println("");
    }

    private void printVector(List<Double> list) {
        for (Double el : list) {
            System.err.print(" " + format.format(el));
        }
        System.err.println("");
    }
}
