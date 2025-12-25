public class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private int experienceYears;

    public Doctor(int doctorId, String name, String specialization, int experienceYears) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    // Дополнительные методы [cite: 206]
    public boolean isExperienced() {
        return experienceYears > 10;
    }

    public boolean canPerformSurgery() {
        return specialization.equalsIgnoreCase("Surgeon") && experienceYears >= 5;
    }

    @Override
    public String toString() {
        return "Doctor{ID=" + doctorId + ", Name='" + name + "', Spec='" + specialization + "', Exp=" + experienceYears + "y}";
    }
}
