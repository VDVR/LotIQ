package parking.services;

import parking.dao.ParkingDAO;
import parking.models.Vehicle;

import java.util.List;

public class ParkingService {

    private final ParkingDAO parkingDAO = new ParkingDAO();

    public void parkVehicle(String vehicleNumber,String vehicleType)
    {
        Vehicle vehicle = new Vehicle(vehicleNumber,vehicleType);

        if(parkingDAO.parkVehicle(vehicle))
        {
            System.out.println("✅ Vehicle parked successfully.");
        }
        else
        {
            System.out.println("❌ Failed to park the vehicle.");
        }
    }

    public void unparkVehicle(String vehicleNumber)
    {
        if(parkingDAO.unparkVehicle(vehicleNumber))
        {
            System.out.println("✅ Vehicle unparked successfully.");
        }
        else
        {
            System.out.println("❌ Vehicle not found.");
        }
    }

    public void showAllParkedVehicle()
    {
        List<Vehicle> vehicles = parkingDAO.getAllParkedVehicles();

        if(vehicles.isEmpty())
        {
            System.out.println("🚗 No vehicles are parked.");
        }
        else
        {
            System.out.println("--- Parked Vehicles ---");
            for(Vehicle v : vehicles)
            {
                System.out.println("Vehicle: " + v.getVehicleNumber() + " | Type: " + v.getVehicleType());
            }
        }
    }
}
