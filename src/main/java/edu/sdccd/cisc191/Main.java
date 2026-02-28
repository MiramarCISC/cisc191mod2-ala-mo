package edu.sdccd.cisc191;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // TODO create students
        List<Student> students = new ArrayList<>();

        students.add(new Student("Lexie", 4.0, 101));
        students.add(new Student("Ivy", 3.9, 102));
        students.add(new Student("Thomas", 2.5, 103));
        students.add(new Student("Lando", 3.2, 104));

        System.out.println("All Students:");
        students.forEach(System.out::println);

        // TODO demonstrate filtering
        List<Student> highGpaStudents =
                StudentAnalyzer.filter(students, s -> s.getGpa() > 3.0);

        System.out.println("\nFiltered Students (GPA > 3.0):");
        highGpaStudents.forEach(System.out::println);

        // TODO demonstrate sorting
        StudentAnalyzer.sort(students,
                Comparator.comparing(Student::getName));

        System.out.println("\nSorted by Name:");
        students.forEach(System.out::println);

        // TODO print average GPA
        double average = StudentAnalyzer.averageGpa(students);
        System.out.println("\nAverage GPA: " + average);
    }
}