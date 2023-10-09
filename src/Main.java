import BattleEngine.Engine;
import Characters.Mage;
import Characters.Warrior;
import Items.EffectsOverTime.Effects.Healing;
import UI.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class, you hopefully know what this does...
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pickYourClass = 0;
        Characters.Character fighter1 = null;
        Characters.Character fighter2 = null;
        String currentPlayerClass = "";
        String oponentClass = "";

        System.out.println("Welcome to the arena !");
        System.out.println("--------------------------");

        // First player + name and class
        System.out.print("Hello everyone once again, here comes our first brave Gladiator !: ");
        String name1 = scanner.nextLine();
        Menu.printAllClases(name1);
        while (pickYourClass != 1 && pickYourClass != 2) {
            try {
                pickYourClass = scanner.nextInt();
                if (pickYourClass != 1 && pickYourClass != 2) {
                    scanner.nextLine(); // Takes the wrong input out of our scanner - just fancy thing to not go infinite
                    System.out.println("Please, select a valid class!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please, do not try to shut this program down...");
                scanner.nextLine(); // Takes the wrong input out of our scanner - just fancy thing to not go infinite
            }
        }

        switch (pickYourClass) {
            case 1 -> {
                fighter1 = new Mage(name1);
                currentPlayerClass = "Mage";
                System.out.println(name1 + " selected class Mage");
            }
            case 2 -> {
                fighter1 = new Warrior(name1);
                currentPlayerClass = "Warrior";
                System.out.println(name1 + " selected class Warrior");
            }
            default -> System.out.println("Select a valid choice, you very not so smart boi!");
        }
        System.out.println();

        scanner.nextLine();

        // Second player + name and class
        System.out.print("Not so far behind, we got our second competitor ! :");
        String name2 = scanner.nextLine();
        Menu.printAllClases(name2);
        pickYourClass = 0;
        while (pickYourClass != 1 && pickYourClass != 2) {
            try {
                pickYourClass = scanner.nextInt();
                if (pickYourClass != 1 && pickYourClass != 2) {
                    System.out.println("Please, select a valid class!");
                    scanner.nextLine(); // Takes the wrong input out of our scanner - just fancy thing to not go infinite
                }
            } catch (InputMismatchException e) {
                System.out.println("Please, do not try to shut down this program...");
                scanner.nextLine(); // Takes the wrong input out of our scanner - just fancy thing to not go infinite
            }
        }

        switch (pickYourClass) {
            case 1 -> {
                fighter2 = new Mage(name2);
                oponentClass = "Mage";
                System.out.println(name2 + " selected class Mage");
            }
            case 2 -> {
                fighter2 = new Warrior(name2);
                oponentClass = "Warrior";
                System.out.println(name2 + " selected class Warrior");
            }
            default -> System.out.println("Select valid choice you dumbass !!");
        }
        System.out.println();

        Engine engine = new Engine(fighter1, fighter2);
        engine.start(currentPlayerClass, oponentClass);

        scanner.close();
    }
}