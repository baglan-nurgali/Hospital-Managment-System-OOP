package model.menu;

import model.database.DatabaseConnection;
import model.model.Doctor;
import model.database.DoctorDAO;
import model.menu.Menu;
import java.util.Scanner;
import java.util.List;

public class HospitalMenu implements Menu {
    private Scanner scanner;
    private DoctorDAO doctorDAO;

    public HospitalMenu() {
        this.scanner = new Scanner(System.in);
        this.doctorDAO = new DoctorDAO();
    }

    @Override
    public void run() {
        displayMenu();
    }

    @Override
    public void displayMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- HOSPITAL MANAGEMENT SYSTEM (11 OPTIONS) ---");
            System.out.println("1.  Add New Doctor");
            System.out.println("2.  View All Doctors");
            System.out.println("3.  Update Doctor Info");
            System.out.println("4.  Delete Doctor by ID");
            System.out.println("5.  Search Doctor by Name (ILIKE)");
            System.out.println("6.  Search Doctors by Age Range");
            System.out.println("7.  View Doctors count");
            System.out.println("8.  Clear All Records (Dangerous)");
            System.out.println("9.  System Status (DB Connection)");
            System.out.println("10. About System");
            System.out.println("0.  Exit Program");
            System.out.print("Select: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addDoctor(); break;
                case 2: viewAllDoctors(); break;
                case 3: updateDoctor(); break;
                case 4: deleteDoctor(); break;
                case 5: searchDoctor(); break;
                case 6: searchByAge(); break;
                case 7: getCount(); break;
                case 8: deleteAll(); break;
                case 9: checkStatus(); break;
                case 10: System.out.println("Hospital HMS v2.0 - Week 8 CRUD Edition"); break;
                case 0: running = false; break;
                default: System.out.println("Invalid option!");
            }
        }
    }

// Новые методы для меню:

    private void searchByAge() {
        System.out.print("Min age: ");
        int min = scanner.nextInt();
        System.out.print("Max age: ");
        int max = scanner.nextInt();
        List<Doctor> results = doctorDAO.searchByAgeRange(min, max);
        results.forEach(d -> System.out.println(d.getName() + " - " + d.getAge() + " years"));
    }

    private void getCount() {
        // Можно быстро реализовать через SELECT COUNT(*) в DAO или просто посчитать размер списка
        System.out.println("Total doctors in database: " + doctorDAO.searchByName("").size());
    }

    private void deleteAll() {
        System.out.print("ARE YOU ABSOLUTELY SURE? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            doctorDAO.deleteAllDoctors();
        }
    }

    private void checkStatus() {
        if (DatabaseConnection.getConnection() != null) {
            System.out.println("Database Status: Connected ");
        }
    }

    private void addDoctor() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Specialization: ");
        String spec = scanner.nextLine();
        doctorDAO.insertDoctor(new Doctor(0, name, age, spec));
    }

    private void viewAllDoctors() {
        doctorDAO.getAllDoctors();
    }

    private void updateDoctor() {
        System.out.print("ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Doctor old = doctorDAO.getDoctorById(id);
        if (old == null) {
            System.out.println("Not found!");
            return;
        }

        System.out.print("New Name [" + old.getName() + "]: ");
        String name = scanner.nextLine();
        if (name.isEmpty()) name = old.getName();

        System.out.print("New Age [" + old.getAge() + "]: ");
        String ageIn = scanner.nextLine();
        int age = ageIn.isEmpty() ? old.getAge() : Integer.parseInt(ageIn);

        System.out.print("New Spec [" + old.getSpecialization() + "]: ");
        String spec = scanner.nextLine();
        if (spec.isEmpty()) spec = old.getSpecialization();

        doctorDAO.updateDoctor(new Doctor(id, name, age, spec));
    }

    private void deleteDoctor() {
        System.out.print("ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Doctor doc = doctorDAO.getDoctorById(id);
        if (doc != null) {
            System.out.print("Confirm delete " + doc.getName() + "? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                doctorDAO.deleteDoctor(id);
            }
        }
    }

    private void searchDoctor() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        List<Doctor> results = doctorDAO.searchByName(name);
        for (Doctor d : results) {
            System.out.println(d.getId() + ": " + d.getName() + " (" + d.getSpecialization() + ")");
        }
    }
}
