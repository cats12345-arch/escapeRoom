public class Achievement {
    private String name;
    private boolean awarded;
    private String description;

    public Achievement(String name, boolean awarded, String description) {
        this.name = name;
        this.awarded = awarded;
        this.description = description;
    }

    
    public String toString() {
        return name + "\n" + description;
    }
}
