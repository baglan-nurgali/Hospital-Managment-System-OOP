public class Person {
    protected String name;
    protected int age;
    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }
    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unknown";
        } else {
            this.name = name;
        }
    }
    public int getAge() { return age; }

    public void setAge(int age) {
        if (age >= 0 && age <= 130) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }
    public void performAction() {
        System.out.println(name + " is performing a general action.");
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}