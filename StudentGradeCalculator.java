import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Grade Calculator");
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Initialize variables to store total marks and marks for each subject.
        int totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks (out of 100) for Subject " + i + ": ");
            int marks = scanner.nextInt();

            // Validate that marks are in the valid range (0-100).
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Marks should be between 0 and 100.");
                return;
            }

            totalMarks += marks;
        }

        // Calculate the average percentage.
        double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;

        // Determine the grade based on the average percentage.
        String grade;

        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display the results.
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
