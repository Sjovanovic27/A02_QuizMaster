package edu.uwp.cs.csci212.assignments.a02.quizmaster;


import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs none
 */

/*
<Player’s first name>
<Player’s last name>
<Number of questions in this file>
<Question type: TF | SA> <Question point value>
<Question text>
<Question answer>
 */

public class QuizMaster {

    /*
     * ArrayList containing all the Question objects
     */
    private static ArrayList<Question> questionDb = new ArrayList<Question>();
    /*
     * Player object
     */
    private static Player player;

    /**
     * Gets the answer to the parameter question object
     * @param q object
     * @return answer to question
     * @throws ClassNotFoundException
     */
    private static String getAnswer(Question q) throws ClassNotFoundException {
        return switch (q) {
            case QuestionTF questionTF -> String.valueOf((questionTF.getAnswer()));
            case QuestionMC questionMC -> String.valueOf(questionMC.getAnswer());
            case QuestionSA questionSA -> questionSA.getAnswer();
            case null, default -> throw new ClassNotFoundException("Question object is invalid");
        };
    }

    private static void readPlayer(Scanner fileIn) {
        player = new Player(fileIn.next(), fileIn.next(), fileIn.nextInt());
        fileIn.nextLine();
    }

    private static void readQuestionMC(Scanner inFile, int points) {
        String question = inFile.nextLine();
        int numOfChoices = inFile.nextInt();
        String answers = "\n";
        inFile.nextLine();

        for(int i = 65; i < numOfChoices + 65; i++) {
            answers += "(" + (char)i + ") " + inFile.nextLine() + "\n";
        }
        questionDb.add(new QuestionMC(points, question + answers, inFile.next().charAt(0)));

        if(inFile.hasNext())
        inFile.nextLine();
    }
    private static void readQuestionTF(Scanner inFile, int points) {
        questionDb.add(new QuestionTF(points, inFile.nextLine(), inFile.nextBoolean()));

        if(inFile.hasNext())
        inFile.nextLine();
    }

    private static void readQuestionSA(Scanner inFile, int points) {
        questionDb.add(new QuestionSA(points, inFile.nextLine(), inFile.nextLine()));
    }
    private static void readQuestionsDb(Scanner inFile) {
        readPlayer(inFile);
        while(inFile.hasNext()) {
            String next = inFile.next();
            int points = inFile.nextInt();
            inFile.nextLine();

            switch (next) {
                case "MC":
                    readQuestionMC(inFile, points);
                    break;
                case "SA":
                    readQuestionSA(inFile, points);
                    break;
                case "TF":
                    readQuestionTF(inFile, points);
                    break;
                default:
                    throw new InputMismatchException("File was not read correctly");
            }
        }
    }

    private static void play(Scanner input) {
        System.out.println("***** QuizMaster *****\n");

            System.out.print("Please enter the name of the file containing the data: ");
            String filename = input.next();
            System.out.println();

            /*
             Because I'm the BEST, the FileInOut constructor will deal with all exceptions, and will prompt
             the user to re-input the filename in the event that it is incorrect
             */

            FileInOut game = new FileInOut(filename, "default.txt", true);

            readQuestionsDb(game.getInFile());





    }

    public static void main(String[] args) {
        play(new Scanner(System.in));
    }
}
