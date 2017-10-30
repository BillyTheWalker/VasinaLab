import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kishka on 22.10.2017.
 */
public class System_Equation {
    private static NumberFormat format = new DecimalFormat("#0.000000");

    public List<Double> x = new ArrayList<>();
    public List<List<Double>> a = new ArrayList<>();
    public List<List<Double>> at = new ArrayList<>();
    public List<List<Double>> alDop = new ArrayList<>();
    List<List<Double>> b = new ArrayList<>();
    List<List<Double>> aa = new ArrayList<>();

    public void methodGauss() {
        copy();
        for (int k = 0; k < aa.size() - 1; k++) {
            b.add(new ArrayList<Double>());
            for (int i = 0; i < k; i++) {
                b.get(k).add(i, .0);
            }
            for (int i = k + 1; i < aa.get(k).size(); i++) {
//                System.out.println("b.get(" + k + ").add(a.get(" + k + ").get(" + i + ")(" + format.format(a.get(k).get(i)) +
//                        ") / a.get(aa + k + ").get(" + k + ")(" + format.format(a.get(k).get(k)) + ")) = " +
//                        format.format(a.get(k).get(i) / a.get(k).get(k)));
                b.get(k).add(aa.get(k).get(i) / aa.get(k).get(k));
            }
            for (int i = k + 1; i < aa.size(); i++) {
                for (int j = k + 1; j < aa.get(0).size(); j++) {
//                    System.out.println(b.get(k).size());
//                    System.out.println("a[" + (i + 1) + "][" + (j + 1) + "](" + format.format(a.get(i).get(j)) +
//                            ")=a[" + (i + 1) + "][" + (j + 1) + "](" + format.format(a.get(i).get(j)) +
//                            ")-a[" + (i + 1) + "][" + (k + 1) + "](" + format.format(a.get(i).get(k)) +
//                            ")*b[" + (k + 1) + "][" + (j + 1) + "](" + format.format(b.get(k).get(j-1)) +
//                            ")(" + format.format(a.get(i).get(j) - a.get(i).get(k) * b.get(k).get(j-1)) + ")");
                    aa.get(i).set(j, aa.get(i).get(j) - aa.get(i).get(k) * b.get(k).get(j - 1));
                }
            }
            for (int i = k + 1; i < aa.size(); i++) {
                aa.get(i).set(k, .0);
            }
            x.add(.0);
        }
        x.add(.0);
        setX();
        System.err.println("x: ");
        printVector(x);
        System.err.println("a: ");
        printMatrix(a);
        System.err.println("a': ");
        printMatrix(aa);
        System.err.println("b: ");
        printMatrix(b);
        Double res = .0;
        for (List<Double> list : a) {
            for (int i = 0; i < x.size(); i++) {
//                System.err.print("(" + format.format(list.get(i)) + ")*(" + format.format(x.get(i)) + ")+");
//                System.err.println("-----------a.get(0).get(i) * x.get(i): " + (list.get(i) * x.get(i)));
                res += list.get(i) * x.get(i);
//                System.err.println("res: " + res);
            }
            System.err.println("res = " + format.format(res) + " in a " + format.format(list.get(list.size() - 1)));
        }
    }

    private void methodMatrix() {
        copy();
        x = new ArrayList<>();
        b = new ArrayList<>();

    }

    private void getAT(){
        for()
    }

    private double vyzn(List<List<Double>> lists) {
        double d1 = .0, d2 = .0;
        for (int i = 0; i < lists.get(0).size(); i++) {
            double tmp = lists.get(0).get(i);
            for (int j = 1; j < lists.size(); j++) {
                int k = i + j;
                if (k > lists.get(0).size())
                    k -= lists.get(0).size();
                tmp *= lists.get(j).get(k);
            }
            d1 += tmp;
        }
        for (int i = lists.get(0).size() - 1; i >= 0; i--) {
            double tmp = lists.get(0).get(i);
            for (int j = 1; j < lists.size(); j++) {
                int k = i - j;
                if (k < 0)
                    k = lists.get(0).size() - (j - i);
                tmp *= lists.get(j).get(k);
            }
            d2 += tmp;
        }
        return d1 - d2;
    }

    private void algDop() {
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size() - 1; j++) {

            }
        }
    }

    private void setX() {
//        System.out.println("x.size() " + x.size());
        x.set(x.size() - 1, aa.get(aa.size() - 1).get(aa.get(0).size() - 1) / aa.get(aa.size() - 1).get(aa.get(0).size() - 2));
        for (int i = b.size() - 1; i >= 0; i--) {
//            System.out.println("b.get(" + i + ").size()" + b.get(i).size());
            Double value = b.get(i).get(b.size());
            for (int j = x.size() - 1; j > i; j--) {
//                System.err.println("i = " + i + " j = " + j);
                value -= b.get(i).get(j - 1) * x.get(j);
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
        aa = new ArrayList<>();
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
