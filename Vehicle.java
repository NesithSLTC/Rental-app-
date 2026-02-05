public class Vehicle {

    //Attributes
    private String vehicleID;
    private String brand;
    private String model;
    private double baseRatePerDay;
    private boolean isAvailable;

    //Parameterized constructor
    public Vehicle(String vehicleID, String brand, String model, double baseRatePerDay, boolean isAvailable) {
        this.vehicleID = vehicleID;
        this.brand = brand;
        this.model = model;
        this.baseRatePerDay = baseRatePerDay;
        this.isAvailable = isAvailable;
    }
    //Getter Setter
    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getBaseRatePerDay() {
        return baseRatePerDay;
    }

    public void setBaseRatePerDay(double baseRatePerDay) {
        this.baseRatePerDay = baseRatePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    //Display Details
    public void displayDetails() {
        System.out.println("Vehicle ID: " + vehicleID);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Base rate per day: " + baseRatePerDay);
        System.out.println("Available status: " + isAvailable);
    }

    //Rent Vehicle
    public void rentVehicle() {
        if (isAvailable) {
            System.out.println("Vehicle has been rent");
        }
        else {
            System.out.println("Vehicle has not been rent");
        }
    }

    //Return Vehicle
    public void returnVehicle() {
        if (isAvailable) {
            System.out.println("Vehicle has been return");
        }
        else {
            System.out.println("Vehicle has not been return");
        }
    }

    //Abstract Method
    //public abstract double calculateRentalCost(int days);
}

