package it.unibo.oop.lab.advanced;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
/**
 * 
 *
 */
public class OutputView implements DrawNumberView {
    private final PrintStream stream;
    /**
     * 
     * @param stream
     */
    public OutputView(final PrintStream stream) {
        this.stream = stream;
    }
    /**
     * 
     * @param path
     * @throws FileNotFoundException
     */
    public OutputView(final String path) throws FileNotFoundException {
        stream = new PrintStream(new File(path));
    }
    /**
     * 
     */
    @Override
    public void setObserver(final DrawNumberViewObserver observer) {
    }
    /**
     * 
     */
    @Override
    public void start() {
    }
    /**
     * 
     */
    @Override
    public void numberIncorrect() {
        stream.println("Number incorrect!!!");
    }
    /**
     * 
     */
    @Override
    public void result(final DrawResult res) {
        stream.println("The result is: " + res);
    }

    @Override
    public void limitsReached() {
    }
    /**
     * 
     */
    @Override
    public void displayError(final String message) {
        stream.println("Error: " + message);
    }

}
