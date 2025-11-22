import java.util.Scanner;

// Vehicle interface
interface Vehicle {
    void start();
    void stop();
}

// Car class implementing Vehicle
class Car implements Vehicle {

    private String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println(model + " car started with a roar!");
    }

    @Override
    public void stop() {
        System.out.println(model + " car stopped safely.");
    }
}

// Bike class implementing Vehicle
class Bike implements Vehicle {

    private String brand;

    public Bike(String brand) {
        this.brand = brand;
    }

    @Override
    public void start() {
        System.out.println(brand + " bike started with a vroom!");
    }

    @Override
    public void stop() {
        System.out.println(brand + " bike stopped smoothly.");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a vehicle type:");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {

            case 1:
                System.out.print("Enter Car model: ");
                String model = sc.nextLine();

                Car car = new Car(model);
                car.start();
                car.stop();
                break;

            case 2:
                System.out.print("Enter Bike brand: ");
                String brand = sc.nextLine();

                Bike bike = new Bike(brand);
                bike.start();
                bike.stop();
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}