
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("================================");
        System.out.println("     STUDENT GRADE TRACKER");
        System.out.println("================================");

        int n;

        while (true) {
            System.out.print("Enter number of students: ");

            try {
                n = Integer.parseInt(sc.nextLine().trim());

                if (n > 0) {
                    break;
                }

                System.out.println("Enter at least 1 student.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        // Input student details
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine().trim();

            while (name.isEmpty()) {
                System.out.print("Name cannot be empty. Enter name: ");
                name = sc.nextLine().trim();
            }

            double marks;

            while (true) {
                System.out.print("Enter marks (0-100): ");

                try {
                    marks = Double.parseDouble(sc.nextLine().trim());

                    if (marks >= 0 && marks <= 100) {
                        break;
                    }

                    System.out.println("Marks must be between 0 and 100.");
                } catch (NumberFormatException e) {
                    System.out.println("Please enter valid marks.");
                }
            }

            students.add(new Student(name, marks));
        }

        // Calculate summary
        double total = 0;
        double highest = students.get(0).marks;
        double lowest = students.get(0).marks;
        String topper = students.get(0).name;
        String lowestStudent = students.get(0).name;

        for (Student s : students) {
            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
                topper = s.name;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
                lowestStudent = s.name;
            }
        }

        double average = total / students.size();

        // Display student report
        System.out.println("\n================================");
        System.out.println("         STUDENT REPORT");
        System.out.println("================================");

        System.out.printf("%-20s %s%n", "Student Name", "Marks");
        System.out.println("--------------------------------");

        for (Student s : students) {
            System.out.printf("%-20s %.2f%n", s.name, s.marks);
        }

        System.out.println("--------------------------------");
        System.out.printf("Average Marks : %.2f%n", average);
        System.out.printf("Highest Marks : %.2f (%s)%n",
                highest, topper);
        System.out.printf("Lowest Marks  : %.2f (%s)%n",
                lowest, lowestStudent);

        System.out.println("================================");
        System.out.println("Report generated successfully!");

        sc.close();
    }
}
