public class Patient {
    private int id;
    private String name;
    private int age;
    private String bloodGroup;

    public Patient(int id, String name, int age, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bloodGroup = bloodGroup;
    }

    public Patient() {
        this.name = "New Patient";
        this.bloodGroup = "Unknown";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public boolean isAdult() {
        return age >= 18;
    }

    public String getMedicalPriority() {
        return (age < 5 || age > 70) ? "High" : "Normal";
    }

    @Override
    public String toString() {
        return String.format("Patient[ID: %d, Name: %s, Age: %d, Blood: %s]", id, name, age, bloodGroup);
    }
}