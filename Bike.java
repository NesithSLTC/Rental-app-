public class Bike extends Vehicle {

    private int engineCapacityCC;

    public Bike(String vehicleId, String brand, String model,
                double baseRatePerDay, int engineCapacityCC) {
        super(vehicleId, brand, model, baseRatePerDay);
        this.engineCapacityCC = engineCapacityCC;
    }

    public int getEngineCapacityCC() {
        return engineCapacityCC;
    }


    @Override
    public double calculateRentalCost(int days) {
        return getBaseRatePerDay() * days + (engineCapacityCC * 0.5 * days);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Bike, Engine CC: " + engineCapacityCC);
    }
}
