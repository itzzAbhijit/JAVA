import java.util.Scanner;

// Class to perform division
class DivisionOperation {
    private int a;
    private int b;

    // Constructor
    public DivisionOperation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // Method to perform division with exception handling
    public void calculateQuotient() {
        try {
            int result = a / b;
            System.out.println("Quotient = " + result);
        } 
        catch (ArithmeticException e) {
            System.out.println("Exception caught: Division by zero is not allowed");
        } 
        finally {
            System.out.println("Inside finally block");
        }
    }
}

// Main class
public class DivisionMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input two integers
        System.out.print("Enter first number (a): ");
        int a = sc.nextInt();

        System.out.print("Enter second number (b): ");
        int b = sc.nextInt();

        // Create object and perform operation
        DivisionOperation obj = new DivisionOperation(a, b);
        obj.calculateQuotient();
    }
}