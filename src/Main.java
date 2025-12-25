public class Main {
    public static void main(String[] args) {
        // 1. Приветствие 
        System.out.println("=== Hospital Management System ===");

        // 2. Создание объектов (минимум 5) 
        Patient p1 = new Patient(1, "Ivan Petrov", 25, "A+");
        Patient p2 = new Patient(); // Дефолтный конструктор 
        Doctor d1 = new Doctor(101, "Dr. House", "Surgeon", 15);
        Appointment a1 = new Appointment(501, "Ivan Petrov", "Dr. House", "Scheduled");
        Appointment a2 = new Appointment(502, "Unknown", "Dr. Strange", "Scheduled");

        // 3. Вывод начального состояния 
        System.out.println("\n--- INITIAL STATE ---");
        System.out.println(p1);
        System.out.println(d1);
        System.out.println(a1);

        // 4. Тестирование сеттеров и геттеров 
        System.out.println("\n--- TESTING SETTERS & GETTERS ---");
        p2.setFullName("Elena Sidorova");
        p2.setAge(12);
        System.out.println("Updated Patient 2 Name: " + p2.getFullName());

        // 5. Тестирование дополнительных методов 
        System.out.println("\n--- TESTING BUSINESS LOGIC ---");
        System.out.println(p1.getFullName() + " is minor: " + p1.isMinor());
        System.out.println(p2.getFullName() + " category: " + p2.getAgeCategory());

        System.out.println(d1.getName() + " is experienced: " + d1.isExperienced());
        System.out.println(d1.getName() + " can perform surgery: " + d1.canPerformSurgery());

        System.out.println("Appointment status: " + a1.getStatus());
        a1.cancel();
        System.out.println("New status: " + a1.getStatus());

        // 6. Завершение 
        System.out.println("\n=== Program Complete ===");
    }
}