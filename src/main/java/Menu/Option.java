package Menu;

public class Option {
    private String option;
    private Runnable action;

    public Option(String option, Runnable action) {
        this.option = option;
        this.action = action;
    }

    public String getOption() {
        return this.option;
    }

    public Runnable getAction() {
        return this.action;
    }
}
