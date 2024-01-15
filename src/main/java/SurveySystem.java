import Menu.Menu;
import Menu.SurveyFactoryMenu;

public class SurveySystem {
    public static void main(String[] args) {
        SurveyFactoryMenu menuFactory = new SurveyFactoryMenu();
        String menuName = "start menu";
        Menu menu = menuFactory.getMenu(menuName);

        while(true) {
            menu.display();
            menu.getInputAndExecute();
        }
    }
}

