//Write a Java program to create a vehicle class hierarchy. The base class should be Vehicle, with subclasses Truck, Car and Motorcycle. Each subclass should have properties such as make, model, year, and fuel type..Implement methods for
calculating t fuel efficiency, (distance
traveled, and maximum speed.

class Vehicle {
    protected String make, model, fuelType;
    protected int year;
    protected double distanceTraveled, fuelConsumed;

    public Vehicle(String make, String model, int year, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    public double getFuelEfficiency() {
        return distanceTraveled / fuelConsumed;  // km per litre
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public double getMaxSpeed() {
        return 0; // Overridden in subclasses
    }
}

class Car extends Vehicle {
    public Car(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
        distanceTraveled = 500;
        fuelConsumed = 25;
    }

    @Override
    public double getMaxSpeed() {
        return 180;
    }
}

class Truck extends Vehicle {
    public Truck(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
        distanceTraveled = 300;
        fuelConsumed = 50;
    }

    @Override
    public double getMaxSpeed() {
        return 120;
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year, String fuelType) {
        super(make, model, year, fuelType);
        distanceTraveled = 600;
        fuelConsumed = 20;
    }

    @Override
    public double getMaxSpeed() {
        return 160;
    }
}

public class MainQ13 {
    public static void main(String[] args) {

        Car car = new Car("Honda", "City", 2020, "Petrol");
        Truck truck = new Truck("Tata", "Ultra", 2018, "Diesel");
        Motorcycle bike = new Motorcycle("Yamaha", "R15", 2022, "Petrol");

        System.out.println("Car Efficiency: " + car.getFuelEfficiency());
        System.out.println("Truck Efficiency: " + truck.getFuelEfficiency());
        System.out.println("Bike Efficiency: " + bike.getFuelEfficiency());

        System.out.println("Car Max Speed: " + car.getMaxSpeed());
        System.out.println("Truck Max Speed: " + truck.getMaxSpeed());
        System.out.println("Bike Max Speed: " + bike.getMaxSpeed());
    }
}