package edu.sdccd.cisc191;

public class Student {
    private final String name;
    private final double gpa;
    private final int id;

    public Student(String name, double gpa, int id) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (gpa < 0 || gpa > 4) {
            throw new IllegalArgumentException("GPA must be between 0 and 4");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        this.name = name;
        this.gpa = gpa;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + "ID:" + id + ", GPA:" + gpa + ")";
    }
}
