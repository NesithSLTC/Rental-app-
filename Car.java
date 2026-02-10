public class Car extends Vehicle {

    private int numberOfSeats;

    public Car(String vehicleId, String brand, String model,
               double baseRatePerDay, int numberOfSeats) {
        super(vehicleId, brand, model, baseRatePerDay);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }


    @Override
    public double calculateRentalCost(int days) {
        return getBaseRatePerDay() * days + (numberOfSeats * 200 * days);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Type: Car, Seats: " + numberOfSeats);
    }
}

