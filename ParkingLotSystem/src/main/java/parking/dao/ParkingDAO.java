package parking.dao;

import parking.db.DatabaseManager;
import parking.models.Vehicle;

import java.sql.*;
import java.util.*;


public class ParkingDAO {

    public boolean parkVehicle(Vehicle vehicle)
    {
        String sql = "INSERT INTO parking(vehicle_number,vehicle_type) VALUES (?,?)";

        try(Connection conn = DatabaseManager.getConnection();
            PreparedStatement stmt =  conn.prepareStatement(sql)) {

            stmt.setString(1,vehicle.getVehicleNumber());
            stmt.setString(2,vehicle.getVehicleType());

            int rowsInserted = stmt.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
        }
        return false;
    }

    public boolean unparkVehicle(String vehicleNumber)
    {
        String sql = "DELETE FROM parking WHERE vehicle_number = ? ";

        try (Connection conn = DatabaseManager.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1,vehicleNumber);
            int rowsDeleted = stmt.executeUpdate();

            return rowsDeleted >0;

        }
        catch (SQLException e)
        {
            System.out.println("Error "+e.getMessage());
        }
        return false;
    }

    public List<Vehicle> getAllParkedVehicles()
    {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = "SELECT vehicle_number,vehicle_type FROM parking";

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next())
            {
                vehicles.add(new Vehicle(rs.getString("vehicle_number"),rs.getString("vehicle_type")));
            }
        }

        catch (SQLException e)
        {
            System.out.println("Error: "+e.getMessage());
        }
        return vehicles;
    }
}
