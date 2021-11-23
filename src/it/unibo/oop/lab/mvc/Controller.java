package it.unibo.oop.lab.mvc;

import java.util.List;

/**
 * A controller that prints strings and has memory of the strings it printed.
 */
public interface Controller {

    /*
     * This interface must model a simple controller responsible of I/O access. It
     * considers only the standard output, and it is able to print on it.
     */
    /**
     * A method for setting the next string to print. Null values are not
     * acceptable, and an exception should be produced
     * 
     * @param message the string to print 
     */
    void setNextIntStringToPrint(String message);
    /**
     * A method for getting the next string to print.
     * 
     * @return the next String to print
     */
    String getNextStringToPrint();
    /**
     * A method for getting the history of the printed strings (in form of a List of Strings).
     * 
     * @return the history of printed Strings
     */
    List<String> getHistoryOfPrintedStrings();
    /**
     * A method that prints the current string. If the current string is unset,
     * an IllegalStateException should be thrown
     * 
     * @return the current String
     * @throws IllegalStateException
     */
    String printCurrentString();
}
