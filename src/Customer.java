public class Customer {
    //attributes
    private String name;
    private int id;
    private String licenseNumber;
    private int numberOfCurrentRented;
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
        numberOfCurrentRented=maxVehicles;
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
    void rentVehicle(Vehicle vehicle){

    }

}
