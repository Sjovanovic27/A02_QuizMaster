package edu.uwp.cs.csci212.assignments.a02.quizmaster;

/**
 * @author Stevan Jovanovic (jovanovi)
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs none
 */
public class Player {

    /*
     * String: First name of player
     */
    private String firstName;

    /*
     * String: Last name of player
     */
    private String lastName;

    /*
     * int: Score of player
     */
    private int score;

    /**
     * Default constructor
     */
    public Player() {
        firstName = "";
        lastName = "";
        score = 0;
    }

    /**
     * 2 arg constructor
     *
     * @param firstName
     * @param lastName  score is set equal to 0
     */
    public Player(String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.score = 0;
    }

    /**
     * 3 arg constructor
     *
     * @param firstName
     * @param lastName
     * @param score
     */
    public Player(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    /**
     * Accessor: firstName variable
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Accessor: lastName variable
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Accessor: score variable
     *
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Mutator: firstName variable
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Mutator: lastName variable
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Mutator: score variable
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * toString(): returns player as String
     *
     * @return String representation of Player object
     */
    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", score=" + score +
                '}';
    }
}
