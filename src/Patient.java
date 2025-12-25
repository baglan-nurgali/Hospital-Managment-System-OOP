public class Patient {
    // 1. Приватные поля (минимум 4) [cite: 12, 57, 61]
    private int patientId;
    private String fullName;
    private int age;
    private String bloodType;
    // 2. Конструктор с параметрами [cite: 13, 57, 67]
    public Patient (int patientId, String fullName, int age, String bloodType) {
        this.patientId = patientId; // Использование "this" [cite: 69]
        this.fullName = fullName;
        this.age = age;
        this.bloodType = bloodType;
    }

    // 3. Дефолтный конструктор [cite: 57, 70]
    public Patient() {
        this.fullName = "Unknown Patient";
        this.bloodType = "Unknown";
    }

    // 4. Геттеры и сеттеры для всех полей [cite: 57, 74, 79]
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getBloodType() { return bloodType; }
    public void setBloodType(String bloodType) { this.bloodType = bloodType; }

    // 5. Дополнительные методы с логикой (минимум 2) [cite: 14, 57, 84]
    public boolean isMinor() {
        return age < 18; // Логика проверки возраста [cite: 206]
    }

    public String getAgeCategory() {
        if (age < 13) return "Child";
        if (age < 60) return "Adult";
        return "Senior"; // Логика определения категории [cite: 206]
    }

    // 6. toString() [cite: 57, 90]
    @Override
    public String toString() {
        return "Patient{ID=" + patientId + ", Name='" + fullName + "', Age=" + age + ", Blood='" + bloodType + "'}";
    }
}