package it.unibo.oop.lab.advanced;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
/**
 * Class that implements a view that write in a stream.
 */
public class OutputView implements DrawNumberView {
    private final PrintStream stream;
    /**
     * Builds a new {@link OutputView}.
     * 
     * @param stream {@link PrintStream} where to write
     */
    public OutputView(final PrintStream stream) {
        this.stream = stream;
    }
    /**
     * Builds a new {@link OutputView}.
     * 
     * @param path the path where is the file
     * @throws FileNotFoundException
     */
    public OutputView(final String path) throws FileNotFoundException {
        stream = new PrintStream(new File(path));
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public void setObserver(final DrawNumberViewObserver observer) {
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public void start() {
    }
    /**
     * {@inheritDoc} 
     */
    @Override
    public void numberIncorrect() {
        stream.println("Number incorrect!!!");
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void result(final DrawResult res) {
        stream.println("The result is: " + res);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void displayError(final String message) {
        stream.println("Error: " + message);
    }

}
