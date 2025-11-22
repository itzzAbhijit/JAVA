Create a package bank with an interface Account having methods deposit(), withdraw(), and getBalance().
Implement classes SavingsAccount and CurrentAccount.
Test in BankTest.


interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

class SavingsAccount implements Account {

    private double balance;
    private double interestRate;

    public SavingsAccount(double initialBalance, double interestRate) {
        this.balance = initialBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void addInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest Added: " + interest);
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

class CurrentAccount implements Account {

    private double balance;
    private double overdraftLimit;

    public CurrentAccount(double initialBalance, double overdraftLimit) {
        this.balance = initialBalance;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

public class BankTest {

    public static void main(String[] args) {

        SavingsAccount savings = new SavingsAccount(5000, 5);
        CurrentAccount current = new CurrentAccount(10000, 2000);

        System.out.println("=== SAVINGS ACCOUNT OPERATIONS ===");
        savings.deposit(2000);
        savings.withdraw(1000);
        savings.addInterest();
        System.out.println("Final Savings Balance: " + savings.getBalance());

        System.out.println("\n=== CURRENT ACCOUNT OPERATIONS ===");
        current.deposit(3000);
        current.withdraw(12000);
        current.withdraw(3000);
        System.out.println("Final Current Balance: " + current.getBalance());
    }
}