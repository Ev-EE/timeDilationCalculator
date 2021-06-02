package GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LocationPanel extends GamePanel{
    private JButton button1;
    private JButton button2;
    private JPanel panel;
    private JLabel label;
    private JLabel currentLocation;

    public LocationPanel()
    {
        add(panel);

        label.setText("Choose Your Location");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChosenLocation(locationOptions[0]);

                actionHasBeenMade();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChosenLocation(locationOptions[1]);

                actionHasBeenMade();
            }
        });

    }

    public void changeComponents()
    {
        button1.setText(locationOptions[0].toString());
        button2.setText(locationOptions[1].toString());

        currentLocation.setText("Travelling From: "+super.currentLocation.toString());
    }
}
