package it.unibo.oop.lab.mvc;

import java.util.List;
import java.util.ArrayList;

/**
 * Implementation of a controller that prints strings and has memory of the strings it printed.
 */
public class ControllerImpl implements Controller {
    private String nextString;
    private final List<String> history;
    /**
     * Builds a new {@link ControllerImpl}.
     */
    public ControllerImpl() {
        history = new ArrayList<>();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setNextStringToPrint(final String message) {
        if (message != null) {
            this.nextString = message;
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String getNextStringToPrint() {
        return this.nextString;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getHistoryOfPrintedStrings() {
        return history;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void printCurrentString() {
        if (nextString == null) {
            throw new IllegalStateException();
        }
        history.add(this.nextString);
        System.out.println(this.nextString);
    }

}
