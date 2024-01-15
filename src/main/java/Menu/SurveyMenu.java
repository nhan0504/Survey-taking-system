package Menu;

class SurveyMenu extends Menu{

    protected SurveyMenu() {
        Option modify = new Option("Modify loaded survey", SurveyMenu::modifySurvey);
        Option take = new Option("Take loaded survey", SurveyMenu::takeSurvey);
        Option display = new Option("Display loaded survey", SurveyMenu::displaySurvey);
        Option quit = new Option("Quit", () -> {
            System.out.println("End session");
            System.exit(0);
        });
        this.options.add(modify);
        this.options.add(take);
        this.options.add(display);
        this.options.add(quit);
    }

    private static void takeSurvey() {
        System.out.println("Take survey");
    }

    private static void modifySurvey() {
        System.out.println("Run modify() function");
    }

    private static void displaySurvey() {
        System.out.println("Display survey");
    }
}
