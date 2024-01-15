package Menu;

class StartMenu extends Menu{
    protected StartMenu() {
        Option create = new Option("Create a new survey", StartMenu::loadCreateMenu);
        Option load = new Option("Load a survey", StartMenu::loadSurveyMenu);
        Option finish = new Option("Quit", () -> {
            System.out.println("End session");
            System.exit(0);
        });
        this.options.add(create);
        this.options.add(load);
        this.options.add(finish);
    }

    private static void loadCreateMenu() {
        SurveyFactoryMenu menuFactory = new SurveyFactoryMenu();
        Menu menu = menuFactory.getMenu("create menu");

        while(true) {
            menu.display();
            menu.getInputAndExecute();
        }
    }

    private static void loadSurveyMenu() {
        SurveyFactoryMenu menuFactory = new SurveyFactoryMenu();
        Menu menu = menuFactory.getMenu("survey menu");

        while(true) {
            menu.display();
            menu.getInputAndExecute();
        }
    }
}
