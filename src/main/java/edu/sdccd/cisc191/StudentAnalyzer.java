package edu.sdccd.cisc191;

import java.util.*;

public class StudentAnalyzer implements StudentFilter {
    
    // filtering through students
    static List<Student> filter(List<Student> students, StudentFilter filter) {
        List<Student> newArray = new ArrayList<>();
        
        for (Student s : students) {
            if (filter.test(s)) {
                newArray.add(s);
            }
        }
        return newArray;
    }
    
    // sorting students
    static void sort(List<Student> students, Comparator<Student> comparator) {
        List<Student> defensiveCopy = new ArrayList<>(students);
        
        Collections.sort(defensiveCopy,
            Comparator.comparing(Student::getGpa).reversed()
                .thenComparing(Student::getName)
        );
        // return defensiveCopy;
    }
    
    // retrieving average GPA
    static double averageGpa(List<Student> students) {
        if (students.isEmpty()) {
            return 0.0;
        }
        
        double gettingAvgGpa = 0.0;
        for (Student s : students) {
            gettingAvgGpa += s.getGpa();
        }
        gettingAvgGpa = gettingAvgGpa / students.size();
        return gettingAvgGpa;
    }
    
    // overriding method from interface
    @Override
    public boolean test(Student student) {
        return student != null;
    }
}