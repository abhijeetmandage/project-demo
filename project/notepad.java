import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import javax.swing.text.*;
public class notepad extends JFrame implements ActionListener {
    JFileChooser fc = new JFileChooser();
    public static int size = 16;
    public static int x = 20;
    public static int y = 10;
    public static int zoomsize = 20;
    JFrame j1;
    JTextPane p;
    StyledDocument d;
    JMenuBar bar;
    JMenu file, edit, view, effect, FontSize, FontColor;
    JMenuItem newtab, save, saveas, open, exit, cut, copy, paste, zoom, zoomout, B, I, U, Increse, Decrese, red, green,
            white, bluew, black, clear;
    notepad() {
        setTitle("Notepad");
        setSize(800, 400);
        setLocation(400, 200);
        setLayout(new BorderLayout());
        bar = new JMenuBar();

        p = new JTextPane();
        p.setFont(new Font("Arial", Font.PLAIN, 18));
        d = p.getStyledDocument();

        JScrollPane scroll = new JScrollPane(p);
        add(scroll, BorderLayout.CENTER);

        file = new JMenu("File");
        edit = new JMenu("Edit");
        view = new JMenu("Veiw");
        effect = new JMenu("FontEffect");
        FontSize = new JMenu("FontSize");
        FontColor = new JMenu("FontColor");

        newtab = new JMenuItem("New tab");
        save = new JMenuItem("Save");
        saveas = new JMenuItem("Save as");
        open = new JMenuItem("Open");
        exit = new JMenuItem("Exit");
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        zoom = new JMenuItem("Zoom");
        B = new JMenuItem("Bold");
        I = new JMenuItem("Italic");
        U = new JMenuItem("Uderline");
        Increse = new JMenuItem("Increse");
        Decrese = new JMenuItem("Decrese");
        red = new JMenuItem("Red");
        green = new JMenuItem("Green");
        white = new JMenuItem("White");
        bluew = new JMenuItem("Bluew");
        black = new JMenuItem("Black");
        clear = new JMenuItem("Clear");
        zoomout = new JMenuItem("ZoomOut");

        setJMenuBar(bar);
        bar.add(Box.createHorizontalStrut(40));
        bar.add(file);
        bar.add(Box.createHorizontalStrut(25));
        bar.add(edit);
        bar.add(Box.createHorizontalStrut(25));
        bar.add(view);
        bar.add(Box.createHorizontalStrut(25));
        bar.add(effect);
        bar.add(Box.createHorizontalStrut(25));
        bar.add(FontSize);
        bar.add(Box.createHorizontalStrut(25));
        bar.add(FontColor);

        file.add(newtab);
        file.add(Box.createVerticalStrut(10));
        file.add(save);
        file.add(Box.createVerticalStrut(10));
        file.add(saveas);
        file.add(Box.createVerticalStrut(10));
        file.add(open);
        file.add(Box.createVerticalStrut(10));
        file.add(new JSeparator());
        file.add(exit);

        edit.add(cut);
        edit.add(Box.createVerticalStrut(8));
        edit.add(copy);
        edit.add(Box.createVerticalStrut(8));
        edit.add(new JSeparator());
        edit.add(paste);

        view.add(zoom);
        view.add(new JSeparator());
        view.add(zoomout);

        effect.add(B);
        effect.add(I);
        effect.add(U);
        effect.add(new JSeparator());
        effect.add(clear);

        FontSize.add(Increse);
        FontSize.add(Decrese);

        FontColor.add(red);
        FontColor.add(white);
        FontColor.add(green);
        FontColor.add(bluew);
        FontColor.add(new JSeparator());
        FontColor.add(black);

        B.addActionListener(this);
        I.addActionListener(this);
        U.addActionListener(this);
        Increse.addActionListener(this);
        Decrese.addActionListener(this);
        red.addActionListener(this);
        white.addActionListener(this);
        green.addActionListener(this);
        bluew.addActionListener(this);
        black.addActionListener(this);
        clear.addActionListener(this);
        saveas.addActionListener(this);
        open.addActionListener(this);
        newtab.addActionListener(this);
        exit.addActionListener(this);
        save.addActionListener(this);
        zoom.addActionListener(this);
        zoomout.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut) {
            p.cut();
        }
        if (e.getSource() == copy) {
            p.copy();
        }
        if (e.getSource() == paste) {
            p.paste();
        }
        if (e.getSource() == zoom) {
            zoomsize += 2;
            p.setFont(new Font("Arial", Font.PLAIN, zoomsize));
        }
        if (e.getSource() == zoomout) {
            zoomsize -= 2;
            p.setFont(new Font("Arial", Font.PLAIN, zoomsize));
        }
        if (e.getSource() == newtab) {
            x += 20;
            y += 10;
            notepad pa = new notepad();
            pa.setLocation(400 + x, 200 + y);
            pa.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
        if (e.getSource() == save) {
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = fc.getSelectedFile();

                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(p.getText().getBytes()); // p = JTextArea / JTextPane
                    fos.close();

                    JOptionPane.showMessageDialog(this, "Saved!");

                } catch (Exception e1) {
                    System.out.println(e1.getMessage());

                }
            }
        }

        if (e.getSource() == saveas) {
            saveAs();
        }
        if (e.getSource() == exit) {
            this.dispose();
        }
        if (e.getSource() == open) {
            openfile();
        }
        if (e.getSource() == B) {
            makeBold();
        }
        if (e.getSource() == I) {
            makeitalik();
        }
        if (e.getSource() == U) {
            makeuder();
        }
        if (e.getSource() == Increse) {
            fontsizein();
        }
        if (e.getSource() == Decrese) {
            fontsizede();
        }
        if (e.getSource() == red) {
            makeRed();
        }
        if (e.getSource() == white) {
            makeWhite();
        }
        if (e.getSource() == green) {
            makegreen();
        }
        if (e.getSource() == bluew) {
            makebluew();
        }
        if (e.getSource() == black) {
            makeblack();
        }
        if (e.getSource() == clear) {
            clearStyles();
        }
    }
    public void makeblack() {
        int s = p.getSelectionStart();
        int end = p.getSelectionEnd();
        d = p.getStyledDocument();
        Style ss5 = p.addStyle("black", null);
        StyleConstants.setForeground(ss5, Color.BLACK);
        d.setCharacterAttributes(s, end, ss5, true);
    }
    public void makegreen() {
        int s = p.getSelectionStart();
        int end = p.getSelectionEnd();
        d = p.getStyledDocument();
        Style ss3 = p.addStyle("green", null);
        StyleConstants.setForeground(ss3, Color.GREEN);
        d.setCharacterAttributes(s, end, ss3, true);
    }
    public void makebluew() {
        int s = p.getSelectionStart();
        int end = p.getSelectionEnd();
        d = p.getStyledDocument();
        Style ss4 = p.addStyle("bluew", null);
        StyleConstants.setForeground(ss4, Color.BLUE);
        d.setCharacterAttributes(s, end, ss4, true);
    }
    public void makeRed() {
        int s = p.getSelectionStart();
        int end = p.getSelectionEnd();
        d = p.getStyledDocument();
        Style ss = p.addStyle("red", null);
        StyleConstants.setForeground(ss, Color.RED);
        d.setCharacterAttributes(s, end, ss, true);
    }
    public void makeWhite() {
        int s = p.getSelectionStart();
        int end = p.getSelectionEnd();
        d = p.getStyledDocument();
        Style ss1 = p.addStyle("white", null);
        StyleConstants.setForeground(ss1, Color.WHITE);
        d.setCharacterAttributes(s, end, ss1, true);
    }
    public void makeBold() {
        int s = p.getSelectionStart();
        int end = p.getSelectionEnd();
        d = p.getStyledDocument();
        Style s1 = p.addStyle("BoldStyle", null);// - creates a new style named boldstyle,defin style object
        StyleConstants.setBold(s1, true);
        d.setCharacterAttributes(s, end, s1, true);
    }
    public void makeitalik() {
        int s = p.getSelectionStart();
        int end = p.getSelectionEnd();
        d = p.getStyledDocument();
        Style s2 = p.addStyle("italic", null);
        StyleConstants.setItalic(s2, true);
        d.setCharacterAttributes(s, end, s2, true);
    }
    public void makeuder() {
        int s = p.getSelectionStart();
        int end = p.getSelectionEnd();
        d = p.getStyledDocument();
        Style s3 = p.addStyle("underline", null);
        StyleConstants.setUnderline(s3, true);
        d.setCharacterAttributes(s, end, s3, true);
    }
    public void fontsizein() {
        int s = p.getSelectionStart();
        int end = p.getSelectionEnd();
        d = p.getStyledDocument();
        size += 2;
        Style s4 = p.addStyle("fondincrese", null);
        StyleConstants.setFontSize(s4, size);
        d.setCharacterAttributes(s, end - s, s4, true);
    }
    public void fontsizede() {
        int s = p.getSelectionStart();
        int end = p.getSelectionEnd();
        d = p.getStyledDocument();
        size -= 2;
        Style s5 = p.addStyle("fontdecrese", null);
        StyleConstants.setFontSize(s5, size);
        d.setCharacterAttributes(s, end - s, s5, true);
    }
    public void clearStyles() {
        int s = p.getSelectionStart();
        int e = p.getSelectionEnd();
        d = p.getStyledDocument();
        Style n = p.addStyle("NormalStyle", null);
        StyleConstants.setBold(n, false);
        StyleConstants.setItalic(n, false);
        StyleConstants.setUnderline(n, false);
        d.setCharacterAttributes(s, e, n, true);
    }
    public void saveAs() {
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileWriter fw = new FileWriter(fc.getSelectedFile() + ".txt");
                fw.write(p.getText());
                fw.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void openfile() {
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream i = new FileInputStream(fc.getSelectedFile());
                byte[] data = i.readAllBytes();
                String ch = new String(data);
                p.setText(ch);
                i.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        new notepad();
    }
}
