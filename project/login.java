import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class login extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField t1;
    JButton b1, b2;
    JPasswordField p1;
    public static boolean flag = false;
    login() {
        setTitle("Login");
        setSize(400, 400);
        setLocation(500, 200);
        l1 = new JLabel("Enter E-mail id:");
        l2 = new JLabel("Enter password:");
        t1 = new JTextField();
        p1 = new JPasswordField();
        b1 = new JButton("Log in");
        b2 = new JButton("Reset");
        l1.setBounds(50, 50, 150, 30);
        t1.setBounds(200, 50, 150, 30);
        l2.setBounds(50, 100, 150, 30);
        p1.setBounds(200, 100, 150, 30);
        b1.setBounds(80, 160, 100, 30);
        b2.setBounds(200, 160, 100, 30);

        add(l1);
        add(t1);
        add(l2);
        add(p1);
        add(b1);
        add(b2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String s = t1.getText();
            String p = new String(p1.getPassword());
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver loaded successfully!");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homedb", "root",
                        "abhijeet8482");
                Statement st = con.createStatement();
                ResultSet rt = st.executeQuery("select * from user");
                boolean found = false;
                while (rt.next()) {
                    String email = rt.getString("email_id");
                    String pass = rt.getString("password");
                    if (s.equals(email) && p.equals(pass)) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    JOptionPane.showMessageDialog(null, "login succesfull");
                    login.flag = true;
                } else {
                    JOptionPane.showMessageDialog(null, "login faild");
                }
                con.close();
            } catch (ClassNotFoundException e1) {
                System.out.println("MySQL JDBC Driver not found." + e1.getMessage());
            } catch (SQLException e2) {
                System.out.println("Connection failed." + e2.getMessage());
            }
        }
        if (e.getSource() == b2) {
            t1.setText("");
            p1.setText("");
        }
    }
    public static void main(String[] args) {
        new login();
    }
}
