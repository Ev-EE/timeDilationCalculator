package GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends GamePanel{
    public JPanel panel1;
    private JButton StartButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;


    public StartPanel()
    {
        add(panel1);
        setPreferredSize(new Dimension(800,200));

        label1.setText("Welcome to my Time Dilation Calculator.");
        label2.setText("Time Dilation is the difference in the time you perceive and time as it is perceived on Earth.");
        label3.setText("Time Dilation is increased through multiple factors; however, this program only focuses on velocity's effect on time.");



        StartButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                actionHasBeenMade();
            }
        });
    }
}
