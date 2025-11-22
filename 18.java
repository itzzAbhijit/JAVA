//Write a multithreaded program that calculates the factorial of numbers in parallel I using
a
1 thread ] for each
calculation

class FactorialThread extends Thread {
    private int number;

    public FactorialThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + number + " is " + fact);
    }
}

public class FactorialMain {
    public static void main(String[] args) {
        int[] nums = {5, 7, 10};

        for (int n : nums) {
            new FactorialThread(n).start();
        }
    }
}