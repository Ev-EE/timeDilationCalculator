package GamePanel;

import Locations.Atlanta;
import Locations.Location;
import Locations.LocationManager;
import Util.Calculator;
import Vehicles.Vehicle;
import Vehicles.VehicleManager;

public class GUI {


    GamePanel nextGamePanel = new StartPanel();
    GamePanel currentGamePanel;
    boolean running = true;

    private double distanceBetweenPoints, timeDilation, totalDistance=0, totalTimeDilation =0;

    private VehicleManager vehicleManager = new VehicleManager();
    private LocationManager locationManager = new LocationManager();

    private Vehicle chosenVehicle;
    private Location chosenLocation;
    private Calculator calculator = new Calculator();




    public GUI(){}

    public GamePanel run()
    {
        if (nextGamePanel instanceof VehiclePanel)
        {
            currentGamePanel = nextGamePanel;
            nextGamePanel = new LocationPanel();
        }
        else if (nextGamePanel instanceof LocationPanel)
        {
            currentGamePanel = nextGamePanel;
            nextGamePanel = new ResultPanel();
        }
        else if (nextGamePanel instanceof ResultPanel)
        {
            currentGamePanel = nextGamePanel;
            nextGamePanel = new VehiclePanel();
        }

        else if (nextGamePanel instanceof StartPanel)
        {
            currentGamePanel = nextGamePanel;
            nextGamePanel = new VehiclePanel();

        }

        running = false;
        return currentGamePanel;

        //return nextGamePanel;
    }


    public void update()
    {
        giveInfoToGamePanel();
        getInfoFromGamePanel();

        currentGamePanel.close();
        nextGamePanel.open();
        letRun();
    }


    public void giveInfoToGamePanel()
    {
        if (currentGamePanel instanceof VehiclePanel)
        {
            vehicleManager.addVehicles(false);
            currentGamePanel.setVehicleOptions(vehicleManager.getVehicle1(),vehicleManager.getVehicle2());
            ((VehiclePanel) currentGamePanel).changeButtons();

        }

        else if (currentGamePanel instanceof LocationPanel)
        {
            currentGamePanel.setCurrentLocation(locationManager.getOldLocation());
            locationManager.setNewLocations();
            currentGamePanel.setLocationOptions(locationManager.getNewLocation1(), locationManager.getNewLocation2());
            ((LocationPanel) currentGamePanel).changeComponents();
        }

        else if (currentGamePanel instanceof ResultPanel)
        {

            locationManager.setChosenLocation(chosenLocation);


            giveInfoToCalculator();

            timeDilation = calculator.calculateTimeDilation();
            totalTimeDilation += timeDilation;

            currentGamePanel.setTotalDistance(totalDistance);
            currentGamePanel.setDistance(distanceBetweenPoints);
            currentGamePanel.setTimeDilation(timeDilation);
            currentGamePanel.setTimeObservedFromEarth(calculator.getTimeOnEarth());
            currentGamePanel.setTotalTimeDilation(totalTimeDilation);

            ((ResultPanel)currentGamePanel).changeLabels();
        }
    }

    private void getInfoFromGamePanel()
    {

        waitForUserAction();

        if (currentGamePanel instanceof VehiclePanel)
        {
            chosenVehicle = currentGamePanel.getChosenVehicle();
        }

        else if (currentGamePanel instanceof LocationPanel)
        {
            chosenLocation = currentGamePanel.getChosenLocation();
        }

    }

    private void waitForUserAction()
    {
        while(currentGamePanel.isWaitingForAction())
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }
        }
    }

    private void giveInfoToCalculator()
    {
        calculator.setSpeedOfMovingObject(chosenVehicle.SpeedInMPS());

        distanceBetweenPoints = locationManager.getDistanceBetweenPoints();
        totalDistance += distanceBetweenPoints;

        calculator.setTimeOnEarth(distanceBetweenPoints);
    }




    public boolean isRunning()
    {
      return running;
    }


    public void letRun()
    {
        running = true;
    }

}