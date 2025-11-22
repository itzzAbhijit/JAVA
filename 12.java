//Write a Java program to create a class known as Person with methods called getFirstName()and getlastName()
Create a subclass called Employee that
adds new method named
getEmployeeld()and overrides 1the
getlastName() method to include the employee's job title

class Person {
    protected String firstName;
    protected String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class Employee extends Person {
    private String employeeId;
    private String jobTitle;

    public Employee(String firstName, String lastName, String employeeId, String jobTitle) {
        super(firstName, lastName);
        this.employeeId = employeeId;
        this.jobTitle = jobTitle;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    // Overridden method
    @Override
    public String getLastName() {
        return lastName + " (" + jobTitle + ")";
    }
}

public class MainQ12 {
    public static void main(String[] args) {
        Employee e = new Employee("Abhijit", "Mohanty", "EMP101", "Software Engineer");
        System.out.println("First Name: " + e.getFirstName());
        System.out.println("Last Name: " + e.getLastName());
        System.out.println("Employee ID: " + e.getEmployeeId());
    }
}