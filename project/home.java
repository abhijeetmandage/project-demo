import javax.swing.*;
import java.awt.*;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class home extends JFrame implements ActionListener {
    JFrame f;
    JPanel lp;
    JScrollPane scp;
    StyledDocument d;
    JButton bg, bn;
    JTextArea ta;
    JMenuBar menuBar;
    JMenu loginb, signinb, logout, file, home1;
    JMenuItem exit, newhome, login1, singin, lo;
    public static int x = 20;
    public static int y = 10;
    public static boolean bol = false;
    home() {
        setTitle("Draw Geometric curve");
        setSize(1000, 500);
        setLocation(300, 200);
        setLayout(new BorderLayout());

        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(28, 28, 28)); 
        menuBar.setOpaque(true);
        menuBar.setPreferredSize(new Dimension(0, 40));
        menuBar.setFont(new Font("Arial", Font.BOLD, 50));

        loginb = new JMenu("Log In");
        signinb = new JMenu("Sign In");
        logout = new JMenu("Log Out");
        file = new JMenu("File");
        home1 = new JMenu("Home");

        loginb.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
        signinb.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
        logout.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
        file.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
        home1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
        loginb.setForeground(Color.white);
        signinb.setForeground(Color.white);
        logout.setForeground(Color.white);
        file.setForeground(Color.white);
        home1.setForeground(Color.white);

        loginb.setFont(new Font("Arial", Font.PLAIN, 15));
        signinb.setFont(new Font("Arial", Font.PLAIN, 15));
        logout.setFont(new Font("Arial", Font.PLAIN, 15));
        file.setFont(new Font("Arial", Font.PLAIN, 15));
        home1.setFont(new Font("Arial", Font.PLAIN, 15));

        exit = new JMenuItem("Exit");
        newhome = new JMenuItem("New Homepage");
        login1 = new JMenuItem("Login");
        singin = new JMenuItem("Signin");
        lo = new JMenuItem("logout");

        exit.setFont(new Font("SansSerif", Font.BOLD, 14));
        newhome.setFont(new Font("SansSerif", Font.BOLD, 14));
        login1.setFont(new Font("SansSerif", Font.BOLD, 14));
        singin.setFont(new Font("SansSerif", Font.BOLD, 14));
        lo.setFont(new Font("SansSerif", Font.BOLD, 14));

        menuBar.add(Box.createHorizontalStrut(30));
        menuBar.add(home1);
        menuBar.add(Box.createHorizontalStrut(30));
        menuBar.add(file);
        menuBar.add(Box.createHorizontalStrut(30));
        menuBar.add(loginb);
        menuBar.add(Box.createHorizontalStrut(30));
        menuBar.add(signinb);
        menuBar.add(Box.createHorizontalStrut(30));
        menuBar.add(logout);

        file.add(exit);
        home1.add(newhome);
        loginb.add(login1);
        signinb.add(singin);
        logout.add(lo);

        setJMenuBar(menuBar);
        menuBar.setBorder(BorderFactory.createEmptyBorder());

        lp = new JPanel();
        lp.setLayout(new BoxLayout(lp, BoxLayout.Y_AXIS));
        lp.setBackground(Color.BLACK);
        lp.setPreferredSize(new Dimension(250, 0));
        
        bg = new JButton("Geometry");
        bg.setAlignmentX(Component.CENTER_ALIGNMENT);

        lp.add(Box.createVerticalStrut(80));
        bn = new JButton("  Notes     ");
        bn.setAlignmentX(Component.CENTER_ALIGNMENT);

        bg.setBackground(new Color(112, 128, 144)); // Gold
        bn.setBackground(new Color(112, 128, 144)); // Gold
        bn.setFont(new Font("SansSerif", Font.BOLD, 14));
        bg.setFont(new Font("SansSerif", Font.BOLD, 14));
        bn.setForeground(Color.black);
        bg.setForeground(Color.black);

        lp.add(Box.createVerticalStrut(70));
        lp.add(bg);
        lp.add(Box.createVerticalStrut(150));
        lp.add(bn);

        ta = new JTextArea();
        ta.setBackground(new Color(45, 45, 46));
        ta.setForeground(Color.WHITE);
        ta.setBorder(BorderFactory.createEmptyBorder());
        ta.setText("\n");
        ta.append(" Introduction of Bézier curve:\n");

        ta.append(
                "         A Bézier curve is a parametric curve used in computer graphics and related fields.It is a smooth curve defined by a set of control points, where the curve generally\n"
                        +
                        "        follows the path of the points without necessarily passing through all of them.The first and last points are the anchors, and the intermediate points determine the shape\n"
                        +
                        "        and direction of the curve\n\n");

        ta.append("         1.Used widely in vector graphics, animation, and font design.\n\n" +
                "         2.Defined mathematically using Bernstein polynomials.\n\n" +
                "         3.Common types are quadratic (3 control points) and cubic (4 control points).\n\n");

        ta.append(" Types of Bézier curve-\n\n");
        ta.append(" 1)Linear Bézier curve:\n");

        ta.append(
                "         A linear Bézier curve is the simplest form of a Bézier curve, representing a straight line segment connecting two end (anchor) points,\n"
                        +
                        "         with no intermediate control points to bend the path, essentially just linear interpolation between the start and end points as a parameter\n"
                        +
                        "         't' goes from 0 to 1.\n");
        ta.append(
                "         Formula: The curve B(t) is calculated as B(t) = (1-t)P0 + tP1, where t ranges from 0 to 1.\n\n");
        ta.append(" 2)Quadratic Bézier curve:\n");
        ta.append(
                "         A quadratic Bézier curve is a parametric curve defined by three points: a start point (P0), a single control point\n"
                        +
                        "         (P1), and an end point (P2). The curve begins at (P0), ends at (P2), and is pulled toward\n"
                        +
                        "         (P1) without necessarily touching it, creating a smooth, U-shaped path. Its shape is determined by the position of \n"
                        +
                        "         the control point, and it can be mathematically represented by the formula (B(t)=(1-t)^{2}P_{0}+2(1-t)tP_{1}+t^{2}P_{2})\n"
                        +
                        "         for (t) in the interval ([0,1]).\n\n");
        ta.append(" 3)Cubic Bézier curve:\n");
        ta.append(
                "         A cubic Bézier curve is a parametric curve defined by four control points: a start point (P0),\n"
                        +
                        "         an end point (P3), and two handle points (P1) and (P2) that control the curve's shape. It is used in \n"
                        +
                        "         computer graphics for smooth, scalable curves, with (P0) and (P3) defining the curve's start and end,\n"
                        +
                        "         while (P1) and (P2) pull the curve towards them but are not necessarily on the path itself.\n\n");
        ta.append(" General Equation of Bézier curve-\n");
        ta.append("         P(t)=sum _{i=0}^{n}PiBi,n(t). where Bi,n(t)=nCi(1-t)^n-i.t^i and Pi is control point.\n\n");
        ta.append("@ You can click on Geometry Button to see the all type of Bézier curve:-\n\n");
        ta.append("@ You can click on Notes Button for Write your notes on Notepad.\n\n");
        ta.setEditable(false);
        ta.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
        ta.setForeground(new Color(240, 240, 240));
        scp = new JScrollPane(ta);
        scp.setBorder(BorderFactory.createEmptyBorder());
        
        add(lp, BorderLayout.WEST);
        add(scp, BorderLayout.CENTER);

        bg.addActionListener(this);
        bn.addActionListener(this);
        exit.addActionListener(this);
        newhome.addActionListener(this);
        login1.addActionListener(this);
        singin.addActionListener(this);
        lo.addActionListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login1) {
            login l = new login();
            System.out.println(login.flag);
            l.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
        if (e.getSource() == singin) {
            signin s = new signin();
            s.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
        if (e.getSource() == lo) {
            JOptionPane.showMessageDialog(null, "Logout succesfull");
            login.flag = false;
            this.dispose();
        }
        if (e.getSource() == exit) {
            this.dispose();
        }
        if (e.getSource() == newhome) {
            x += 20;
            y += 10;
            home h1 = new home();
            h1.setLocation(400 + x, 200 + y);
            h1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
        if (e.getSource() == bg) {
            if (login.flag) {
                newcurve c = new newcurve();
                c.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            } else {
                JOptionPane.showMessageDialog(null, "Plese log in");
            }
        }
        if (e.getSource() == bn) {
            notepad n = new notepad();
            n.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }
    public static void main(String[] args) {
        new home();
    }
}
