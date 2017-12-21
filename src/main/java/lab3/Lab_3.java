package lab3;

import java.util.Scanner;

public class Lab_3 {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        double x;
        while (true) {
            System.out.println("l3 vvedit x1(to exit '1488' or any non numerical)");
            try {
                x = sc.nextDouble();
            } catch (Exception e) {
                break;
            }
            if (x == 1488.0)
                break;
            lagr l = new lagr();
            l.run(x);
        }
        while (true) {
            System.out.println("n vvedit x1(to exit '1488' or any non numerical)");
            try {
                x = sc.nextDouble();
            } catch (Exception e) {
                break;
            }
            if (x == 1488.0)
                break;
            newton n = new newton();
            n.run(x);
        }
//        System.out.println("vvedit x1");
//        x=sc.nextDouble();
    }


}
