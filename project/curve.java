import javax.swing.*;
import java.awt.*;
public class curve extends JPanel {
    int unit = 5;
    int[] x, y;
    double[] t;
    curve() {

    }
    curve(int[] x, int[] y, double[] t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g1 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int ox = width / 2;
        int oy = height / 2;
        g1.setStroke(new BasicStroke(2));
        g1.drawLine(20, oy, width - 20, oy);
        g1.drawLine(ox, 0, width / 2, height);
        for (int i = -100; i <= 100; i += 5) {
            int xPos = ox + i * unit;
            int yPos = oy - i * unit;
            if (xPos >= 20 && xPos <= width - 20) {
                g1.drawLine(xPos, oy - 4, xPos, oy + 4);
                g1.drawString(Integer.toString(i), xPos - 10, oy + 18);
            }
            if (yPos >= 20 && yPos <= height - 20) {
                g1.drawLine(ox - 4, yPos, ox + 4, yPos);
                if (i != 0)
                    g1.drawString(Integer.toString(i), ox + 8, yPos + 4);
            }
        }
        int[] x = this.x;
        int[] y = this.y;
        double[] t1 = this.t;
        g1.setColor(Color.BLUE);
        for (int i = 0; i < x.length; i++) {
            g1.fillOval((ox + x[i] * unit) - 4, (oy - y[i] * unit) - 4, 8, 8);

        }
        g1.setColor(Color.GRAY);
        for (int i = 0; i < x.length - 1; i++) {
            int x1 = ox + x[i] * unit;
            int y1 = oy - y[i] * unit;
            int x2 = ox + x[i + 1] * unit;
            int y2 = oy - y[i + 1] * unit;
            g1.drawLine(x1, y1, x2, y2);
        }
        g1.setColor(Color.RED);
        for (double t : t1) {
            Point p = bezpointt.bezierPoint(x, y, t);
            g1.fillOval(ox + (int) (p.x * unit) - 4, oy - (int) (p.y * unit) - 4, 8, 8);
        }
        for (int i = 0; i < (t1.length) - 1; i++) {
            double p1 = t1[i];
            double p2 = t1[i + 1];
            Point prev = bezpointt.bezierPoint(x, y, p1);
            Point pcur = bezpointt.bezierPoint(x, y, p2);
            int x1 = ox + (int) (prev.x * unit);
            int y1 = oy - (int) (prev.y * unit);
            int x2 = ox + (int) (pcur.x * unit);
            int y2 = oy - (int) (pcur.y * unit);
            g1.drawLine(x1, y1, x2, y2);
            prev = pcur;
        }
    }
    public static void main(String[] args) {
        curve c = new curve();
        JFrame f = new JFrame("Bezier Curve");
        f.setSize(800, 600);
        f.add(c);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Point {
    double x, y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class bezpointt {
    public static Point bezierPoint(int[] x, int[] y, double t) {
        int n = x.length - 1;
        double Bx = 0, By = 0;
        for (int i = 0; i <= n; i++) {
            double C = 1;
            for (int k = 1; k <= i; k++)
                C = C * (n - (i - k)) / k;
            double bernstein = C * Math.pow(1 - t, n - i) * Math.pow(t, i);
            Bx += bernstein * x[i];
            By += bernstein * y[i];
        }
        return new Point(Bx, By);
    }
}
