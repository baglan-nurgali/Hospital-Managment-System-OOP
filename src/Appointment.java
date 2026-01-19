public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private double cost;

    public Appointment(Doctor doctor, Patient patient, double cost) throws InvalidDataException {
        this.doctor = doctor;
        this.patient = patient;
        setCost(cost);
    }

    public void setCost(double cost) throws InvalidDataException {
        if (cost < 0) throw new InvalidDataException("Cost cannot be negative!");
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Appointment: Doctor " + doctor.getName() + " is seeing " + patient.getName() + " (Cost: $" + cost + ")";
    }
}