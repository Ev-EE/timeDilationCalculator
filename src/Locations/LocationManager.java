package Locations;

public class LocationManager {

    private Location newLocation1, newLocation2, chosenLocation;
    private Location oldLocation = new Atlanta();


    public LocationManager(){}

    public void setChosenLocation(Location l)
    {
        chosenLocation = l;
    }

    public void setNewLocations(){
        do
            {
                newLocation1 = randomLocation();
                newLocation2 = randomLocation();

            }while(newLocation1.ID == newLocation2.ID || oldLocation.ID == newLocation1.ID || oldLocation.ID == newLocation2.ID);
    }

    private void setOldLocation(Location place)
    {
        oldLocation = place;
    }

    private Location randomLocation()
    {
        int randomNum = (int)(Math.random()*6+1);
        switch (randomNum)
        {
            case(1) : return new Atlanta();
            case(2) : return new AlphaCentauri();
            case(3) : return new Brasilia();
            case(4) : return new Mars();
            case(5) : return new NewYork();
            case(6) : return new Paris();
            case(7) : return new Pluto();
        }
        return null;
    }

    public Location getNewLocation1()
    {
        return newLocation1;
    }

    public Location getNewLocation2()
    {
        return newLocation2;
    }

    public Location getOldLocation(){return oldLocation;}

    public double getDistanceBetweenPoints()
    {


        if (oldLocation.isInSpace || chosenLocation.isInSpace)
        {
            double oldLocationZ = oldLocation.z;
            setOldLocation(chosenLocation);

            return Math.abs(chosenLocation.z - oldLocationZ);
        }


        double dLat = Math.toRadians(chosenLocation.x - oldLocation.x);
        double dLon = Math.toRadians(chosenLocation.y - oldLocation.y);

        // convert to radians
        double lat1 = Math.toRadians(oldLocation.x);
        double lat2 = Math.toRadians(chosenLocation.x);

        // apply formula
        double num = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(num));


        setOldLocation(chosenLocation);

        return (rad * c)/1.609;



    }

}
