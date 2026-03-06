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

    /*
    * This method returns nothing and does not follow the requirements. While the
    * defensive copy is a very smart choice to ensure nothing goes wrong, it
    * needs to be returned to affect the list. With your current method you also wouldn't let
    *  the sorting method be chosen with a lambda, as you don't implement comparator.
    * Instead, you should do something like this:
    *
    * static void sort(List<Student> list, Comparator<Student> comp) {
        list.sort(comp);
      }
    * */
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

        /*
        * gettingAvgGpa doesn't follow Java standard style, something like totalGpa might
        * be more appropriate.
        */
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