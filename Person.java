package model;

public abstract class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        setId(id);
        setName(name);
        setAge(age);
    }

    public abstract void performRole();

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name is empty");
        this.name = name;
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age < 0 || age > 120) throw new IllegalArgumentException("Invalid age");
        this.age = age;
    }
}