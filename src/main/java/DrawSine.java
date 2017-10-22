import implementations.Function_2;
import interfaces.Function;

import javax.swing.*;
import java.awt.*;

class DrawSine extends JPanel {

    private Function function;

    public DrawSine() {
    }

    public DrawSine(Function function) {
        this.function = function;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x_step = (int) (Lab_1.width / (Math.abs(Lab_1.x_min) + Math.abs(Lab_1.x_max)));
        int y_step = (int) (Lab_1.height / (Math.abs(Lab_1.y_min) + Math.abs(Lab_1.y_max)));
        int x_zero = (Lab_1.y_min <= 0 && Lab_1.y_max >= 0) ? (int) (Math.abs(Lab_1.y_max) * y_step) : ((Lab_1.y_max < 0) ? 0 : Lab_1.height);
        int y_zero = (Lab_1.x_min <= 0 && Lab_1.x_max >= 0) ? (int) (Math.abs(Lab_1.x_min) * x_step) : ((Lab_1.x_max < 0) ? Lab_1.width : 0);

        g.drawLine(0, x_zero, Lab_1.width, x_zero);
        g.drawLine(y_zero, 0, y_zero, Lab_1.height);

        g.drawLine(y_zero - 20, 20, y_zero, 0);
        g.drawLine(y_zero, 0, y_zero + 20, 20);
        g.drawString("Y", y_zero - 10, 20);

        g.drawLine(Lab_1.width - 20, x_zero - 20, Lab_1.width, x_zero);
        g.drawLine(Lab_1.width, x_zero, Lab_1.width - 20, x_zero + 20);
        g.drawString("X", Lab_1.width - 20, x_zero - 20);

        for (int i = (int) ((Math.abs(Lab_1.x_min % 1)) * x_step), j = (int) (Lab_1.x_min - (Lab_1.x_min % 1) / 10);
             j < Lab_1.x_max;
             i += x_step, j++) {
            if (j != 0)
                g.drawLine(i, x_zero - 10, i, x_zero + 10);
            g.drawString(j + "", i - 10, x_zero + 20);
        }

        for (int i = (int) ((Math.abs(Lab_1.y_max % 1)) * y_step), j = (int) (Lab_1.y_max - (Lab_1.y_max % 1) / 10);
             j > Lab_1.y_min;
             i += y_step, j--) {
            if (j == 0)
                continue;
            g.drawLine(y_zero - 10, i, y_zero + 10, i);
            g.drawString(j + "", y_zero - 10, i);
        }

        Polygon p = new Polygon();
        drawPlot(x_zero, y_zero, p, function);
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }

    private void drawPlot(int x_zero, int y_zero, Polygon p, Function function) {
        for (int x = (int) (Lab_1.x_begin * Lab_1.width); x <= (int) (Math.abs(Lab_1.x_end) * Lab_1.width); x++) {
            p.addPoint(x / 10 + y_zero, x_zero - (int) (100 * function.calculate((x / (double) (Lab_1.height)))));
        }
    }


}