public class Doctor extends Person {
    private String specialty;

    public Doctor(String name, int age, String specialty) {
        super(name, age);
        setSpecialty(specialty);
    }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) {
        this.specialty = (specialty == null || specialty.isEmpty()) ? "General Practice" : specialty;
    }

    @Override
    public void performAction() {
        System.out.println("Doctor " + name + " (Specialty: " + specialty + ") is treating patients.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Role: Doctor, Specialty: " + specialty;
    }
}