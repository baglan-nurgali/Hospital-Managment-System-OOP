public class Doctor {
    private int doctorId;
    private String name;
    private String department;
    private boolean onDuty;

    public Doctor(int doctorId, String name, String department, boolean onDuty) {
        this.doctorId = doctorId;
        this.name = name;
        this.department = department;
        this.onDuty = onDuty;
    }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public boolean isOnDuty() { return onDuty; }
    public void setOnDuty(boolean onDuty) { this.onDuty = onDuty; }

    public void toggleDuty() {
        this.onDuty = !this.onDuty;
    }

    public String getContactFormat() {
        return "Dr. " + name + " (" + department + ")";
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + doctorId + ", name='" + name + '\'' + ", dept='" + department + '\'' + ", active=" + onDuty + '}';
    }
}