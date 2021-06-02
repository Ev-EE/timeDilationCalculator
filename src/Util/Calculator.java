package Util;

public class Calculator {

    private double timeObserved,timeOnEarth, speedOfMovingObject;
    private double SPEED_OF_LIGHT = 186282;

    public Calculator(){}

    public void setSpeedOfMovingObject(double mps)
    {
        speedOfMovingObject = mps/SPEED_OF_LIGHT;
    }

    public void setTimeOnEarth(double distance)
    {
        timeObserved = distance/speedOfMovingObject;
    }

    public double getTimeOnEarth()
    {
        return timeOnEarth;
    }

    public double getTimeObserved(){return timeObserved;}

    public double calculateTimeDilation()
    {
        timeOnEarth = timeObserved/Math.sqrt(1-Math.pow(speedOfMovingObject,2));
        return timeOnEarth - timeObserved;
    }


}
