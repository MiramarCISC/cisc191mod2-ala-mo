package edu.sdccd.cisc191;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

//filters students according to a provided StudentFilter
public class StudentAnalyzer {
    public static List<Student> filter(List<Student> students, StudentFilter filter) {
        List<Student> result = new ArrayList<>();

        for (Student s : students) {
            if (filter.test(s)) {
                result.add(s);
            }
        }
        return result;
    }
    //sorts students using the given comparator
    public static void sort(List<Student> students, Comparator<Student> comparator) {
        students.sort(comparator);
    }
    //calculates average gpa from the list of students
    public static double averageGpa(List<Student> students) {
        if (students.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (Student s : students) {
            total += s.getGpa();
        }
        return total / students.size();
    }
}
