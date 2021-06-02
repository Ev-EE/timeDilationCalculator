package Vehicles;

public class VehicleManager {

    private Vehicle vehicle1,vehicle2;

    public VehicleManager(){}

    public void addVehicles(boolean chaosMode)
    {
        if (!chaosMode)
        {
            do
                {
                    vehicle1 = randomVehicle();
                    vehicle2 = randomVehicle();

                } while(!isImmediateVehicle() || vehicle1.MPS == vehicle2.MPS);
        }
        else
            {
                do
                    {
                        vehicle1 = randomVehicle();
                        vehicle2 = randomVehicle();
                    } while (vehicle1.MPS == vehicle2.MPS);
            }
    }


    private Vehicle randomVehicle()
    {
        int randomNum = (int)(Math.random()*8+1);

        switch(randomNum)
        {
            case (1) : return new Bicycle();
            case (2) : return new Bugatti();
            case (3) : return new SpaceStation();
            case (4) : return new Voyager();
            case (5) : return new BulletTrain();
            case (6) : return new BlackBird();
            case (7) : return new SmartCar();
            case (8) : return new ApolloTen();
        }
        return null;
    }

    private boolean isImmediateVehicle()
    {
        return (Math.abs(vehicle1.ID - vehicle2.ID) == 1);
    }

    public Vehicle getVehicle1() {
        return vehicle1;
    }

    public Vehicle getVehicle2() {
        return vehicle2;
    }
}
