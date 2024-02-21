package edu.uwp.cs.csci212.assignments.a02.quizmaster;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * File modification class; Uses Scanner and PrintWriter objects to read
 * from input text files, and write to a desired text file.
 * <p>
 * Very rudimentary, (Also likely incorrect honestly) but works as intended
 *
 * @author Stevan Jovanovic
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs none
 */
public class FileInOut {

    /*
     * Default name for input File
     */
    public final String DEFAULTINFILENAME = "default_in.txt";

    /*
     * Default name for target File
     */
    public final String DEFAULTOUTFILENAME = "default_out.txt";

    /*
     * File object for input file
     */
    private File inFile = new File(DEFAULTINFILENAME);

    /*
     * File object that is the target file
     */
    private File outFile = new File(DEFAULTOUTFILENAME);

    /*
     * Scanner object to be used for reading files
     */
    private Scanner input;

    /*
     * PrintWriter object to be used to write files
     */
    private PrintWriter printer;

    /*
     * Declared name of input file
     */
    private String inFilename;

    /*
     * Declared name of target file
     */
    private String outFilename;

    /*
     * Declare boolean value that specifies whether the file is
     */


    public FileInOut(String inpFile, String outFile, boolean isOpen) {
        boolean canContinue = true;
        this.outFilename = outFile;
        this.inFilename = inpFile;

        // Uses boolean parameter to make sure that files should be opened
        if (isOpen) {
            while (canContinue) {
                try {
                    openFiles();
                    input = new Scanner(inFile);
                    canContinue = false;
                } catch (FileNotFoundException f) {
                    prompt();
                }
            }

            try {
                printer = new PrintWriter(outFile);
            } catch (Exception e) {
                System.exit(1);
            }

        } else {
            System.out.println("boolean isOpen is defined false in constructor, files therefore do not have read/write privileges");
            System.exit(1);
        }
    }

    /**
     * Closes input File using delete() method
     */
    public void closeInFile() {
        getInFile().close();
    }

    /**
     * Closes output File using delete() method
     */
    public void closeOutFile() {
        getOutFile().close();
    }

    /**
     * Closes both input and output Files in one method call
     */

    public void closeFiles() {
        closeInFile();
        closeOutFile();
    }

    /**
     * Opens input file using File object
     */
    private void openInFile() {
        this.inFile = new File(getInFilename());
    }

    /**
     * Opens target file to be written/edited as File object
     */
    private void openOutFile() {
        this.outFile = new File(getOutFilename());
    }

    /**
     * Meta-method that opens/creates both input and target files for reading and writing respectively
     */
    private void openFiles() {
        openInFile();
        openOutFile();
    }

    /**
     * Accessor: Returns PrintWriter object "printer" defined in constructor
     *
     * @return PrintWriter object initialized to read output File
     */
    public PrintWriter getOutFile() {
        return printer;
    }

    /**
     * Accessor: Returns Scanner object "input" defined in constructor
     *
     * @return Scanner object that reads input File
     */
    public Scanner getInFile() {
        return input;
    }

    /**
     * Accessor: returns target file name as string
     *
     * @return outFilename - String value of output filename
     */
    public String getOutFilename() {
        return outFilename;
    }

    /**
     * Accessor: returns input file name as string
     *
     * @return inFilename - String value of input filename
     */
    public String getInFilename() {
        return inFilename;
    }

    /**
     * Mutator: changes target file name
     *
     * @param newOutFileName - String parameter for new target filename
     */
    public void setOutFilename(String newOutFileName) {
        this.outFilename = newOutFileName;
    }

    /**
     * Mutator: changes input file name
     *
     * @param newInFileName - String parameter for new input filename
     */
    public void setInFilename(String newInFileName) {
        this.inFilename = newInFileName;
    }


    /**
     * Prompts user to re-enter the name of an input file if the input file parameter is
     * incorrect or inaccessible. In constructor, if a FileNotFoundException is caught,
     * this method is executed as many times as needed until a valid input file is found.
     * <p>
     * The output file is not checked this way, as the PrintWriter objects are able to
     * create files, even if the parameter File object doesn't point to an existing
     * filename
     * </p>
     */
    private void prompt() {
        System.out.print("Input file '" + getInFilename() + "' does not exist or is inaccessible :(\n" +
                "Would you like to enter a new input filename? (Y/N) ");
        Scanner reset = new Scanner(System.in);
        if (reset.next().equalsIgnoreCase("y")) {
            System.out.print("Enter new Filename - ");
            setInFilename(reset.next());
            System.out.println();
        } else {
            System.out.println("Could not read from given input file");
            System.exit(3);
        }
    }


}