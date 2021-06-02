package Vehicles;

public class Vehicle {

    protected double MPS;
    protected int ID;
    protected String name;

    public Vehicle(){}

    public double SpeedInMPS()
    {
        return MPS;
    }

    public String toString()
    {
        return name;
    }
}


