import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Kishka on 20.10.2017.
 */
public class Lab_1 extends JFrame {

    public static final int width = 1500;
    public static final int height = 1000;
    public static double x_min = -7.5;
    public static double x_max = 7.5;
    public static double x_begin = 0.001;
    public static double x_end = 7.5;
    public static double y_min = -5;
    public static double y_max = 5;

    public Lab_1() {
        setLayout(new BorderLayout());
        add(new DrawSine(), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Lab_1 frame = new Lab_1();
        frame.setSize(width + 50, height + 50);
        frame.setTitle("Lab_1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    class DrawSine extends JPanel {


        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int x_step = (int) (width / (Math.abs(x_min) + Math.abs(x_max)));
            int y_step = (int) (height / (Math.abs(y_min) + Math.abs(y_max)));
            int x_zero = (y_min <= 0 && y_max >= 0) ? (int) (Math.abs(y_min) * x_step) : ((y_max < 0) ? 0 : height);
            int y_zero = (x_min <= 0 && x_max >= 0) ? (int) (Math.abs(x_min) * x_step) : ((x_max < 0) ? width : 0);


//          main axis
//            x
            g.drawLine(0, x_zero, width, x_zero);
//            y
            g.drawLine(y_zero, 0, y_zero, height);
//          axis borders
            g.drawLine(y_zero - 20, 20, y_zero, 0);
            g.drawLine(y_zero, 0, y_zero + 20, 20);
            g.drawString("Y", y_zero - 10, 20);

            g.drawLine(width - 20, x_zero - 20, width, x_zero);
            g.drawLine(width, x_zero, width - 20, x_zero + 20);
            g.drawString("X", width - 20, x_zero - 20);


//          axis points
            for (int i = (int) ((Math.abs(x_min % 1)) * x_step), j = (int) (x_min - (x_min % 1) / 10);
                 j < x_max;
                 i += x_step, j++) {
                if (j != 0)
                    g.drawLine(i, x_zero - 10, i, x_zero + 10);
                g.drawString(j + "", i - 10, x_zero + 20);
            }
            for (int i = (int) ((Math.abs(y_max % 1)) * y_step), j = (int) (y_max - (y_max % 1) / 10);
                 j > y_min;
                 i += y_step, j--) {
                if (j == 0)
                    continue;
                g.drawLine(y_zero - 10, i, y_zero + 10, i);
                g.drawString(j + "", y_zero - 10, i);
            }

            Polygon p = new Polygon();

            NumberFormat format = new DecimalFormat("#0.0000000");

            for (int x = (int) (x_begin * width); x <= (int) (Math.abs(x_end) * width); x++) {
                if (func_2((x / (double) (height))) >= -0.001 && func_2((x / (double) (height))) <= 0.001) {
                    System.err.println("x: " + format.format((x / (double) (height))) +
                            " f(x) = " + format.format(func_2((x / (double) (height)))));
                }
                p.addPoint(x / 10 + y_zero, x_zero - (int) (100 * func_2((x / (double) (height)))));
            }
            g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
//            p.reset();
//            for (int x = -7500; x <= 7500; x++) {
//                p.addPoint(x / 10 + Lab_1.width, Lab_1.height/2 - (int) (100 * func_1((x / Lab_1.height))));
//            }
//            g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
        }

        private double func_2(double x) {
            return (Math.log(1.5 * x) - (1.7 * x) + 3.0);
        }

        private double func_1(double x) {
            return (Math.pow(2, x) + 5 * x - 3);
        }

    }

}
