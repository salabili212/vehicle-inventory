package com.plurasight;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[2];

        //First car
        vehicles[0].setVehicleId(101121);
        vehicles[0].setMakeModel("Toyota Camry");
        vehicles[0].setColor("Blue");
        vehicles[0].setOdometerReading(60000);
        vehicles[0].setPrice(11000);

        //Second Car
        vehicles[1].setVehicleId(1013428);
        vehicles[1].setMakeModel("Ford Explorer");
        vehicles[1].setColor("Red");
        vehicles[1].setOdometerReading(70000);
        vehicles[1].setPrice(9000);


        String promptUser = """
        What do you want to do?
        1 - List all vehicles
        2 - Search by model
        3 - Search by price range
        4 - Search by color
        5 - Add a vehicle
        6 - Quit
        Enter your command:
        """;

        System.out.println(promptUser);
        int command = scanner.nextInt();

        switch (command){
            case 1 ->{
                listAllVehicles(vehicles);
            }
            case 2 ->{
                System.out.println("Please enter the model.");
                String model = scanner.next();
                searchBYMake(vehicles , model);
            }
            case 3 ->{
                serachByPriceRange();
            }

            case 4 ->{
                searchByColor();
            }

            case 5 ->{
                addVehicle();
            }
            default -> {
                System.out.println("Thank........:)");
            }
        }


    }
    public static void listAllVehicles(Vehicle[] vehicles){
        for(int i = 0; i < vehicles.length; i++){
            System.out.println("vehicleId: "+vehicles[i].getVehicleId());
            System.out.println("makeModel: "+vehicles[i].getMakeModel());
            System.out.println("color: "+vehicles[i].getColor());
            System.out.println("odometerReading: "+vehicles[i].getOdometerReading());
            System.out.println("price: $"+vehicles[i].getPrice());

            System.out.println("Car number: " + (i + 1));

        }
    }

    public static void searchBYMake(Vehicle[] vehicles, String model){
        for(int i = 0; i < vehicles.length; i++){
           if(model.equalsIgnoreCase(vehicles[i].makeModel)){
               System.out.println("Car Number: " + (i + 1));
               System.out.println("vehicleId: " + vehicles[i].getVehicleId());
               System.out.println("makeModel: "+vehicles[i].getMakeModel());
               System.out.println("color: "+vehicles[i].getColor());
               System.out.println("odometerReading: "+vehicles[i].getOdometerReading());
               System.out.println("price: $"+vehicles[i].getPrice());
           }
        }
    }

}
