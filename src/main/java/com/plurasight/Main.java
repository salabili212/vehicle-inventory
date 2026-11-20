package com.plurasight;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[20];

        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        int vehicleCount = 6;

        String promptUser = """
                What do you want to do?
                1 - List all vehicles
                2 - Search by make/model
                3 - Search by price range
                4 - Search by color
                5 - Add a vehicle
                6 - Quit
                Enter your command:
                """;

        int command;
        do {
            System.out.println(promptUser);
            command = scanner.nextInt();
            scanner.nextLine(); // Clear the Enter after the menu number.

            switch (command) {
                case 1 -> listAllVehicles(vehicles);

                case 2 -> {
                    System.out.print("Please enter the make or model: ");
                    String model = scanner.nextLine().trim();
                    searchBYMake(vehicles, model);
                }

                case 3 -> {
                    System.out.print("Enter the lowest price: ");
                    double minPrice = scanner.nextDouble();

                    System.out.print("Enter the highest price: ");
                    double maxPrice = scanner.nextDouble();

                    serachByPriceRange(vehicles, minPrice, maxPrice);
                }

                case 4 -> {
                    System.out.print("Enter the color: ");
                    String color = scanner.nextLine().trim();
                    searchByColor(vehicles, color);
                }

                case 5 -> vehicleCount = addVehicle(vehicles, scanner, vehicleCount);

                case 6 -> System.out.println("Thank you!");

                default -> System.out.println("Please enter a number from 1 to 6.");
            }
        } while (command != 6);
    }

    public static void listAllVehicles(Vehicle[] vehicles) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                break;
            }

            displayVehicle(vehicles[i], i + 1);
        }
    }

    public static void searchBYMake(Vehicle[] vehicles, String model) {
        String search = model.toLowerCase(Locale.ROOT);

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                break;
            }

            String makeModel = vehicles[i].getMakeModel().toLowerCase(Locale.ROOT);
            if (makeModel.contains(search)) {
                displayVehicle(vehicles[i], i + 1);
            }
        }
    }

    public static void serachByPriceRange(Vehicle[] vehicles, double minPrice, double maxPrice) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                break;
            }

            double price = vehicles[i].getPrice();
            if (price >= minPrice && price <= maxPrice) {
                displayVehicle(vehicles[i], i + 1);
            }
        }
    }

    public static void searchByColor(Vehicle[] vehicles, String color) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                break;
            }

            if (color.equalsIgnoreCase(vehicles[i].getColor())) {
                displayVehicle(vehicles[i], i + 1);
            }
        }
    }

    public static int addVehicle(Vehicle[] vehicles, Scanner scanner, int vehicleCount) {
        if (vehicleCount == vehicles.length) {
            System.out.println("The inventory is full.");
            return vehicleCount;
        }

        System.out.print("Enter vehicleId: ");
        long vehicleId = scanner.nextLong();
        scanner.nextLine(); // Clear the Enter after the ID.

        System.out.print("Enter makeModel: ");
        String makeModel = scanner.nextLine().trim();

        System.out.print("Enter color: ");
        String color = scanner.nextLine().trim();

        System.out.print("Enter odometerReading: ");
        int odometerReading = scanner.nextInt();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        vehicles[vehicleCount] = new Vehicle(vehicleId, makeModel, color,
                odometerReading, price);

        System.out.println("Vehicle added.");
        return vehicleCount + 1;
    }

    private static void displayVehicle(Vehicle vehicle, int carNumber) {
        System.out.println("Car number: " + carNumber);
        System.out.println("vehicleId: " + vehicle.getVehicleId());
        System.out.println("makeModel: " + vehicle.getMakeModel());
        System.out.println("color: " + vehicle.getColor());
        System.out.println("odometerReading: " + vehicle.getOdometerReading());
        System.out.println("price: $" + vehicle.getPrice());
    }
}