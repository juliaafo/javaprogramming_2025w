package assignment1;

import java.util.Scanner;

public class GradeBook {
    public static void main(String[] args) {
        runGradeBook();
    }

    static void runGradeBook() {
        Scanner scanner = new Scanner(System.in); // scanner for user input

        // intro message
        System.out.println("welcome to the student grade management system");

        // asks how many students there are, making sure its between 1 and 50
        System.out.print("enter the number of students: ");
        int numStudents = scanner.nextInt();
        while (numStudents < 1 || numStudents > 50) {
            System.out.println("please enter a number between 1 and 50.");
            numStudents = scanner.nextInt();
        }

        scanner.nextLine(); // fixes input issue after using nextInt()

        // array to store student objects
        Student[] students = new Student[numStudents];

        // loop to collect student data
        for (int i = 0; i < numStudents; i++) {
            // ask for the student's names
            System.out.print("enter the name of student " + (i + 1) + ": ");
            String[] names = scanner.nextLine().split(",\\s*"); // split input by commas

            // ask for the number of scores (must be between 3 and 5)
            System.out.print("enter the number of scores for " + String.join(", ", names) + ": ");
            int numScores = scanner.nextInt();
            while (numScores < 3 || numScores > 5) {
                System.out.println("please enter a number between 3 and 5.");
                numScores = scanner.nextInt();
            }

            // create an array to store the scores
            double[] scores = new double[numScores];

            // loop to collect each score and make sure its valid (0-100)
            for (int j = 0; j < numScores; j++) {
                System.out.printf("enter score %d: ", j + 1);
                scores[j] = scanner.nextDouble();
                while (scores[j] < 0 || scores[j] > 100) {
                    System.out.println("invalid score. please enter a score between 0 and 100.");
                    scores[j] = scanner.nextDouble();
                }
            }

            scanner.nextLine(); // fixes input issue after nextDouble()
            students[i] = new Student(names, scores); // create a student object with names array
        }

        // print student grades
        System.out.println("\nstudent grades:");
        for (Student student : students) {
            System.out.printf("student: %s, average: %.2f, grade: %c%n",
                    String.join(", ", student.getNames()), student.getAverage(), student.getLetterGrade());
        }
    }
}
