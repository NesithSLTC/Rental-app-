import java.util.*;
import java.io.*;

public class RentalApp {

    private static ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static double totalIncome = 0;
    private static final String FILE_NAME = "rental_data.txt";

    public static void main(String[] args) {
        loadData();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- Vehicle Rental System ---");
                System.out.println("1. Add Vehicle");
                System.out.println("2. View All Vehicles");
                System.out.println("3. Rent a Vehicle");
                System.out.println("4. Return a Vehicle");
                System.out.println("5. Search Vehicle by ID");
                System.out.println("6. View Total Rental Income");
                System.out.println("7. Exit");
                System.out.print("Choose option: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addVehicle(sc);
                    case 2 -> viewVehicles();
                    case 3 -> rentVehicle(sc);
                    case 4 -> returnVehicle(sc);
                    case 5 -> searchVehicle(sc);
                    case 6 -> System.out.println("Total Income: " + totalIncome);
                    case 7 -> {
                        saveData();
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid menu option!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                sc.nextLine();
            }
        }
    }

    private static void addVehicle(Scanner sc) {
        sc.nextLine();
        System.out.print("Enter Vehicle ID: ");
        String id = sc.nextLine();

        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equals(id)) {
                System.out.println("Vehicle ID already exists!");
                return;
            }
        }

        System.out.print("Brand: ");
        String brand = sc.nextLine();
        System.out.print("Model: ");
        String model = sc.nextLine();
        System.out.print("Base Rate per Day: ");
        double rate = sc.nextDouble();

        System.out.println("1. Car  2. Bike  3. Van");
        int type = sc.nextInt();

        Vehicle vehicle = null;

        if (type == 1) {
            System.out.print("Number of Seats: ");
            vehicle = new Car(id, brand, model, rate, sc.nextInt());
        } else if (type == 2) {
            System.out.print("Engine Capacity (CC): ");
            vehicle = new Bike(id, brand, model, rate, sc.nextInt());
        } else if (type == 3) {
            System.out.print("Cargo Capacity (Kg): ");
            vehicle = new Van(id, brand, model, rate, sc.nextDouble());
        } else {
            System.out.println("Invalid vehicle type.");
            return;
        }

        vehicles.add(vehicle);
        System.out.println("Vehicle added successfully.");
    }

    private static void viewVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
            return;
        }
        for (Vehicle v : vehicles) {
            v.displayDetails();
        }
    }

    private static void rentVehicle(Scanner sc) {
        System.out.print("Enter Vehicle ID: ");
        String id = sc.next();

        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equals(id)) {
                if (!v.isAvailable()) {
                    System.out.println("Vehicle already rented.");
                    return;
                }
                System.out.print("Enter rental days: ");
                int days = sc.nextInt();
                if (days <= 0) {
                    System.out.println("Days must be greater than zero.");
                    return;
                }
                double cost = v.calculateRentalCost(days);
                v.rentVehicle();
                totalIncome += cost;
                System.out.println("Vehicle rented. Cost: " + cost);
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    private static void returnVehicle(Scanner sc) {
        System.out.print("Enter Vehicle ID: ");
        String id = sc.next();

        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equals(id)) {
                v.returnVehicle();
                System.out.println("Vehicle returned successfully.");
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    private static void searchVehicle(Scanner sc) {
        System.out.print("Enter Vehicle ID: ");
        String id = sc.next();

        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equals(id)) {
                v.displayDetails();
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

    // ===== File Handling =====
    private static void saveData() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            pw.println(totalIncome);
            for (Vehicle v : vehicles) {
                if (v instanceof Car c) {
                    pw.println("Car," + c.getVehicleId() + "," +
                            c.getBrand() + "," +
                            c.getModel() + "," +
                            c.getBaseRatePerDay() + "," +
                            c.isAvailable() + "," +
                            c.getNumberOfSeats());

                } else if (v instanceof Bike b) {
                    pw.println("Bike," + b.getVehicleId() + "," +
                            b.getBrand() + "," +
                            b.getModel() + "," +
                            b.getBaseRatePerDay() + "," +
                            b.isAvailable() + "," +
                            b.getEngineCapacityCC());

                } else if (v instanceof Van va) {
                    pw.println("Van," + va.getVehicleId() + "," +
                            va.getBrand() + "," +
                            va.getModel() + "," +
                            va.getBaseRatePerDay() + "," +
                            va.isAvailable() + "," +
                            va.getCargoCapacityKg());
                }
            }

        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    private static void loadData() {
        try (Scanner file = new Scanner(new File(FILE_NAME))) {
            if (file.hasNextLine()) {
                totalIncome = Double.parseDouble(file.nextLine());
            }

            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] parts = line.split(",");

                String type = parts[0].trim();
                String vehicleId = parts[1].trim();
                String brand = parts[2].trim();
                String model = parts[3].trim();
                double baseRate = Double.parseDouble(parts[4].trim());
                boolean isAvailable = Boolean.parseBoolean(parts[5].trim());

                Vehicle vehicle = null;

                switch (type) {
                    case "Car":
                        int numberOfSeats = Integer.parseInt(parts[6].trim());
                        vehicle = new Car(vehicleId, brand, model, baseRate, numberOfSeats);
                        break;
                    case "Bike":
                        int engineCapacity = Integer.parseInt(parts[6].trim());
                        vehicle = new Bike(vehicleId, brand, model, baseRate, engineCapacity);
                        break;
                    case "Van":
                        double cargoCapacity = Double.parseDouble(parts[6].trim());
                        vehicle = new Van(vehicleId, brand, model, baseRate, cargoCapacity);
                        break;
                    default:
                        System.out.println("Unknown vehicle type: " + type);
                        continue;
                }

                if (vehicle != null) {
                    vehicle.setAvailable(isAvailable);
                    vehicles.add(vehicle);
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
    }
