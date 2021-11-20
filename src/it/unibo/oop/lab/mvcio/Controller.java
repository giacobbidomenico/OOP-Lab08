package it.unibo.oop.lab.mvcio;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * This class must implement a simple controller responsible of I/O access. It
 * considers a single file at a time, and it is able to serialize objects in it.
 */
public class Controller {
    private static final String HOME_DIRECTORY = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String DEFAULT_FILE = "output.txt";
    private File currentFile = new File(HOME_DIRECTORY + SEPARATOR + DEFAULT_FILE);
    /**
     * A method for setting a File as current file.
     * 
     * @param file
     */
    public void setCurrentFile(final File file) {
        final File parent = file.getParentFile();
        if (parent.exists()) {
            this.currentFile = file;
        } else {
            throw new IllegalArgumentException("Directory of the file doesn't exist");
        }
    }
    /**
     * A method for getting the current File.
     * 
     * @return the current file
     */
    public File getCurrentFile() {
        return this.currentFile;
    }
    /**
     * A method for getting the path (in form of String) of the current File.
     * 
     * @return the path of the current file (in a text form)
     */
    public String getCurrentFilePath() {
        return this.currentFile.getPath();
    }
    /**
     * A method that gets a String as input and saves its content on the current
     * file.
     * 
     * @param content
     * @throws IOException
     */
    public void save(final String content) throws IOException {
        try (PrintStream pstream = new PrintStream(this.currentFile)) {
            pstream.println(content);
        }
    }
}
