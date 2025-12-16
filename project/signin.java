import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class signin extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField t1;
    JButton b1, b2;
    JPasswordField p1;
    signin() {
        setTitle("signin");
        setSize(400, 400);
        setLocation(500, 200);
        l1 = new JLabel("Enter E-mail id:");
        l2 = new JLabel("Enter password:");
        t1 = new JTextField();
        p1 = new JPasswordField();
        b1 = new JButton("Sign in");
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
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver loaded successfully!");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homedb", "root",
                        "abhijeet8482");
                PreparedStatement st = con.prepareStatement("INSERT INTO user (email_id, password) VALUES (?, ?)");
                String email = t1.getText();
                char[] pwdChars = p1.getPassword();
                String pwdString = new String(pwdChars);
                int pass = Integer.parseInt(pwdString);
                st.setString(1, email);
                st.setInt(2, pass);
                int row = st.executeUpdate();
                if (row > 0) {
                    JOptionPane.showMessageDialog(null, "Details saved successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to save details.");
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
        new signin();
    }

}
