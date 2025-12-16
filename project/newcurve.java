import javax.swing.*;
import java.awt.event.*;
public class newcurve extends JFrame implements ActionListener {
    JButton b1, b2;
    JTextField tx1, tx2, tx3;
    JLabel l, l1, l2, l3;
    newcurve() {
        b1 = new JButton("Draw Curve");
        b2 = new JButton("Reset");

        tx1 = new JTextField();
        tx2 = new JTextField();
        tx3 = new JTextField();

        l = new JLabel("Enter values separated by comma:");
        l1 = new JLabel("Enter X Coordinates of Control Points:");
        l2 = new JLabel("Enter Y Coordinates of Control Points:");
        l3 = new JLabel("Values of t:");

        l.setBounds(50, 30, 300, 30);

        l1.setBounds(50, 80, 220, 30);
        tx1.setBounds(280, 80, 250, 30);

        l2.setBounds(50, 130, 220, 30);
        tx2.setBounds(280, 130, 250, 30);

        l3.setBounds(50, 180, 220, 30);
        tx3.setBounds(280, 180, 250, 30);

        b1.setBounds(120, 250, 120, 40);
        b2.setBounds(300, 250, 120, 40);

        add(l);
        add(l1);
        add(l2);
        add(l3);

        add(tx1);
        add(tx2);
        add(tx3);

        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);

        setTitle("Bezier Curve Input");
        setSize(600, 400);
        setLocation(500, 150);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String[] p1 = tx1.getText().split(",");
            int[] x = new int[p1.length];
            for (int i = 0; i < p1.length; i++) {
                x[i] = Integer.parseInt(p1[i].trim());
            }
            String[] p2 = tx2.getText().split(",");
            int[] y = new int[p2.length];
            for (int i = 0; i < p2.length; i++)
                y[i] = Integer.parseInt(p2[i].trim());

            String[] p3 = tx3.getText().split(",");
            double[] t1 = new double[p3.length];
            for (int i = 0; i < p3.length; i++) {
                t1[i] = Double.parseDouble(p3[i].trim());
            }
            curve panel = new curve(x, y, t1);
            JFrame f = new JFrame("Bezier Curve");
            f.add(panel);
            f.setSize(750, 750);
            f.setLocation(200, 100);
            f.setVisible(true);
        }
        if (e.getSource() == b2) {
            tx1.setText("");
            tx2.setText("");
            tx3.setText("");
        }
    }
    public static void main(String[] args) {
        new newcurve();
    }
}
