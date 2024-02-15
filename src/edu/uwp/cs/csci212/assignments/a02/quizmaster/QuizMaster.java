package edu.uwp.cs.csci212.assignments.a02.quizmaster;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs none
 */
public class QuizMaster {

    /*
     * ArrayList containing all of the Question objects
     */
    private ArrayList questionDb;
    /*
     * Player object
     */
    private Player player;

    /**
     * Gets the answer to the parameter question object
     * @param q object
     * @return answer to question
     * @throws ClassNotFoundException
     */
    public String getAnswer(Question q) throws ClassNotFoundException {
        return switch (q) {
            case QuestionTF questionTF -> String.valueOf((questionTF.getAnswer()));
            case QuestionMC questionMC -> String.valueOf(questionMC.getAnswer());
            case QuestionSA questionSA -> questionSA.getAnswer();
            case null, default -> throw new ClassNotFoundException("Question object is not valid");
        };
    }

    public void readPlayer(Scanner fileIn) {
        player = new Player(fileIn.next(), fileIn.next());
    }

    public void readQuestionMC(Scanner inFile, int points) {
        
    }

}
