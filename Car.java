public class Car extends Vehicle {
    private int numberOfSeats;

    public Car(String vehicleId, String brand, String model,
               double baseRatePerDay, boolean isAvailable, int numberOfSeats) {
        super(vehicleId, brand, model, baseRatePerDay, isAvailable);
        this.numberOfSeats = numberOfSeats;
    }

    // Availability check
    public boolean isAvailable() {
        return super.isAvailable();
    }

    public void setAvailable(boolean available) {
        super.setAvailable(available);
    }

    // Getter
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    // Setter
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    // Rental cost calculation
    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRatePerDay() * days) + (numberOfSeats * 200 * days);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Seats: " + numberOfSeats);
    }
}