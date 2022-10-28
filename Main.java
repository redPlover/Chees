import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

class Main {
    public static boolean whiteTurn = true;
    
  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Chees Menu");
    jFrame.setLayout(new GridBagLayout());
    jFrame.setSize(300, 200);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GridBagConstraints c = new GridBagConstraints();

    JLabel title = new JLabel("Chees");
    title.setText("Chees");
    title.setFont(new Font("Times New Roman", Font.BOLD, 50));
    c.fill = GridBagConstraints.VERTICAL;
    c.weightx = 0.0;
    c.gridwidth = 3;
    c.gridx = 0;
    c.gridy = 0;
    jFrame.add(title, c);

    JLabel options = new JLabel("Black or White?");
    options.setText("Black or White?");
    options.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    c.fill = GridBagConstraints.VERTICAL;
    c.weightx = 0.0;
    c.gridwidth = 3;
    c.gridx = 0;
    c.gridy = 1;
    jFrame.add(options, c);

    JPanel iGotOptions = new JPanel();

    JRadioButton b1 = new JRadioButton();
    b1.setText("White");
    b1.setSelected(true);
    iGotOptions.add(b1);
    JRadioButton b2 = new JRadioButton();
    b2.setText("Black");
    iGotOptions.add(b2);

    c.gridx = 0;
    c.gridy = 2;
    jFrame.add(iGotOptions, c);

    ButtonGroup group = new ButtonGroup();
    group.add(b1);
    group.add(b2);

    JButton start = new JButton();
    start.setText("Start");
    c.fill = GridBagConstraints.VERTICAL;
    c.weightx = 0.5;
    c.gridwidth = 1;
    c.gridx = 0;
    c.gridy = 3;
    jFrame.add(start, c);

    jFrame.setLocationRelativeTo(null);
    jFrame.setResizable(false);
    jFrame.setVisible(true);

    // Button Listener
    start.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (b1.isSelected()) {
                whiteTurn = true;
                Chess game = new Chess();
                try {
                  game.start(true);
                } catch (IOException e1) {
                  e1.printStackTrace();
                }
            } else if (b2.isSelected()) {
                whiteTurn = false;
                Chess game = new Chess();
                try {
                  game.start(false);
                } catch (IOException e1) {
                  e1.printStackTrace();
                }
            }
            jFrame.dispose();
        }
    });
  }
    
    public static void close(int x) {
        System.out.println(x);
        System.exit(0);
    }
}
