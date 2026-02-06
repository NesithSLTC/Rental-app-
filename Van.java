public class Van extends Vehicle {
    private double cargoCapacityKg;


    public Van(String vehicleId, String brand, String model, double baseRatePerDay, double cargoCapacityKg) {
        super(vehicleId, brand, model, baseRatePerDay);
        this.cargoCapacityKg = cargoCapacityKg;
    }


    public double getCargoCapacityKg() {
        return cargoCapacityKg;
    }

    public void setCargoCapacityKg(double cargoCapacityKg) {
        this.cargoCapacityKg = cargoCapacityKg;
    }


    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Van");
        System.out.println("Cargo Capacity: " + cargoCapacityKg + " Kg");
    }


    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRatePerDay() * days) + (cargoCapacityKg * 0.2 * days);
    }
}