package edu.uwp.cs.csci212.assignments.a02.quizmaster;

/**
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs none
 */
public class QuestionMC extends Question {

    /*
     * character selection for multiple choice question
     */
    private char answer;

    /**
     * Default constructor for QuestionMC
     * Answer is set to 'a'
     */
    public QuestionMC() {
        answer = 'a';
    }

    /**
     * 1 arg constructor
     *
     * @param answer
     */
    public QuestionMC(char answer) {
        this.answer = answer;
    }

    /**
     * 3 arg constructor
     *
     * @param points
     * @param text
     * @param answer
     */
    public QuestionMC(int points, String text, char answer) {
        super(points, text);
        this.answer = answer;
    }

    /**
     * Accessor: returns answer
     * @return answer
     */
    public String getAnswer() {
        return answer + "";
    }

    /**
     * Mutator: sets new answer
     * @param answer
     */
    public void setAnswer(char answer) {
        this.answer = answer;
    }

    /**
     * toString(): returns String representation of QuestionMC
     * @return String representation of QuestionMC
     */
    @Override
    public String toString() {
        return "QuestionMC{ " +
                " question= " + getText() +
                " answer= " + answer +
                " points= " + getPoints() +
                '}';
    }
}
