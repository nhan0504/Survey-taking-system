package Menu;

public class SurveyFactoryMenu implements MenuFactory {
    public Menu getMenu(String menu) {
        if (menu.equals("start menu")) {
            return new StartMenu();
        } else if(menu.equals("create menu")) {
            return new CreateMenu();
        } else {
            return new SurveyMenu();
        }
    }
}
