import implementations.Function_2;
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
    static double x_min = -0.2;
    static double x_max = 15;
    static double y_min = -5;
    static double y_max = 5;
    private static Function function = new Function_2();

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
        LabUtils.bisection(2, 3, .001, function);
        LabUtils.hord(2, 3, 2, .001, function);
        LabUtils.hord_touch(2, 3, 2, .001, function);
        LabUtils.touch(2.5, .001, function);
        LabUtils.iteration(2.5, .001, function);
    }


}
