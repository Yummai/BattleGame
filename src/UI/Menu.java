package UI;

/**
 * Class for prints - usefull to not make Main class very heavy and hard to read in
 */
public class Menu {
    /**
     * Prints menu for choosing a class
     *
     * @param name Name of fighter to display
     */
    public static void printAllClases(String name) {
        System.out.println(name + ", pick your class!");
        System.out.println("1) Mage");
        System.out.println("2) Warrior");
    }
}
