package edu.sdccd.cisc191;

public class Student {
    
    // creating private fields
    private final String name;
    private final double gpa; 
    private final int id; 
    
    // constructor validation
    public Student(String name, double gpa, int id) {
        if (name == null || name.trim().isEmpty() || gpa < 0.0 || gpa > 4.0 || id <= 0) {
            throw new IllegalArgumentException("This is not a valid input.");
        }
        this.name = name;
        this.gpa = gpa;
        this.id = id;
    }
    
    // field getters
    public String getName() { return name; }
    
    public double getGpa() { return gpa; }
    
    public int getId() { return id; }
    
    // toString() override
    @Override
    public String toString() { return "Student{id=" + id + ", name='" + name + "', gpa=" + gpa + "}"; }
}