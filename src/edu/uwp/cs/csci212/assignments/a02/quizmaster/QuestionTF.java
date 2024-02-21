package edu.uwp.cs.csci212.assignments.a02.quizmaster;

/**
 * QuestionTF is an extension of Question, and encapsulates Questions that
 * have true/false answers.
 *
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs none
 */
public class QuestionTF extends Question {
    /*
     * Answer to QuestionTF
     */
    private boolean answer;

    /**
     * Default constructor
     * answer = false
     */
    public QuestionTF() {
        this.answer = false;
    }

    /**
     * 1 arg constructor
     *
     * @param answer
     */
    public QuestionTF(boolean answer) {
        this.answer = answer;
    }

    /**
     * 3 arg constuctor
     *
     * @param points
     * @param text
     * @param answer
     */
    public QuestionTF(int points, String text, boolean answer) {
        super(points, text);
        this.answer = answer;
    }

    /**
     * Accessor: returns answer as String
     *
     * @return answer
     */
    public String getAnswer() {

        return answer + "";
    }

    /**
     * Mutator: changes answer variable
     *
     * @param answer
     */
    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    /**
     * toString(): returns String representation of QuestionTF
     * @return String representation of QuestionTF
     */
    @Override
    public String toString() {
        return "QuestionTF{" +
                " question= " + getText() +
                " answer= " + answer +
                " points= " + getPoints() +
                '}';
    }
}
