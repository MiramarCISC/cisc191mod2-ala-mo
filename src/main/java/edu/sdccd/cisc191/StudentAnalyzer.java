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
            Comparator.comparing(Student::getGPA).reversed()
                .thenComparing(Student::getName)
        );
        // return defensiveCopy;
    }
    
    // retrieving average GPA
    static double averageGPA(List<Student> students) {
        if (students.isEmpty()) {
            return 0.0;
        }
        
        double gettingAvgGPA = 0.0;
        for (Student s : students) {
            gettingAvgGPA += s.getGPA();
        }
        gettingAvgGPA = gettingAvgGPA / students.size();
        return gettingAvgGPA;
    }
    
    // overriding method from interface
    @Override
    public boolean test(Student student) {
        return student != null;
    }
}