import Menu.Menu;
import Menu.StartMenu;

public class SurveySystem {
    public static void main(String[] args) {
        Menu menu = new StartMenu();

        while(true) {
            menu.display();
            menu.getInputAndExecute();
        }
    }
}

