import java.util.Scanner;
public class Driver {
    public static void availableVehicles(Vehicle[]availableVehicles){//method to print Available Vehicles
        System.out.println("Available vehicles for rental:");
        for(int i=0;i<availableVehicles.length;i++){
            System.out.println((i+1)+". "+availableVehicles[i].getType()+" (Registration: "+availableVehicles[i].getRegistrationNumber()+
                    "), "+availableVehicles[i].getBrand() +" - $"+availableVehicles[i].getRentalRatePerDay()+"/day");
        }
    }
public static void main(String[]args){
    String name,licenseNumber;
    int id,numberOfVehiclesToRent;
    Scanner sc=new Scanner(System.in);
    Vehicle[]availableVehicles={new Vehicle("Car","ABC123","Toyota",50.0,true),
            new Vehicle("Bike","DEF456","Honda",20.0,true),
            new Vehicle("Truck","GHI789","Ford",80.0,true),
            new Vehicle("Car","JKL012","Hyundai",55.0,true),
            new Vehicle("Bike","MNO345","Yamaha",25.0,true)

    };
    System.out.println("Enter the number of customers: ");
    int numberOfCustomers=sc.nextInt();  //scanning the number of customers
    Customer[]customers=new Customer[numberOfCustomers]; //creating an array of customers with the entered size
    for (int i=0;i<customers.length;i++){
        System.out.println("Enter details for customer "+(i+1)+":");
        System.out.print("Enter name: ");
        name=sc.next();
        System.out.print("Enter ID: ");
        id=sc.nextInt();
        System.out.print("Enter License number: ");
        licenseNumber=sc.next();
        System.out.print("Enter the number of vehicles to rent: ");
        numberOfVehiclesToRent=sc.nextInt();
        if (numberOfVehiclesToRent>availableVehicles.length)
            System.out.println("Number of vehicles you wish to rent is greater than the number of exist vehicles");
        else{
            customers[i]=new Customer(name,id,licenseNumber,numberOfVehiclesToRent);
            availableVehicles(availableVehicles);
            for(int j=0;j<numberOfVehiclesToRent;j++){
                System.out.println("Enter regestration number of vehicle "+(i+1)+"to rent: ");
                String registrationNumber=sc.next();
            }
        }

    }

}
}
