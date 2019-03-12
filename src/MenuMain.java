import menu.Menu;
import menu.text.TextMenu;

/**
 * start the main menu
 */
public class MenuMain {
    public static void main(String[] args) {
        Menu menu = new TextMenu();
        menu.start();
    }
}
