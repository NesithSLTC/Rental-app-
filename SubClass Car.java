public class Car {
  private int numberOfSeats;
  private double baseRatePerDay;

  public Car(int numberOfSeats, double baseRatePerDay) {
  this.numberOfSeats = numberOfSeats;
  this.baseRatePerDay = baseRatePerDay;
  }
  double calculateTotalCost(int days) {
    double totalCost = (baseRatePerDay * days) + (numberOfSeats * 200 * days);
    return totalCost;  
   }
}
