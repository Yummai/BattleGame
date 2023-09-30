import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pickYourClass = 0;
        ArrayList<String> classes = new ArrayList<String>();
        Character fighter1 = null;
        Character fighter2 = null;
        String currentPlayerClass = "";
        String oponentClass = "";

        System.out.println("Welcome to the arena !");
        System.out.println("--------------------------");

        // First player + name and class
        System.out.print("Hello everyone once again, here comes our first brave Gladiator !: ");
        String name1 = scanner.nextLine();
        System.out.println(name1);

        System.out.println("Pick your class :");
        System.out.println("1) Mage");
        System.out.println("2) Warrior");
        int choice = 0;
        while (choice!= 1 && choice!=2) {
            choice = scanner.nextInt();
            if(choice != 1 && choice != 2) {
                System.out.println("Wrong!");
            }
        }
        pickYourClass = scanner.nextInt();

            switch (pickYourClass){
                case 1:
                    fighter1 = new Mage(name1);
                    currentPlayerClass = "Mage";
                    System.out.println(name1 + " selected class Mage");
                    break;
                case 2:
                    fighter1 = new Warrior(name1);
                    currentPlayerClass = "Warrior";
                    System.out.println(name1 + " selected class Warrior");
                    break;
                default:
                    System.out.println("Select valid choice you dumbasss !!");
            }
        System.out.println();

        scanner.nextLine();

        // Second player + name and class
        System.out.print("Not so far behind, we got our second competitor ! :");
        String name2 = scanner.nextLine();
        System.out.println(name2);

        System.out.println("Pick your class :");
        System.out.println("1) Mage");
        System.out.println("2) Warrior");


        while (!scanner.hasNextInt())
        {
            scanner.nextLine(); //clear the invalid input before prompting again
            System.out.print("Wrong, pick again ! ");
        }

        pickYourClass = scanner.nextInt();

        switch (pickYourClass){
            case 1:
                fighter2 = new Mage(name2);
                oponentClass = "Mage";
                System.out.println(name2 + " selected class Mage");
                break;
            case 2:
                fighter2 = new Warrior(name2);
                oponentClass = "Warrior";
                System.out.println(name2 + " selected class Warrior");
                break;
            default:
                System.out.println("Select valid choice you dumbass !!");
        }
        System.out.println();

        Engine engine = new Engine(fighter1, fighter2);
        engine.start(currentPlayerClass,oponentClass);

        scanner.close();
    }
}