package edu.uwp.cs.csci212.assignments.a02.quizmaster;

/**
 * QuestionSA is an extension of Question, and encapsulate questions that have
 * one word answers.
 *
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs none
 */
public class QuestionSA extends Question{
    /*
     * QuestionSA short answer
     */
    private String answer;

    /**
     * Default constructor
     */
    public QuestionSA() {
        this.answer= "";
    }

    /**
     * 1 arg constructor
     * @param answer
     */
    public QuestionSA(String answer) {
        this.answer = answer;
    }


    /**
     * 3 arg constructor
     * @param points
     * @param text
     * @param answer
     */
    public QuestionSA(int points, String text, String answer) {
        super(points, text);
        this.answer = answer;
    }

    /**
     * Accessor: gets answer as String
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Mutator: changes answer
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * toString(): returns String representation of QuestionSA
     * @return String representation of QuestionSA
     */
    @Override
    public String toString() {
        return " QuestionSA{ " +
                " question='" + getText() +
                " answer=' " + answer +
                " points= " + getPoints() +
                '}';
    }
}
