import Menu.Menu;
import Menu.MenuFactory;
import Menu.StartMenuFactory;

public class SurveySystem {
    public static void main(String[] args) {
//        Survey survey = new Survey();
//        Question<List<String>> shortAnswer = new ShortAnswer("What is your name");
//        survey.addQuestion(shortAnswer);


        MenuFactory menuFactory = new StartMenuFactory();
        Menu menu = menuFactory.createMenu();

        while(true) {
            menu.display();
            menu.getInputAndExecute();
        }
    }
}

