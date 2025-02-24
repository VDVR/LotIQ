package parking.models;

public class Vehicle {

    private String vehicleNumber;
    private String vehicleType;

    public Vehicle(String vehicleNumber, String vehicleType)
    {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType()
    {
        return vehicleType;
    }

    public String getVehicleNumber()
    {
        return vehicleNumber;
    }
}
