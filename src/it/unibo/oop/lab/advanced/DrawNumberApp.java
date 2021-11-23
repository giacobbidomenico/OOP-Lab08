package it.unibo.oop.lab.advanced;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.List;

/**
 * This class shows views.
 */
public final class DrawNumberApp implements DrawNumberViewObserver {
    private final DrawNumber model;
    private final List<DrawNumberView> views; 
    /**
     * Builds a new {@link DrawNumberApp}.
     * 
     * @param configFile file where to get the game configuration
     * @param views views implemented
     */
    public DrawNumberApp(final String configFile, final DrawNumberView...views) {
        this.views = Arrays.asList(Arrays.copyOf(views, views.length));
        for (final DrawNumberView view : views) {
            view.setObserver(this);
            view.start();
        }
        final Configuration conf = new Configuration();
        try (
            BufferedReader stream = new BufferedReader(
                    new InputStreamReader(
                            ClassLoader.getSystemResourceAsStream(configFile)));
        ) {
            for (String line = stream.readLine(); line != null; line = stream.readLine()) {
                final StringTokenizer st = new StringTokenizer(line, ":");
                if (st.countTokens() == 2) {
                    final String key = st.nextToken();
                    final int value = Integer.parseInt(st.nextToken().trim());
                    switch (key) {
                    case "maximum":
                        conf.setMax(value);
                        break;
                    case "minimum":
                        conf.setMin(value);
                        break;
                    case "attempts":
                        conf.setAttempts(value);
                        break;
                    default:
                        displayError("Format of the configuration file wrong!!");
                        break;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            displayError("Error, wrong reading from the configuration file!!");
        }
        if (conf.isValidConfiguration()) {
            this.model = new DrawNumberImpl(conf);
            System.out.println(conf.getMin());
        } else {
            this.model = null;
            displayError("Error, wrong configuration!!!");
            throw new IllegalArgumentException("Invalid configuration");
        }
    }
    /**
     * Shows the error message in all views.
     * 
     * @param message the message to show
     */
    private void displayError(final String message) {
        for (final DrawNumberView view: this.views) {
            view.displayError(message);
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void newAttempt(final int n) {
        try {
            final DrawResult result = model.attempt(n);
            for (final DrawNumberView view : this.views) {
                view.result(result);
            }
        } catch (IllegalArgumentException e) {
            for (final DrawNumberView view : this.views) {
                view.numberIncorrect();
            }
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void resetGame() {
        this.model.reset();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void quit() {
        System.exit(0);
    }
    /**
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(final String... args) throws FileNotFoundException {
        new DrawNumberApp(
                "config.yml",
                new DrawNumberViewImpl(),
                new DrawNumberViewImpl(),
                new DrawNumberViewImpl(),
                new OutputView("output.log"),
                new OutputView(System.out));
    }

}
