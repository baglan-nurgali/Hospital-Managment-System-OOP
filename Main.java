public class Main {
    public static void main(String[] args) {
        System.out.println("=== HOSPITAL MANAGEMENT SYSTEM DATABASE ===");

        Patient p1 = new Patient(101, "Alice Freeman", 72, "O+");
        Patient p2 = new Patient();
        Doctor d1 = new Doctor(202, "Gregory House", "Diagnostics", true);
        Appointment a1 = new Appointment("APP-001", "Alice Freeman", "10:30 AM", 5000.0);
        Appointment a2 = new Appointment("APP-002", "Bob Smith", "18:45 PM", 4500.0);

        System.out.println("\n--- REGISTRY ---");
        System.out.println(p1);
        System.out.println(d1);
        System.out.println(a1);

        System.out.println("\n--- ACTIONS & LOGIC ---");

        System.out.println("Updating default patient...");
        p2.setName("John Doe");
        p2.setAge(30);
        System.out.println("New entry: " + p2.getName() + " (Adult: " + p2.isAdult() + ")");

        System.out.println("Checking " + p1.getName() + " priority: " + p1.getMedicalPriority());

        System.out.println("Status of " + d1.getContactFormat() + ": On Duty = " + d1.isOnDuty());
        d1.toggleDuty();
        System.out.println("New status: On Duty = " + d1.isOnDuty());

        System.out.println("Checking session time for " + a2.getPatientName() + ": Evening = " + a2.isEveningSession());
        System.out.println("Applying urgent surcharge to " + a1.getAppointmentId());
        a1.applyUrgentSurcharge(1500.0);
        System.out.println("Updated Fee: " + a1.getConsultationFee());

        System.out.println("\n--- FINAL SUMMARY ---");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(d1);
        System.out.println(a1);
        System.out.println(a2);

        System.out.println("\n=== SYSTEM OFFLINE ===");
    }
}