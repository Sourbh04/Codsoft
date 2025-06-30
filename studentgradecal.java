// Really excited to share my current task of Java Programming by CODSOFT. 
// This is a student grade calculator that takes input of marks and subjects from the user and gives us final grades, marks and percentage. 

import java.util.Scanner;

public class studentgradecal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("STUDENT GRADE CALCULATOR:\n" + "EVERY SUBJECT IS OF 100 MARKS!!!");
        System.out.print("Enter the number of subjects: ");
        int n = scanner.nextInt();
        int totalmarks = n * 100;

        int[] marks = new int[n];
        int obtainedMarks = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();

            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid marks. Please enter between 0 and 100: ");
                marks[i] = scanner.nextInt();
            }
            obtainedMarks += marks[i];
        }

        double percentage = (double) obtainedMarks / n;

        String grade;
        if (percentage >= 90) {
            grade = "A+ EXCELLENT";
        } else if (percentage >= 80) {
            grade = "A GOOD";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\nYour Final Result is:");
        System.out.println("Marks obtained: " + obtainedMarks);
        System.out.println("Out of " + totalmarks);
        System.out.printf("Average Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
