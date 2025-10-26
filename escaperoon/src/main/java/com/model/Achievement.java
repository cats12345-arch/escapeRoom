package com.model;

/**
 * The achievement class which store data for different achievements
 * @author daniel
 */
public class Achievement {
    private String name;
    private boolean awarded;
    private String description;

    /**
     * The constuctor for the achievement class
     * @param name The name of the achievement
     * @param awarded If the achievement has been awarded
     * @param description The description of the achievement
     */
    public Achievement(String name, boolean awarded, String description) {
        this.name = name;
        this.awarded = awarded;
        this.description = description;
    }

    /**
     * A method that will return the String of the name of the achievement
     * @return a String of the name of the achievement
     */
    public String getName() {
        return this.name;
    }

    /**
     * A method that will return the Boolean of if the achievment is awarded
     * @return returns a boolean of if the achievemnt is awarded
     */
    public boolean getAwarded() {
        return awarded;
    }

    /**
     * A method that will return a String of the description of the achievement
     * @return a String of the description of the achievement
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Allows the system to toggle if the achievement has been earned
     * @param bool true if achievement has been earned
     */
    public void setAwarded(Boolean bool) {
        this.awarded = bool;
    }
    
    /**
     * A toString method that is used for debugging
     * @return A string with info about the achivement
     */
    public String toString() {
        return name + "\n" + description;
    }
}
