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
    List<List<Double>> b = new ArrayList<List<Double>>();
    List<List<Double>> aa = new ArrayList<List<Double>>();
    Double e = .001;


    public void methodGauss() {
        aa = copy(aa, a);
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
        System.err.println("\n\nGauss\n");
        System.err.println("x: ");
        printVector(x);
//        System.err.println("a: ");
//        printMatrix(a);
//        System.err.println("a': ");
//        printMatrix(aa);
//        System.err.println("b: ");
//        printMatrix(b);
        Double res = .0;
        for (List<Double> list : a) {
            for (int i = 0; i < x.size(); i++) {
//                System.err.print("(" + format.format(list.get(i)) + ")*(" + format.format(x.get(i)) + ")+");
//                System.err.println("-----------a.get(0).get(i) * x.get(i): " + (list.get(i) * x.get(i)));
                res += list.get(i) * x.get(i);
//                System.err.println("res: " + res);
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
        List<Double> list = new ArrayList<Double>();
        for (int i = 0; i < a.size(); i++) {
            Double d = .0;
            for (int j = 0; j < a.get(i).size(); j++) {
                d += a.get(i).get(j);
            }
            list.add(d);
        }
    }

    private List<List<Double>> copy(List<List<Double>> a, List<List<Double>> b) {
        a = new ArrayList<List<Double>>();
        for (List<Double> list : b) {
            List<Double> doubleList = new ArrayList<Double>();
            doubleList.addAll(list);
            a.add(doubleList);
        }
        return a;
    }

    private List<Double> copyV(List<Double> a, List<Double> b) {
        a = new ArrayList<>();
        for (Double list : b) {
            a.add(list);
        }
        return a;
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

//    void Jacobi (int N, double** A, double* F, double* X)
//    {
//	double* TempX = new double[N];
//        double norm; // норма, определяемая как наибольшая разность компонент столбца иксов соседних итераций.
//
//        do {
//            for (int i = 0; i < N; i++) {
//                TempX[i] = F[i];
//                for (int g = 0; g < N; g++) {
//                    if (i != g)
//                        TempX[i] -= A[i][g] * X[g];
//                }
//                TempX[i] /= A[i][i];
//            }
//            norm = fabs(X[0] - TempX[0]);
//            for (int h = 0; h < N; h++) {
//                if (fabs(X[h] - TempX[h]) > norm)
//                    norm = fabs(X[h] - TempX[h]);
//                X[h] = TempX[h];
//            }
//        } while (norm > eps);
//        delete[] TempX;
//    }

    public void jakobi() {
        int now, old, tmp, i, j, N;
        int m = 3;
        Double max, S;
        List<List<Double>> bb = new ArrayList<>();
        List<List<Double>> xx = new ArrayList<>();
        getNearX(m, bb);
        old = 0;
        now = 1;
        N = 0;
        for (i = 0; i < m; i++) {
            xx.add(new ArrayList<>());
            xx.get(i).add(bb.get(i).get(m));
        }
        do {
            for (i = 0; i < m; i++) {
                S = .0;
                for (j = 0; j < m; j++) {
                    S = S + bb.get(i).get(j) * xx.get(j).get(old);
                }
                if (xx.get(i).size() == now) {
                    xx.get(i).add(S + bb.get(i).get(m));
                }
                xx.get(i).set(now, S + bb.get(i).get(m));
            }
            max = Math.abs(xx.get(0).get(now) - xx.get(0).get(old));
            for (i = 1; i < m; i++) {
                if (Math.abs(xx.get(i).get(old) - xx.get(i).get(now)) > max) {
                    max = Math.abs(xx.get(i).get(old) - xx.get(i).get(now));
                }
            }
            tmp = now;
            now = old;
            old = tmp;
            N++;
        } while ((max >= e) && N < 3);
        System.err.println("\n\nJakobi\n");
        for (i = 0; i < m; i++)
            System.err.print(format.format(xx.get(i).get(now)) + "  ");
        System.err.println("\nn = " + N);
        System.err.println("max = " + format.format(max));
    }

    private void getNearX(int m, List<List<Double>> bb) {
        int i;
        int j;
        for (i = 0; i < a.size()-2; i++) {
            bb.add(new ArrayList<>());
            for (j = 0; j < m + 1; j++) {
                if (i != j)
                    if (j == m) {
                        bb.get(i).add(a.get(i).get(j) / a.get(i).get(i));
                    } else {
                        bb.get(i).add(-a.get(i).get(j) / a.get(i).get(i));
                    }
                else {
                    bb.get(i).add(.0);
                }
            }
        }
    }

//    private List<Double> getNearX(List<Double> x) {
//        for (int i = 0; i < a.size(); i++) {
//            x.add(a.get(i).get(a.size() - 1) / a.get(i).get(i));
//        }
//        return x;
//    }

    public void seidel() {
//        System.err.println("");
//        System.err.println("");
//        System.err.println("");
//        List<Double> xx = new ArrayList<>();
//        List<Double> xNew = new ArrayList<>();
//        int n=0;
//        xx = getNearX(xx);
//        xNew = copyV(xNew, xx);
//        printVector(xx);
//        do {
//            xx = copyV(xx, xNew);
//            for (int i = 0; i < xx.size(); i++) {
//                xNew.set(i,
//                        (a.get(i).get(a.size() - 1) - sum(a.get(i), xNew, 0, i) - sum(a.get(i), xx, i + 1, xx.size())) /
//                                a.get(i).get(i));
//            }
//            printVector(xNew);
//            n++;
//        } while ((Math.sqrt(sum(xNew, xx)) >= e)&&(n<3));
//        System.err.println("\n\nSeidel\n");
//        printVector(xNew);
        int i,j,N;
        int m=3;
        Double max, S;
        List<List<Double>> bb = new ArrayList<>();
        List<List<Double>> xx = new ArrayList<>();
        getNearX(m,bb);
        N=0;
        for (i = 0; i < m; i++) {
            xx.add(new ArrayList<>());
            xx.get(i).add(bb.get(i).get(m));
        }
        do{
            max=.0;
            for (i=0;i<m;i++) {
                S = .0;
                for (j = 0; j < m; j++)
                    S = S + bb.get(i).get(j) * xx.get(j);
                if (Math.abs(xx[i]-S-b[i][m])>max)
                    max=Math.abs(xx[i]-S-b[i][m]);
                xx[i]=S+b[i][m];
            }
            N++;
        }while((max>=e)&&(k>N));
        if(N<k) {
            for (i = 0; i < m; i++)
                System.out.print(xx[i] + "  ");
            System.out.println("n = " + N);
            System.out.println("max = "+max);
        } else System.out.println("n>=k, rozviazku nemaie");
    }

    private Double sum(List<Double> a, List<Double> b) {
        Double sum = .0;
        for (int i = 0; i < a.size(); i++) {
            sum += Math.pow(a.get(i) - b.get(i), 2);
        }
        System.err.println(format.format(sum));
        return sum;
    }

    private Double sum(List<Double> a, List<Double> b, int i, int j) {
        Double sum = .0;
        for (int ii = i; ii < j; ii++) {
            sum += a.get(ii) * b.get(ii);
        }
        return sum;
    }
}
