public class Appointment {
    private int appointmentId;
    private String patientName;
    private String doctorName;
    private String status; // "Scheduled", "Completed", "Cancelled"

    public Appointment(int appointmentId, String patientName, String doctorName, String status) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.status = status;
    }

    // Геттеры и сеттеры
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public int getAppointmentId() { return appointmentId; }

    // Дополнительные методы [cite: 206]
    public void cancel() {
        this.status = "Cancelled";
        System.out.println("Appointment " + appointmentId + " has been cancelled.");
    }

    public boolean isUpcoming() {
        return status.equalsIgnoreCase("Scheduled");
    }

    @Override
    public String toString() {
        return "Appointment{ID=" + appointmentId + ", Patient='" + patientName + "', Doctor='" + doctorName + "', Status='" + status + "'}";
    }
}