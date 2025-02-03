package assignment1;

public class Student {

    private String[] names;
    private double[] scores;
    private double average;
    private char letterGrade;

    /**
     * if no name or scores are provided
     * sets default values
     */
    public Student() {
        this(new String[]{"unknown"}, new double[]{0, 0, 0});
    }

    /**
     * sets student names and scores
     * calculates average and determines letter grade
     */
    public Student(String[] names, double[] scores) {
        setNames(names);
        setScores(scores);
    }

    /**
     * override of the toString method
     * returns a formatted string with student details
     */
    public String toString() {
        return String.format("Student: %s, Average: %.2f, Grade: %c", getFormattedNames(), average, letterGrade);
    }


    // sets student names, ensures at least one name is present
    private void setNames(String[] names) {
        this.names = (names.length == 0) ? new String[]{"unknown"} : names;
    }

    // sets student scores, calculates the average, and assigns a letter grade
    private void setScores(double[] scores) {
        this.scores = scores;
        calculateAverage();
        determineLetterGrade();
    }

    // calculates the average score from the scores array
    private void calculateAverage() {
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            double score = scores[i];
            sum += score;
        }
        average = sum / scores.length;
    }

    // determines the letter grade based on the calculated average
    private void determineLetterGrade() {
        if (average >= 90) {
            letterGrade = 'A';
        } else if (average >= 80) {
            letterGrade = 'B';
        } else if (average >= 70) {
            letterGrade = 'C';
        } else if (average >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }
    }

    // gets formatted student names (if multiple names exist)
    private String getFormattedNames() {
        return String.join(", ", names);
    }

    public String[] getNames() {
        return names;
    }

    public double getAverage() {
        return average;
    }

    public char getLetterGrade() {
        return letterGrade;
    }
}
