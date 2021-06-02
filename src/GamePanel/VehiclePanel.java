package GamePanel;

import Vehicles.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehiclePanel extends GamePanel{
    private JButton button1;
    private JButton button2;
    private JPanel panel;
    private JLabel label;

    public VehiclePanel()
    {
        add(panel);

        label.setText("Choose Your Vehicle");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChosenVehicle(vehicleOptions[0]);

                actionHasBeenMade();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChosenVehicle(vehicleOptions[1]);

                actionHasBeenMade();
            }
        });
    }

    public void changeButtons()
    {
        button1.setText(vehicleOptions[0].toString());
        button2.setText(vehicleOptions[1].toString());
    }



}
