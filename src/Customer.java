public class Customer {
    //attributes
    private String name;
    private int id;
    private String licenseNumber;
    private int numberOfCurrentRented;
    private int  maxVehicles;
    private Vehicle[]vehiclesRented;
    //costructors defualt and parametarized
    public Customer(){
        name="";
        id=0;
        licenseNumber="";
        numberOfCurrentRented=0;
    }
    public Customer(String name,int id,String licenseNumber,int maxVehicles){
       this.name=name;
       this.id=id;
       this.licenseNumber=licenseNumber;
       this.maxVehicles=maxVehicles;
        numberOfCurrentRented=0;
    }
    //setters and getters
    void setName(String name){
        this.name=name;
    }
    String getName(){
        return name;
    }
    void setId(int id){
        this.id=id;
    }
    int getId(){
        return id;
    }
    void setLicenseNumber(String licenseNumber){
        this.licenseNumber=licenseNumber;
    }
    String getLicenseNumber(){
        return licenseNumber;
    }
    void setNumberOfCurrentRented(int numberOfCurrentRented){
        this.numberOfCurrentRented=numberOfCurrentRented;
    }
    int getNumberOfCurrentRented(){
        return numberOfCurrentRented;
    }
    //Methods
    void rentVehicle(Vehicle vehicle ,int day){

    }
    void reternVehicle(Vehicle vehicle){

    }
    double calculateRent(){
        double rent=0;
        return rent;
    }
    double calculateRent(String type){
        double rent=0;
        return rent;
    }
    double countVehiclesByType(String type){
        double rent=0;
        return rent;
    }
    void printInfo(){

    }


}
