package Day6;

class Vehicle {
    private String make;
    private String model;
    private int year;
    private double rentalPricePerDay;

    public Vehicle(String make, String model, int year, double rentalPricePerDay) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public double calculateRentalCost(int days) {
        return days * rentalPricePerDay;
    }
}

class Car extends Vehicle {
    private int numSeats;
    private int numDoors;

    public Car(String make, String model, int year, double rentalPricePerDay, int numSeats, int numDoors) {
        super(make, model, year, rentalPricePerDay);
        this.numSeats = numSeats;
        this.numDoors = numDoors;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public int getNumDoors() {
        return numDoors;
    }
}

class Motorcycle extends Vehicle {
    private int engineSize;

    public Motorcycle(String make, String model, int year, double rentalPricePerDay, int engineSize) {
        super(make, model, year, rentalPricePerDay);
        this.engineSize = engineSize;
    }

    public int getEngineSize() {
        return engineSize;
    }
}

public class Main {
    public static void main(String[] args) {

        Car car = new Car("Toyota", "Corolla", 2020, 150.0, 5, 4);
        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Street 750", 2019, 250.0, 750);

        // Calculating rental costs
        int rentalDays = 5;  
        double carRentalCost = car.calculateRentalCost(rentalDays);
        double motorcycleRentalCost = motorcycle.calculateRentalCost(rentalDays);

        System.out.println("Car Make: " + car.getMake() + ", Model: " + car.getModel() + ", Year: " + car.getYear() +
            ", Seats: " + car.getNumSeats() + ", Doors: " + car.getNumDoors() +
            ", Rental Cost for " + rentalDays + " days: RM" + carRentalCost);
        
        System.out.println("Motorcycle Make: " + motorcycle.getMake() + ", Model: " + motorcycle.getModel() + 
            ", Year: " + motorcycle.getYear() + ", Engine Size: " + motorcycle.getEngineSize() + "cc" +
            ", Rental Cost for " + rentalDays + " days: RM" + motorcycleRentalCost);
    }
}
