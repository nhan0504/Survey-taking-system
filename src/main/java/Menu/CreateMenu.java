package Menu;

class CreateMenu extends Menu{
    protected CreateMenu() {
        Option addQuestion = new Option("Add a new question", () -> System.out.println("adding question function"));
        Option finish = new Option("Finish", () -> {
            System.out.println("Save survey + End session");
            System.exit(0);
        });
        this.options.add(addQuestion);
        this.options.add(finish);
    }

    private void createSurvey() {

    }
}
