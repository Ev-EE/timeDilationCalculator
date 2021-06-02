package GamePanel;

import Locations.Location;
import Vehicles.Vehicle;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private boolean waitingForAction = true;

    protected Location[] locationOptions = new Location[2];
    protected Vehicle[] vehicleOptions = new Vehicle[2];
    protected double timeDilation, timeObservedFromEarth, distance, totalDistance, totalTimeDilation;


    public Location chosenLocation, currentLocation;

    public Vehicle chosenVehicle;


    public GamePanel()
    {
        setPreferredSize(new Dimension(500,200));
        setFocusable(true);
        requestFocus();
    }

    public void close()
    {
        setVisible(false);
    }

    public void open()
    {
        setVisible(true);
    }


    public void actionHasBeenMade()
    {
        waitingForAction = false;
    }

    // setters

    public void setLocationOptions(Location location1, Location location2)
    {
        locationOptions[0] = location1;
        locationOptions[1] = location2;
    }

    public void setCurrentLocation(Location location)
    {
        currentLocation = location;
    }

    public void setVehicleOptions(Vehicle vehicle1, Vehicle vehicle2)
    {
        vehicleOptions[0] = vehicle1;
        vehicleOptions[1] = vehicle2;
    }

    public void setTimeDilation(double TD)
    {
        timeDilation = TD;
    }

    public void setTimeObservedFromEarth(double T)
    {
        timeObservedFromEarth = T;
    }

    public void setDistance(double dis)
    {
        distance = dis;
    }

    public void setTotalDistance(double totalDis)
    {
        totalDistance = totalDis;
    }

    public void setTotalTimeDilation(double totalTD)
    {
        totalTimeDilation = totalTD;
    }

    protected void setChosenVehicle(Vehicle v)
    {
        chosenVehicle = v;
    }

    protected void setChosenLocation(Location l)
    {
        chosenLocation = l;
    }

    // getters

    public boolean isWaitingForAction(){return waitingForAction;}

    public Location getChosenLocation(){return chosenLocation;}

    public Vehicle getChosenVehicle(){return chosenVehicle;}

}
