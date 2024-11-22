public class Customer {
    //attributes
    private String name;
    private int id;
    private String licenseNumber;
    private int numberOfCurrentRented;
    private int  maxVehicles;
    private Vehicle[]vehiclesRented;
    //constructors default and parameterized
    public Customer(){
        name="";
        id=0;
        licenseNumber="";
        numberOfCurrentRented=0;
        maxVehicles=3;//as a default vehicles
        vehiclesRented=new Vehicle[maxVehicles];
    }
    public Customer(String name,int id,String licenseNumber,int maxVehicles){
       this.name=name;
       this.id=id;
       this.licenseNumber=licenseNumber;
        numberOfCurrentRented=0;
        this.maxVehicles=maxVehicles;
        this.vehiclesRented=new Vehicle[maxVehicles];
    }
    //setters and getters
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setLicenseNumber(String licenseNumber){
        this.licenseNumber=licenseNumber;
    }
    public String getLicenseNumber(){
        return licenseNumber;
    }
    public void setNumberOfCurrentRented(int numberOfCurrentRented){
        this.numberOfCurrentRented=numberOfCurrentRented;
    }
    public int getNumberOfCurrentRented(){
        return numberOfCurrentRented;
    }
    public void setMaxVehicles(int maxVehicles){
        this.maxVehicles=maxVehicles;
    }
    public int getMaxVehicles(){
        return maxVehicles;
    }
    //Methods
    public void availableVehicleByType(Vehicle []availableVehicles,String type){
        System.out.println("Available vehicles of type '"+type+"':");
        int index=0;
        boolean found =false;
        for(int i=0;i<availableVehicles.length;i++){
            Vehicle v=availableVehicles[i];
            if(v.getType().toLowerCase().equals(type.toLowerCase())&& v.getAvailable()==true){
                System.out.println((index + 1) + ". " + v.getType() + " (Registration: " + v.getRegistrationNumber() +
                        "), " + v.getBrand() + " - $" + v.getRentalRatePerDay() + "/day");
                        index++;
                        found= true;
            }
        }
        if(found==false){
            System.out.println("'"+type+"' it's not available ! ");
        }

    }
    public void currentlyRented(){
        System.out.println("List for currently rented: ");
        int index=0;
        boolean found=false;
        for(int i=0;i<numberOfCurrentRented;i++){
            Vehicle v=vehiclesRented[i];
                System.out.println((index + 1) + ". " + v.getType() + " (Registration: " + v.getRegistrationNumber() +
                        "), " + v.getBrand() + " - $" + v.getRentalRatePerDay() + "/day");
                index++;
                found=true;
        }
        if(found==false){
            System.out.println("No vehicles are currently rented .");
            return;
        }
    }
    public void rentVehicle(Vehicle vehicle ,int day){
        if(maxVehicles>numberOfCurrentRented){
            vehiclesRented[numberOfCurrentRented]=vehicle;
            vehicle.setRentDays(day);
            vehicle.setAvailable(false);
            numberOfCurrentRented++;
            System.out.println("Vehicle "+ vehicle.getRegistrationNumber()+" rented successfully :) ");
        }else{
            System.out.println("Cant rent more vehicles");
        }
    }
    public void returnVehicle(Vehicle vehicle){
        Vehicle foundV=null;
        for(int i=0;i<numberOfCurrentRented;i++){
                if(vehiclesRented[i].getRegistrationNumber().equals(vehicle.getRegistrationNumber())){
                    foundV=vehiclesRented[i];
                    for(int j=i;j<numberOfCurrentRented-1;j++){
                        vehiclesRented[j]=vehiclesRented[j+1];
                    }
                    vehiclesRented[numberOfCurrentRented-1]=null;
                    numberOfCurrentRented--;
                    System.out.println("Vehicle "+ vehicle.getRegistrationNumber()+" returned successfully :) ");
                    break;
                }
            }
        foundV.setAvailable(true);
    }
    public double calculateRent(){
        double totalRent=0;
        for(int i=0;i<numberOfCurrentRented;i++){
            totalRent+=vehiclesRented[i].getRentalRatePerDay()*vehiclesRented[i].getRentDays();
        }
        return totalRent;
    }
    public double calculateRent(String type){
        double rent=0;
        for(int i=0;i<numberOfCurrentRented;i++){
            if(vehiclesRented[i].getType().equals(type))
            rent+=vehiclesRented[i].getRentalRatePerDay()*vehiclesRented[i].getRentDays();
        }
        return rent;
    }
    public int countVehiclesByType(String type ){
        int count=0;
        for( Vehicle v:Driver.availableVehicles)
                if(v.getType().toLowerCase().equals(type) && !v.getAvailable())
                    count++;
        return count;
    }
    public void printInfo(){
        System.out.println("Customer Information: ");
        System.out.println("Name: "+name);
        System.out.println("ID: "+id);
        System.out.println("License Number: "+licenseNumber);
        System.out.println("Vehicles Rented: ");
        for(int i=0;i<numberOfCurrentRented;i++){
            Vehicle v=vehiclesRented[i];
            System.out.println("- Vehicle Code: "+v.getType().toUpperCase()+v.getRegistrationNumber()+
                    ", Type: "+v.getType()+", Brand: "+v.getBrand()+
                    ", Daily Rate: $"+v.getRentalRatePerDay());
        }
    }
}
