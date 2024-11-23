/*
Rawan Fares Abo Alrous
ID: 1231043
lab 1 lecture 1
Mohammad Helal
*/

import java.util.Scanner;
public class Driver {
    static Scanner sc = new Scanner(System.in);
    static public Vehicle[] availableVehicles = {
            new Vehicle("Car", "ABC123", "Toyota", 50.0, true),
            new Vehicle("Bike", "DEF456", "Honda", 20.0, true),
            new Vehicle("Truck", "GHI789", "Ford", 80.0, true),
            new Vehicle("Car", "JKL012", "Hyundai", 55.0, true),
            new Vehicle("Bike", "MNO345", "Yamaha", 25.0, true)
    };
    public static Customer findCusrtomerById(Customer[] customers, int customerId) {
        boolean flag = false;
        for (Customer c : customers) {
            if (c.getId() == customerId) {
                flag = true;
                return c;
            }
        }
        return null;
    }
    public static Vehicle findVehicleByRegestration(Vehicle[] availableVehicles, String regestration) {
        boolean flag = false;
        for (Vehicle vehicle : availableVehicles) {
            if (vehicle.getRegistrationNumber().equals(regestration)) {
                flag = true;
                return vehicle;
            }
        }
        return null;
    }
    public static void displayVehicleByPrice(Vehicle[] vehicles) {//printing vehicles in ascending order
        for (int i = 0; i < vehicles.length - 1; i++) {
            for (int j = 1 + i; j < vehicles.length; j++)
                if (vehicles[j].getRentalRatePerDay() < vehicles[i].getRentalRatePerDay()) {
                    Vehicle temp = vehicles[i];
                    vehicles[i] = vehicles[j];
                    vehicles[j] = temp;
                }
        }
        isAvailableVehicles(vehicles);
    }
    public static void isAvailableVehicles(Vehicle[] availableVehicles) {//method to print Available Vehicles
        System.out.println("Available vehicles for rental:");
        int index=0;
        for (int i = 0; i < availableVehicles.length; i++) {
            if(availableVehicles[i].getAvailable()){
                System.out.println((index + 1) + ". " + availableVehicles[i].getType() + " (Registration: " + availableVehicles[i].getRegistrationNumber() +
                        "), " + availableVehicles[i].getBrand() + " - $" + availableVehicles[i].getRentalRatePerDay() + "/day");
                index++;
            }
        }
        if (availableVehicles.length==0)
            System.out.println("There is no available vehicle to rent :) ");
    }
    public static Vehicle findVehicles(Vehicle[] vehicles, String regestration, int index) { //method to find the vehicle
        Vehicle foundVehicle = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getRegistrationNumber().equals(regestration)) {
                foundVehicle = vehicle;
                break;
            }
        }
        while (foundVehicle == null) {
            System.out.println("Vehicle not found. please enter a valid regestration number. ");
            System.out.print("Enter regestration number of vehicle " + (index + 1) + " to rent: ");
            regestration = sc.next();
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getRegistrationNumber().equals(regestration)) {
                    foundVehicle = vehicle;
                    break;
                }
            }
        }
        return foundVehicle;
    }
    public static void displayVehicleByType(Vehicle[] vehicles){
        for (int i = 0; i < vehicles.length - 1; i++) {
            for (int j = 1 + i; j < vehicles.length; j++)
                if (vehicles[j].getType().compareTo(vehicles[i].getType())<0) {
                    Vehicle temp = vehicles[i];
                    vehicles[i] = vehicles[j];
                    vehicles[j] = temp;
                }
        }
        isAvailableVehicles(vehicles);

    }
    public static int findIndex(Vehicle[] vehicles, String regestration) { //method to find the vehicle
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i].getRegistrationNumber().equals(regestration))
                return i;
        }
        return -1;
    }
    public static Vehicle checkAvailability(Vehicle[] vehicles, Vehicle v, String regestration, int index) {
        if (v.getAvailable()) {
            return v;
        }
        while (!v.getAvailable()) {
            System.out.println("Vehicle not available. please choose another. ");
            System.out.print("Enter regestration number of vehicle " + (index + 1) + " to rent: ");
            regestration = sc.next();
            //check if the new vehicle existed
            v = findVehicles(vehicles, regestration, index);
            if (v.getAvailable()) {
                return v;
            }
        }
        return v;
    }
    public static void main(String[] args) {
        String name1, name2, licenseNumber, name;
        int id, numberOfVehiclesToRent;
        Vehicle rentedVehicle;
        System.out.println("Enter the number of customers: ");
        int numberOfCustomers = sc.nextInt();  //scanning the number of customers
        Customer[] customers = new Customer[numberOfCustomers]; //creating an array of customers with the entered size
        for (int i = 0; i < customers.length; i++) {
            System.out.println("Enter details for customer " + (i + 1) + ":");
            System.out.print("Enter name: ");
            name1 = sc.next();
            name2 = sc.next();
            name = name1 +" "+ name2;
            System.out.print("Enter ID: ");
            id = sc.nextInt();
            System.out.print("Enter License number: ");
            licenseNumber = sc.next();
            System.out.print("Enter the maximum number of vehicles can rent by this customer: ");
            int maxNumber = sc.nextInt();
            do {
                System.out.print("Enter the number of vehicles to rent now: ");
                numberOfVehiclesToRent = sc.nextInt();
            } while ((numberOfVehiclesToRent > availableVehicles.length));
            isAvailableVehicles(availableVehicles);
            customers[i] = new Customer(name, id, licenseNumber, maxNumber);
            for (int j = 0; j < numberOfVehiclesToRent; j++) {
                System.out.print("Enter registration number of vehicle " + (j + 1) + " to rent: ");
                System.out.print(" Or enter \"exit\" to stop renting : ");
                String registrationNumber = sc.next();
                if (customers[i].getNumberOfCurrentRented() >= maxNumber || registrationNumber.equals("exit")) {
                    System.out.println("Rental process ended by customer " + (i + 1));
                    break;
                } else {
                    Vehicle v = findVehicles(availableVehicles, registrationNumber, j);
                    rentedVehicle = checkAvailability(availableVehicles, v, registrationNumber, j);
                }
                System.out.print("Enter Rental Days: ");
                int days = sc.nextInt();
                customers[i].rentVehicle(rentedVehicle, days);
                availableVehicles[findIndex(availableVehicles, rentedVehicle.getRegistrationNumber())].setAvailable(false);
            }
        }
        int choice;
        do{
            System.out.println("\n\nMain Menu:\n1: Print Customer Information.\n2:Display Total Rental Cost for a Customer.\n" +
                    "3:Count Rented Vehicles by Type.\n4:Rent New Vehicle\n" +
                    "5:Return a New Vehicle\n6:Display All Available Vehicles in Ascending Order of Price\n" +
                    "7:Display All Available Vehicles in Alphabetical Order of Type \n8:Exit");
            System.out.print("\nEnter your choice: ");
            choice=sc.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int ID=sc.nextInt();
                    Customer cFound=findCusrtomerById(customers,ID);
                    if(cFound==null){
                        System.out.println("Customer not found");
                    }else{
                        cFound.printInfo();
                    }
                    break;
                case 2:
                    System.out.print("Enter Customer ID: ");
                     ID=sc.nextInt();
                     cFound=findCusrtomerById(customers,ID);
                    if(cFound==null){
                        System.out.println("Customer not found");
                    }else{
                        double rent=cFound.calculateRent();
                        System.out.println("Total Rental Cost for "+cFound.getName()+": $"+rent);
                    }
                    break;
                case 3:
                    System.out.print("Enter Customer ID: ");
                    ID=sc.nextInt();
                    cFound=findCusrtomerById(customers,ID);
                    if(cFound==null){
                        System.out.println("Customer not found");
                    }else{
                        System.out.println("Enter vehicle type to count (e.g, Car , Bike ,Truck )");
                        String typ=sc.next();
                        System.out.println("Number of car(s) Rented by "+cFound.getName()+": "+cFound.countVehiclesByType(typ));
                    }
                    break;
                case 4:
                    System.out.print("Enter Customer ID: ");
                    ID=sc.nextInt();
                    cFound=findCusrtomerById(customers,ID);
                    if(cFound==null){
                        System.out.println("Customer not found");
                    }else{
                            System.out.println("Enter vehicle type to count (e.g,Car , Bike , Truck)");
                            String typ=sc.next();
                            cFound.availableVehicleByType(availableVehicles,typ);
                            System.out.print("Enter the registration number if the selected Vehicle: ");
                            String registrationNum=sc.next();
                            System.out.print("Enter number of rental days: ");
                            int daysR=sc.nextInt();
                            cFound.rentVehicle(findVehicleByRegestration(availableVehicles,registrationNum),daysR);
                    }
                    break;
                case 5:
                    System.out.print("Enter Customer ID: ");
                    ID=sc.nextInt();
                    cFound=findCusrtomerById(customers,ID);
                    if(cFound==null){
                        System.out.println("Customer not found");
                    }else{
                        cFound.currentlyRented();
                        System.out.print("Enter the registration number if the selected Vehicle: ");
                        String registrationNum=sc.next();
                        cFound.returnVehicle(findVehicleByRegestration(availableVehicles,registrationNum));
                    }
                    break;
                case 6:
                    displayVehicleByPrice(availableVehicles);
                    break;
                case 7:
                    displayVehicleByType(availableVehicles);
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("this choice doesn't exist \nonly choosse form (1-8)!");
            }

        }while (choice!=8);
    }
}


