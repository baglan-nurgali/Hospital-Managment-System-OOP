import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> hospitalRegistry = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Initial Test Data
        hospitalRegistry.add(new Doctor("Gregory House", 45, "Diagnostics"));
        hospitalRegistry.add(new Patient("John Doe", 25, "Flu"));

        boolean running = true;
        while (running) {
            System.out.println("\n--- HOSPITAL MANAGEMENT SYSTEM ---");
            System.out.println("1. View All Registry");
            System.out.println("2. Add New Patient");
            System.out.println("3. Add New Doctor");
            System.out.println("4. Demonstrate Polymorphism (Perform Actions)");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Current Registry ---");
                    for (Person p : hospitalRegistry) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.print("Enter Patient Name: ");
                    String pName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int pAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Diagnosis: ");
                    String diag = scanner.nextLine();
                    hospitalRegistry.add(new Patient(pName, pAge, diag));
                    System.out.println("Patient added successfully!");
                    break;
                case 3:
                    System.out.print("Enter Doctor Name: ");
                    String dName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int dAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Specialty: ");
                    String spec = scanner.nextLine();
                    hospitalRegistry.add(new Doctor(dName, dAge, spec));
                    System.out.println("Doctor added successfully!");
                    break;
                case 4:
                    System.out.println("\n--- Demonstrating Polymorphism ---");
                    for (Person p : hospitalRegistry) {
                        p.performAction();
                    }
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting system... Goodbye!");
                    break;
                default:
                    System.out.println("Error: Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}