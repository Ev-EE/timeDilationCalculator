package GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultPanel extends GamePanel {
    private JPanel panel1;
    private JButton Continue;
    private JButton Exit;
    private JLabel timeDilation;
    private JLabel time;
    private JLabel distance;
    private JLabel totalDistance;
    private JLabel totalTimeDilation;

    public ResultPanel()
    {
        add(panel1);

        Continue.setText("Continue");
        Exit.setText("Exit");

        Continue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                actionHasBeenMade();
            }
        });

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });
    }

    public void changeLabels()
    {
        time.setText("Time relative to Earth: "+super.timeObservedFromEarth+ " seconds");
        timeDilation.setText("Time Dilation: "+super.timeDilation + " seconds");
        distance.setText("Distance: "+super.distance + " miles");
        totalDistance.setText("Total Distance Travelled: "+super.totalDistance+" miles");
        totalTimeDilation.setText("Total Time Dilation: "+super.totalTimeDilation+" seconds");
    }

}
