package edu.uwp.cs.csci212.assignments.a02.quizmaster;

/**
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs none
 */
public abstract class Question {

    /*
     * int: point value of question
     */
    private int points;

    /*
     * String: text contents of question
     */
    private String text;

    /**
     * Default constructor
     */
    public Question() {
        this.text = null;
        this.points = 0;
    }

    /**
     * 2 arg constructor
     *
     * @param points
     * @param text
     */
    public Question(int points, String text) {
        this.points = points;
        this.text = text;
    }

    /**
     * Accessor: returns point value
     *
     * @return points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Accessor: returns text of question
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    public abstract String getAnswer();

    /**
     * Mutator: sets point value for question
     *
     * @param points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Mutator: sets text for question
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * toString(): returns question as String
     *
     * @return String representation of Question object
     */
    @Override
    public String toString() {
        return "Question{" +
                "question='" + text +
                "points=" + points +
                '}';
    }
}
