import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> registry = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // 1. Предварительные данные (Initial Data)
        try {
            registry.add(new Doctor("Gregory House", 45, "Diagnostics"));
            registry.add(new Patient("John Doe", 28, "Flu"));
        } catch (InvalidDataException e) {
            System.out.println("Initialization Error: " + e.getMessage());
        }

        while (true) {
            System.out.println("\n--- HOSPITAL MANAGEMENT SYSTEM  ---");
            System.out.println("1. View All Registry");
            System.out.println("2. Add New Doctor");
            System.out.println("3. Add New Patient");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Очистка буфера

            if (choice == 4) break;

            // КЛЮЧЕВОЙ МОМЕНТ: Весь ввод данных обернут в try-catch
            try {
                switch (choice) {
                    case 1:
                        System.out.println("\n--- Current Records ---");
                        for (Person p : registry) {
                            System.out.println(p.getDetails());
                            p.performAction(); // Полиморфизм
                        }
                        break;

                    case 2:
                        System.out.print("Doctor Name: ");
                        String dName = sc.nextLine();
                        System.out.print("Age: ");
                        int dAge = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Specialty: ");
                        String spec = sc.nextLine();

                        // Если данные неверны, конструктор выбросит Exception
                        registry.add(new Doctor(dName, dAge, spec));
                        System.out.println("Doctor added successfully!");
                        break;

                    case 3:
                        System.out.print("Patient Name: ");
                        String pName = sc.nextLine();
                        System.out.print("Age: ");
                        int pAge = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Diagnosis: ");
                        String diag = sc.nextLine();

                        registry.add(new Patient(pName, pAge, diag));
                        System.out.println("Patient added successfully!");
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (InvalidDataException e) {
                // Если сработала валидация (например, возраст -5), мы ловим ошибку здесь
                System.out.println("\n[VALIDATION ERROR]: " + e.getMessage());
                System.out.println("Record was not added. Please try again.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred.");
                sc.nextLine(); // Очистка в случае неверного типа ввода
            }
        }
        sc.close();
    }
}
