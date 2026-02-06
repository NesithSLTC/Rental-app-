public class Bike extends Vehicle {
    private int engineCapacityCC;

    public Bike(String vehicleId, String brand, String model, double baseRatePerDay, boolean isAvailable, int engineCapacityCC) {
        super(vehicleId, brand, model, baseRatePerDay, isAvailable);
        this.engineCapacityCC = engineCapacityCC;
    }

    // Checking weather a vehicle exists or not 
    public boolean isAvailable() {
        return super.isAvailable();
    }
    
    public void setAvailable(boolean available) {
        super.setAvailable(available);
    }

    // Getter
    public int getEngineCapacityCC() {
        return engineCapacityCC;
    }

    //Setter
    public void setEngineCapacityCC(int engineCapacityCC) {
        this.engineCapacityCC = engineCapacityCC;
    }

    //Rental cost calculation
    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRatePerDay() * days) + (engineCapacityCC * 0.5 * days);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine Capacity: " + engineCapacityCC + "cc");
    }

}
