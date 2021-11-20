package it.unibo.oop.lab.mvcio;

import java.io.File;

/**
 * 
 */
public class Controller {
    private static final String HOME_DIRECTORY = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String DEFAULT_FILE = "output.txt";
    private File currentFile = new File(HOME_DIRECTORY + SEPARATOR + DEFAULT_FILE);
    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     */ 
    /* 1) A method for setting a File as current file
     */
    /**
     * 
     * @param file
     */
    public void setCurrentFile(final File file) {
        if (file.exists()) {
            this.currentFile = file;
        } else {
            throw new IllegalArgumentException("File does not exist");
        }
    }
    /* 2) A method for getting the current File
     * 
     * 3) A method for getting the path (in form of String) of the current File
     * 
     * 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     * 
     * 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */

}
