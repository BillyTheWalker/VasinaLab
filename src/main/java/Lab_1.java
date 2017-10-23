import implementations.Function_1;
import implementations.Function_2;
import implementations.Function_7;
import interfaces.Function;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kishka on 20.10.2017.
 */
public class Lab_1 extends JFrame {

    static final int width = 1500;
    static final int height = 1000;
    static double x_begin = 0.001;
    static double x_end = 7.5;
    static double x_min = -0.2;//left value of x on plot
    static double x_max = 15;//right value of x on plot
    static double x_left = 2;//values between ehich y=0
    static double x_right = 3;
    static double e = .001;
    static double y_min = -15;//bottom value of y on plot
    static double y_max = 3;//top value of y on plot
    private static Function function = new Function_2();//your function(defiend in folder implementations)

    private Lab_1() {
        setLayout(new BorderLayout());
        add(new DrawSine(function), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Lab_1 frame = new Lab_1();
        frame.setSize(width + 50, height + 50);
        frame.setTitle("Lab_1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        LabUtils.bisection(x_left, x_right, e, function);
        LabUtils.hord(x_left, x_right, x_left, e, function);
        LabUtils.hord_touch(x_left, x_right, x_left, e, function);
        LabUtils.touch(x_left, e, function);
        LabUtils.iteration(x_left, e, function);
    }


}
