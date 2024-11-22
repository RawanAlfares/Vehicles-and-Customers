public class Vehicle {
    //attributes
    private String type;
    private String registrationNumber;
    private String brand;
    private double rentalRatePerDay;
    private int rentDays;
    private boolean available;
    //costructors defualt and parametarized

    public Vehicle(){
        type="";
        registrationNumber="0";
        brand="";
        rentalRatePerDay=0;
        rentDays=0;
        available=true;
    }
    public Vehicle(String type,String registrationNumber,String brand , double rentalRatePerDay,boolean available){
        this.type=type;
        this.registrationNumber=registrationNumber;
        this.available=true;
        this.rentalRatePerDay=rentalRatePerDay;
        this.brand=brand;
    }
    //methods
    public void printInfo(){
        System.out.println("Regestration number "+ registrationNumber);
        System.out.println("Type "+ type);
        System.out.println("Available "+ available);
        System.out.println("Brand "+brand);
    }
    //setters and getters
    void setType(String type){
        this.type=type;
    }
    String getType(){
        return type;
    }
    void setRegistrationNumber(String registrationNumber){
        this.registrationNumber=registrationNumber;
    }
    String getRegistrationNumber(){
        return registrationNumber;
    }
    void setBrand(String brand){
        this.brand=brand;
    }
    String getBrand(){
        return brand;
    }
    void setRentalRatePerDay(double rentalRatePerDay){
        this.rentalRatePerDay=rentalRatePerDay;
    }
    Double getRentalRatePerDay(){
        return rentalRatePerDay;
    }
    void setRentDays(int rentDays){
        this.rentDays=rentDays;
    }
    int getRentDays(){
        return rentDays;
    }
    public void setAvailable(boolean available){
        this.available=available;
    }
    Boolean getAvailable(){
        return available;
    }

}
