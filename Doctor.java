public class Doctor extends Person {
    private String specialty;

    public Doctor(String name, int age, String specialty) throws InvalidDataException {
        super(name, age);
        this.specialty = specialty;
    }

    @Override
    public void performAction() {
        System.out.println("Doctor " + name + " is examining patients in " + specialty);
    }

    @Override
    public String getDetails() {
        return "[Doctor] " + toString() + ", Specialty: " + specialty;
    }
}