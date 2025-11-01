import java.util.Scanner;

public class OnlineQuiz {

    // A Question is represented by:
    // question text, 4 options, and the correct option letter
    static class MCQ {
        String questionText;
        String optionA;
        String optionB;
        String optionC;
        String optionD;
        char correct; // 'A', 'B', 'C', or 'D'

        MCQ(String q, String a, String b, String c, String d, char correct) {
            this.questionText = q;
            this.optionA = a;
            this.optionB = b;
            this.optionC = c;
            this.optionD = d;
            this.correct = Character.toUpperCase(correct);
        }

        void display() {
            System.out.println(questionText);
            System.out.println("A) " + optionA);
            System.out.println("B) " + optionB);
            System.out.println("C) " + optionC);
            System.out.println("D) " + optionD);
        }

        boolean isCorrect(char userAnswer) {
            return Character.toUpperCase(userAnswer) == correct;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        printHeader();

        System.out.print("Press Enter to start the quiz...");
        sc.nextLine(); // wait for user

        // Build questions (you can edit these easily)
        MCQ[] questions = new MCQ[] {
            new MCQ(
                "Which keyword is used to inherit a class in Java?",
                "super",
                "import",
                "extends",
                "implements",
                'C'
            ),
            new MCQ(
                "Which of these is NOT a primitive data type in Java?",
                "int",
                "boolean",
                "String",
                "float",
                'C'
            ),
            new MCQ(
                "Java code is compiled into:",
                "Machine code of OS",
                "Bytecode",
                "Python script",
                "Assembly",
                'B'
            ),
            new MCQ(
                "Which symbol is used to end a Java statement?",
                ".",
                ":",
                ";",
                ",",
                'C'
            ),
            new MCQ(
                "Which keyword is used to define a class in Java?",
                "class",
                "function",
                "object",
                "struct",
                'A'
            )
        };

        int score = 0;

        System.out.println("\n-----------------------------------------");
        System.out.println("              QUIZ STARTED");
        System.out.println("-----------------------------------------");
        System.out.println("Enter A / B / C / D for each question.\n");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + " of " + questions.length + ":");
            questions[i].display();

            System.out.print("Your answer: ");
            String ansInput = sc.nextLine().trim();
            char ans = ansInput.isEmpty() ? ' ' : ansInput.charAt(0);

            if (questions[i].isCorrect(ans)) {
                System.out.println("✔ Correct!\n");
                score++;
            } else {
                System.out.println("✘ Wrong.\n");
            }
        }

        // Calculate result
        int total = questions.length;
        double percent = (score * 100.0) / total;

        printResult(score, total, percent);

        System.out.println("\nThank you for using Online Quiz Application.");
        System.out.println("Developed using Core Java (OOP concepts, console-based assessment).");
        System.out.println("Future Scope: Web version with login, timer, and result storage.");
        System.out.println("-----------------------------------------");
    }

    private static void printHeader() {
        System.out.println("=========================================");
        System.out.println("        ONLINE QUIZ APPLICATION");
        System.out.println("=========================================");
        System.out.println("Features:");
        System.out.println(" - Multiple Choice Questions");
        System.out.println(" - Auto-checking of answers");
        System.out.println(" - Instant score and performance rating");
        System.out.println("-----------------------------------------\n");
    }

    private static void printResult(int score, int total, double percent) {
        System.out.println("\n============ QUIZ RESULT ============");
        System.out.println("Correct Answers : " + score + " / " + total);
        System.out.printf("Percentage      : %.2f%%\n", percent);

        System.out.print("Performance     : ");
        if (percent >= 80) {
            System.out.println("Excellent ✅");
        } else if (percent >= 60) {
            System.out.println("Good 🙂");
        } else if (percent >= 40) {
            System.out.println("Needs Improvement ⚠");
        } else {
            System.out.println("Weak ❌");
        }

        System.out.println("======================================");
    }
}
