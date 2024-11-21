import java.util.Scanner;
public class Driver {
    static Scanner sc = new Scanner(System.in);

    public static void availableVehicles(Vehicle[] availableVehicles) {//method to print Available Vehicles
        System.out.println("Available vehicles for rental:");
        for (int i = 0; i < availableVehicles.length; i++) {
            System.out.println((i + 1) + ". " + availableVehicles[i].getType() + " (Registration: " + availableVehicles[i].getRegistrationNumber() +
                    "), " + availableVehicles[i].getBrand() + " - $" + availableVehicles[i].getRentalRatePerDay() + "/day");
        }
    }

    public static Vehicle findVehicles(Vehicle[] vehicles, String regestration, int index) { //method to find the vehicle
            Vehicle foundVehicle = null;
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getRegistrationNumber().equals(regestration)) {
                    foundVehicle = vehicle;
                    break;
                }
            }
            while (foundVehicle==null) {
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

    public static void checkAvailability (Vehicle[]vehicles, Vehicle v, String regestration,int index){
                if (v.getAvailable()) {
                    return;
                }
                while(!v.getAvailable()){

                System.out.println("Vehicle not available. please choose another. ");
                System.out.print("Enter regestration number of vehicle " + (index + 1) + "to rent: ");
                 regestration = sc.next();
                 //check if the new vehicle existed
                 v= findVehicles(vehicles,regestration,index);
                 if (v.getAvailable()) {
                    return;
                 }
                }
        }

        public static void main (String[]args){
            String name1, name2, licenseNumber, name;
            int id, numberOfVehiclesToRent;
            Vehicle[] availableVehicles = {new Vehicle("Car", "ABC123", "Toyota", 50.0, false),
                    new Vehicle("Bike", "DEF456", "Honda", 20.0, true),
                    new Vehicle("Truck", "GHI789", "Ford", 80.0, true),
                    new Vehicle("Car", "JKL012", "Hyundai", 55.0, true),
                    new Vehicle("Bike", "MNO345", "Yamaha", 25.0, true)
            };
            System.out.println("Enter the number of customers: ");
            int numberOfCustomers = sc.nextInt();  //scanning the number of customers
            Customer[] customers = new Customer[numberOfCustomers]; //creating an array of customers with the entered size
            for (int i = 0; i < customers.length; i++) {
                System.out.println("Enter details for customer " + (i + 1) + ":");
                System.out.print("Enter name: ");
                name1 = sc.next();
                name2 = sc.next();
                name = name1 + name2;
                System.out.print("Enter ID: ");
                id = sc.nextInt();
                System.out.print("Enter License number: ");
                licenseNumber = sc.next();
                System.out.print("Enter the maximum number of vehicles can rent by this customer: ");
                int maxNumber = sc.nextInt();
                    do{
                        System.out.print("Enter the number of vehicles to rent now: ");
                        numberOfVehiclesToRent = sc.nextInt();
                    }while ((numberOfVehiclesToRent > availableVehicles.length));
                    availableVehicles(availableVehicles);
                    customers[i] = new Customer(name, id, licenseNumber, maxNumber);
                    for (int j = 0; j < maxNumber; j++) {
                        System.out.print("Enter regestration number of vehicle " + (j + 1) + " to rent, ");
                        System.out.print(" Or enter \"exit\" to stop renting : ");
                        String registrationNumber = sc.next();
                        if (customers[i].getNumberOfCurrentRented() >= maxNumber || registrationNumber.equals("exit")) {
                            System.out.println("Rental process ended by customer " + (i + 1));
                            break;
                        } else {
                            Vehicle v = findVehicles(availableVehicles, registrationNumber, j);
                            checkAvailability(availableVehicles, v, registrationNumber, j);
                        }
                        System.out.print("Enter Rental Days: ");
                        int days = sc.nextInt();
                    }
                }
            }

        }

