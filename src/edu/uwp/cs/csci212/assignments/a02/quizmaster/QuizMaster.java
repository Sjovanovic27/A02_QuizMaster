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
     *
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

    /**
     * Creates player object with parameters found from text file
     * @param fileIn
     */
    private static void readPlayer(Scanner fileIn) {
        player = new Player(fileIn.next(), fileIn.next(), fileIn.nextInt());
        fileIn.nextLine();
    }

    /**
     * Creates questionMC object by reading file and adds it to the ArrayList questionsDb
     * @param inFile
     * @param points
     */
    private static void readQuestionMC(Scanner inFile, int points) {

        // question represents actual prompt
        String question = inFile.nextLine();

        /*
         These lines format the answer options, and also add the character choice ((A), (B), etc.)
         in front of each choice. question and answer variables are then concatenated together in
         the constructor for the "text" parameter
         */

        int numOfChoices = inFile.nextInt();
        String answers = "\n";
        inFile.nextLine();

        for (int i = 65; i < numOfChoices + 65; i++) {
            answers += "(" + (char) i + ") " + inFile.nextLine() + "\n";
        }
        questionDb.add(new QuestionMC(points, question + answers, inFile.next().charAt(0)));

        if (inFile.hasNext()) inFile.nextLine();
    }

    /**
     * Creates questionTF object by reading file and adds it to the ArrayList questionsDb
     * @param inFile
     * @param points
     */
    private static void readQuestionTF(Scanner inFile, int points) {
        questionDb.add(new QuestionTF(points, inFile.nextLine(), inFile.nextBoolean()));

        if (inFile.hasNext()) inFile.nextLine();
    }

    /**
     * Creates questionSA object by reading file and adds it to the ArrayList questionsDb
     * @param inFile
     * @param points
     */
    private static void readQuestionSA(Scanner inFile, int points) {
        questionDb.add(new QuestionSA(points, inFile.nextLine(), inFile.nextLine()));
    }

    /**
     * This method calls all the readQuestion methods depending on what is defined in the text file.
     * It will keep iterating itself until all the file has been read
     *
     * @param inFile
     */
    private static void readQuestionsDb(Scanner inFile) {

        // reads player
        readPlayer(inFile);

        // Keeps iterating through file until it has been completely read
        while (inFile.hasNext()) {
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

    /**
     * The actual game
     *
     * <p>
     * This method is the only one called in the main method, and uses the console
     * to display all questions, and receive all answers. Every exception is handled properly,
     * and any incorrect input that could be provided by the player is properly checked, dealt with,
     * and re-prompted with an appropriate message associated with it.
     * </p>
     *
     * @param input
     */
    private static void play(Scanner input) {

        /*
         * Heading, and prompts user for text file name
         */
        System.out.println("***** QuizMaster *****\n");

        System.out.print("Please enter the name of the file containing the data: ");
        String filename = input.next();
        System.out.println();

        /*
         Because I'm the BEST, the FileInOut constructor will deal with all exceptions, and will prompt
         the user to re-input the filename in the event that it is incorrect
         */

        FileInOut game = new FileInOut(filename, "default.txt", true);

        /*
         Uses FileInOut object to access and read the input file. All questions are then addressed to an
         ArrayList object that contains Question objects
         */

        readQuestionsDb(game.getInFile());

        /*
         Prompts user for number of questions to answer from list, and does a check to make sure number is valid
         */
        System.out.println("Welcome to QuizMaster, " + player.getFirstName() + "!");
        System.out.print("How many Questions would you like to answer? (Out of " + questionDb.size() + ")");

        boolean canContinue = true;
        int numQs = 0;

        do {
            canContinue = true;
            try {
                numQs = input.nextInt();
                System.out.println();
            } catch (InputMismatchException e) {
                canContinue = false;
                System.out.println("\nPlease give a number");
            }
            if (numQs > questionDb.size() || numQs < 0) {
                canContinue = false;
                System.out.println("\nNumber is not in range");
            }

        } while (!canContinue);
        System.out.println();

        /*
         * THE START OF THE GAME
         */

        // to randomize questions
        int randomSelect;

        // calls correct number of questions specified
        for (int i = 0; i < numQs; i++) {

            System.out.println("Question " + (i + 1));
            randomSelect = (int) (Math.random() * questionDb.size());

            Question currentq = questionDb.get(randomSelect);

            // Removes question so that it can't be reselected
            questionDb.remove(randomSelect);

            // Prompts question
            System.out.println(currentq.getText());

            // Reads player answer, and gives appropriate response according to actual answer
            String answer = input.next();
            if (answer.equalsIgnoreCase(currentq.getAnswer())) {
                System.out.println("Correct! You get " + currentq.getPoints() + " points.");
                player.setScore(player.getScore() + currentq.getPoints());
            } else {
                System.out.println("Incorrect! No points awarded. \nThe correct answer was: " + currentq.getAnswer());

            }

            System.out.println("Your current point total is " + player.getScore() + "\n");
        }

        // End of game
        System.out.println("Game Finished! \n\nYour score was: " + player.getScore());
    }

    public static void main(String[] args) {
        try {
            play(new Scanner(System.in));
        } catch(InputMismatchException e) {
            System.out.println(e.getMessage());
            System.exit(2);
        }
    }
}
