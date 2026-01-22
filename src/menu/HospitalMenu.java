package menu;

import model.*;
import java.util.ArrayList ;
import java.util.Scanner;


public  class HospitalMenu implements Menu {
    private ArrayList<Person> records = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\n 1. Add Doctor \n 2. Add Patient \n 3. Show Records \n 4. Create Appointment \n 0. Exit \n");
        System.out.print("> ");
    }

    @Override
    public void run() {
       while(true) {
           displayMenu();
           try {
               String input = scanner.nextLine();
               int choice = Integer.parseInt(input);
               if (choice == 0) {
                   break;
               }
               switch (choice) {
                   case 1 -> addDoctor();
                   case 2 -> addPatient();
                   case 3 -> showRecords();
                   case 4 -> createAppointment();
                   default -> System.out.println("Wrong choice.");
               }
           } catch (Exception e) {
               System.out.println("System Error: " + e.getMessage());
           }

       }

    }


    private void addDoctor() {
        try {
            System.out.print("Name: "); String name = scanner.nextLine();
            System.out.print("Age: "); int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Spec: "); String spec = scanner.nextLine();
            records.add(new Doctor(records.size() + 1, name, age, spec));
        } catch (Exception e) { System.out.println("Failed: " + e.getMessage()); }
    }

    private void addPatient() {
        try {
            System.out.print("Name: "); String name = scanner.nextLine();
            System.out.print("Age: "); int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Diagnosis: "); String diag = scanner.nextLine();
            records.add(new Patient(records.size() + 1, name, age, diag));
        } catch (Exception e) { System.out.println("Failed: " + e.getMessage()); }
    }

    private void showRecords() {
        for (Person p : records) {
            p.performRole();
            if (p instanceof Examinable) ((Examinable) p).undergoExamination();
        }
    }

    private void createAppointment() {
        if (records.size() < 2) {
            System.out.println("Need at least 1 doctor and 1 patient.");
            return;
        }
        System.out.println("Appointment created (Stub logic).");
    }
}
