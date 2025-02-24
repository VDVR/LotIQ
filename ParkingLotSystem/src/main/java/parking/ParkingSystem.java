package parking;

import parking.services.ParkingService;

import java.util.Scanner;

public class ParkingSystem {

    public static void main(String[] args) {

        ParkingService parkingService = new ParkingService();

        Scanner sc = new Scanner(System.in);

        while (true)
        {
            System.out.println("\n--- Parking Lot System ---");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Unpark Vehicle");
            System.out.println("3. View Parked Vehicles");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    System.out.println("Enter The Vehicle Number: ");
                    String vehicleNumber = sc.nextLine();
                    System.out.println("Enter The Vehicle Type(CAR/BIKE/TRUCK)");
                    String vehicleType = sc.nextLine();
                    parkingService.parkVehicle(vehicleNumber,vehicleType);
                    break;
                case 2:
                    System.out.println("Enter The Vehicle NUmber: ");
                    String vehicletoUnpark = sc.nextLine();
                    parkingService.unparkVehicle(vehicletoUnpark);
                    break;
                case 3:
                    parkingService.showAllParkedVehicle();
                    break;
                case 4:
                    System.out.println("Exiting... 🚪");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
