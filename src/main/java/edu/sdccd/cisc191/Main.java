package edu.sdccd.cisc191;

import java.util.*;

public class Main implements StudentFilter {
    public static void main(String[] args) {
        
        // creating students
        String[] names = {
            "Ashley", "Bernard", "Cope", "Donald", "Emelia",
            "Francesca", "Geode", "Harold", "Iesha", "Jonald", 
            "Konnie", "Lactose", "Mike", "Nah", "Onamonapeia",
            "Pack", "Quincy", "Ronald", "Stacey", "Tammy",
            "Umbrella", "Victor", "Wonald", "Yonald", "Zonald"
        };
        
        Random rand = new Random();
        
        List<Student> roster = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nameIndex = rand.nextInt(names.length);
            String randomName = names[nameIndex];
            
            double randomGPA = Math.round(rand.nextDouble() * 4.0 * 10.0) / 10.0;
            
            int randomID = rand.nextInt(90000) + 10000;
            
            roster.add(new Student(randomName, randomGPA, randomID));
        }

        // demonstrating filtering

        /*
        This roster never get printed. You should also use a lambda and avoid having Main
        implement StudentFilter.
        */
        StudentFilter filter = new Main();
        roster = StudentAnalyzer.filter(roster, filter);
        
        // demonstrating sorting
        List<Student> sortedRoster = new ArrayList<>(roster);
        StudentAnalyzer.sort(sortedRoster, new Comparator<Student>() {
            /*Avoid not using the things required for the class and
            writing your own solution in Main, as you should be passing a lambda into this.
            Instead, you should do something like this:

             List<Student> sortedRoster = new ArrayList<>(studentList);

             Comparator<Student> comparatorS =
                    Comparator.comparingDouble(Student::getGpa).reversed()
                    .thenComparing(Student::getName);

            StudentAnalyzer.sort(sortedList, comparatorS);
            * */
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getGpa(), s1.getGpa());
            }
        });


        System.out.println("Roster: ");
        for (int i = 0; i < sortedRoster.size(); i++) {
            System.out.println("-" + sortedRoster.get(i));
        }

        // printing average GPA
        System.out.println("\nAverage GPA of Roster: ");
        System.out.print(String.format("%.2f", StudentAnalyzer.averageGpa(roster)));
    }
     // overriding interface method
    @Override
    public boolean test(Student student) {
        return student != null && !student.getName().trim().isEmpty();
    }
}