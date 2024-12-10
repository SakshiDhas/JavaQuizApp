import java.util.Scanner;

public class EnhancedQuizApp {
    public static void main(String[] args) {
        // Questions, options, and answers
        String[] questions = {
                "1. What is the size of an int variable in Java?",
                "2. Which of these is not a Java feature?",
                "3. Which keyword is used to define a class in Java?",
                "4. Which method is used to print in Java?",
                "5. What is the default value of a boolean variable in Java?",
                "6. Which package is imported by default in Java programs?",
                "7. Which operator is used to compare two values?",
                "8. What is the extension of Java bytecode files?"
        };

        String[][] options = {
                {"a) 2 bytes", "b) 4 bytes", "c) 8 bytes", "d) 1 byte"},
                {"a) Object-oriented", "b) Portable", "c) Use of pointers", "d) Platform-independent"},
                {"a) class", "b) struct", "c) int", "d) define"},
                {"a) System.out.print()", "b) printf()", "c) Console.log()", "d) echo()"},
                {"a) true", "b) false", "c) 0", "d) null"},
                {"a) java.util", "b) java.lang", "c) java.io", "d) java.net"},
                {"a) =", "b) ==", "c) equals()", "d) <>"},
                {"a) .class", "b) .java", "c) .byte", "d) .exe"}
        };

        char[] answers = {'b', 'c', 'a', 'a', 'b', 'b', 'b', 'a'};

        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("=================================");
        System.out.println("   Welcome to the Java Quiz!    ");
        System.out.println("=================================");
        System.out.println("Instructions:");
        System.out.println("- Answer by typing the letter (a, b, c, or d).");
        System.out.println("- You will receive your score and grade at the end.\n");

        boolean retry;
        do {
            int score = 0;

            // Loop through questions
            for (int i = 0; i < questions.length; i++) {
                System.out.println(questions[i]);
                for (String option : options[i]) {
                    System.out.println(option);
                }

                System.out.print("Your answer: ");
                char userAnswer = scanner.next().toLowerCase().charAt(0);

                // Validate answer
                if (userAnswer == answers[i]) {
                    System.out.println("\u001B[32mCorrect!\u001B[0m\n"); // Green text for correct
                    score++;
                } else {
                    System.out.println("\u001B[31mWrong.\u001B[0m The correct answer was: " + answers[i] + "\n"); // Red text for wrong
                }
            }

            // Calculate and display results
            double percentage = (double) score / questions.length * 100;
            System.out.println("=================================");
            System.out.println("           Quiz Over!            ");
            System.out.println("=================================");
            System.out.println("Your Score: " + score + "/" + questions.length);
            System.out.printf("Percentage: %.2f%%\n", percentage);

            // Grade
            if (percentage >= 90) {
                System.out.println("Grade: A (Excellent)");
            } else if (percentage >= 75) {
                System.out.println("Grade: B (Good Job)");
            } else if (percentage >= 50) {
                System.out.println("Grade: C (Needs Improvement)");
            } else {
                System.out.println("Grade: F (Try Again)");
            }

            // Retry option
            System.out.println("\nWould you like to retry the quiz? (yes/no): ");
            String retryInput = scanner.next().toLowerCase();
            retry = retryInput.equals("yes");

        } while (retry);

        System.out.println("\nThank you for playing! Goodbye!");
        scanner.close();
    }
}

