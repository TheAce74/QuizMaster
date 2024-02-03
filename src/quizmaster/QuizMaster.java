package quizmaster;

import java.util.Scanner;

public class QuizMaster {

    public static void main(String[] args) {
        //operands to be used to form operations
        int[] operands = {8, 9, 5, 15, 7, 12, 6, 11, 18, 13};
        
        //arrays to store operation strings and their corresponding solutions - had to use dummy placeholders cus java arrays are static
        String[] operations = {"", "", "", "", "", "", "", "", "", ""};
        int[] solutions = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        //getting n random operations and solutions - future devs can adjust n as they see fit
        int n = 10;
        for(int i = 0; i < n; i++) {
            int random1 = randomizer(operands);
            int random2 = randomizer(operands);
            operations[i] = problemGenerator(operands[random1], operands[random2], i);
            solutions[i] = problemSolutionGenerator(operands[random1], operands[random2], i);
        }
        
        //welcome the user/student
        System.out.println("Hello from QuizMaster, prepare for your quizzes in a smart way \nYou have exactly 7 seconds to answer each question. Let's Go!");
        
        //initialize score array and scanner to take user input
        int[] scores = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Scanner scanner = new Scanner(System.in);
        
        //let the quizzing begin
        for(int i = 0; i < n; i++) {
            System.out.println("Question " + (i + 1) + ": " + operations[i]);
            double start = System.currentTimeMillis();
            int answer = scanner.nextInt();
            double stop = System.currentTimeMillis();
            if ((answer == solutions[i]) && (stop - start <= 7000)) {
                scores[i] = 1;
            }
        }
        
        //get total score and display it to the user
        int total = 0;
        while(n > 0) {
            total += scores[n - 1];
            --n;
        }
        System.out.println("You scored " + total + "/10");
    }
    
    static String problemGenerator(int x, int y, int index) {
        if (index % 2 == 0) {
            return x + " + " + y;
        } else {
            return x + " - " + y;
        }
    }
    
    static int problemSolutionGenerator(int x, int y, int index) {
        if (index % 2 == 0) {
            return x + y;
        } else {
            return x - y;
        }
    }
    
    static int randomizer(int[] operands) {
        int length = operands.length;
        int randomIndex = (int) Math.floor(Math.random() * length);
        return randomIndex;
    }
}
