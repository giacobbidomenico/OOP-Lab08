package it.unibo.oop.lab.advanced;

/**
 * This class implements a configuration manager.
 */
public class Configuration {
    private int min;
    private int max;
    private int attempts;
    /**
     * Builds a new {@link Configuration}.
     * 
     * @param min the minimum value
     * @param max the maximum value
     * @param attempts the number of attempts
     */
    public Configuration(final int min, final int max, final int attempts) {
        this.min = min;
        this.max = max;
        this.attempts = attempts;
    }
    /**
     * Builds a new {@link Configuration}. 
     */
    public Configuration() {
        this(0, 0, 0);
    }
    /**
     * Set the minimum value.
     * @param min the minimum value
     */
    public void setMin(final int min) {
        this.min = min;
    }
    /**
     * Set the maximum value.
     * @param max the maximum value
     */
    public void setMax(final int max) {
        this.max = max;
    }
    /**
     * Set the number of attempts.
     * @param attempts the number of attempts
     */
    public void setAttempts(final int attempts) {
        this.attempts = attempts;
    }
    /**
     * @return returns the minimum value
     */
    public int getMin() {
        return this.min;
    }
    /**
     * @return returns the maximum value
     */
    public int getMax() {
        return this.max;
    }
    /**
     * @return returns the number of attempts
     */
    public int getAttempts() {
        return this.attempts;
    }
    /**
     * @return true if the configuration is valid
     *         false otherwise
     */
    public boolean isValidConfiguration() {
        return this.max > this.min && this.attempts > 0; 
    }
}
