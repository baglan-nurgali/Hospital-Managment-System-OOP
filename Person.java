public abstract class Person implements HospitalOperations {
    protected String name;
    protected int age;

    public Person(String name, int age) throws InvalidDataException {
        setName(name);
        setAge(age);
    }

    public void setName(String name) throws InvalidDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidDataException("Name cannot be empty!");
        }
        this.name = name;
    }

    public void setAge(int age) throws InvalidDataException {
        if (age < 0 || age > 120) {
            throw new InvalidDataException("Age must be between 0 and 120!");
        }
        this.age = age;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}