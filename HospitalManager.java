import java.util.ArrayList;

public class HospitalManager {
    private ArrayList<Person> staff = new ArrayList<>();

    public void addPerson(Person person) {
        staff.add(person);
    }

    public void showAll() {
        for (Person p : staff) {
            System.out.println(p.getDetails());
            p.performAction();
        }
    }
}
