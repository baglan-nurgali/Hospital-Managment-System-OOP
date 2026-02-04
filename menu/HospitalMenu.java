package model.menu;

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
            System.out.println("\n--- HOSPITAL MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Update Doctor");
            System.out.println("4. Delete Doctor");
            System.out.println("5. Search Doctor by Name");
            System.out.println("0. Exit");
            System.out.print("Select: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addDoctor(); break;
                case 2: viewAllDoctors(); break;
                case 3: updateDoctor(); break;
                case 4: deleteDoctor(); break;
                case 5: searchDoctor(); break;
                case 0: running = false; break;
                default: System.out.println("Invalid option!");
            }
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
