import java.util.Random;
import java.util.Scanner;
class Engine
    {
    private Character fighter1;
    private String fighter1Name;
    private String fighter1Class;
    private Character fighter2;
    private String fighter2Name;
    private  String fighter2Class;

    private int currentPowAttCount = 0;
    private int opponentPowAttCount = 0;

    private Scanner scanner = new Scanner(System.in);

    public Engine(Character fighter1, Character fighter2)
    {
        this.fighter1 = fighter1;
        this.fighter1Name = fighter1.getName();
        this.fighter1Class = fighter1.getClass().getSimpleName();
        this.fighter2 = fighter2;
        this.fighter2Name = fighter2.getName();
        this.fighter2Class = fighter2.getClass().getSimpleName();
    }

    public void start(String currentPlayerClass, String opponentClass)
    {
        System.out.println("Let the battle begin!");
        System.out.println("-----------------------");

        Character currentPlayer = fighter1;
        Character opponent = fighter2;
        String currentPlayerName = currentPlayer.getName();
        String opponentName = opponent.getName();

        while (fighter1.hitpoints > 0 && fighter2.hitpoints > 0) {

            System.out.println(currentPlayerName + " (" + currentPlayerClass + ") HP: " + currentPlayer.hitpoints);
            System.out.println(opponentName + " (" + opponentClass + ") HP: " + opponent.hitpoints);
            System.out.println();

            System.out.println("Actions for " + currentPlayerName + ":");
            System.out.println("1) " + currentPlayer.basic_attack.getNazev());
            if (currentPlayerClass.equals("Mage") || (currentPlayerClass.equals("Warrior") && currentPowAttCount < 2)) {
                System.out.println("2) " + currentPlayer.special_attack.getNazev());
                }
            //Missmatch input protection
            while (!scanner.hasNextInt()) {
                scanner.nextLine(); //clear the invalid input before prompting again
                System.out.print("Wrong, pick again ! ");
            }


            int choice = scanner.nextInt();
            int damage;

            switch (choice)
            {
                case 1:
                    damage = currentPlayer.attack();
                    System.out.println(currentPlayerName + " attacked with " + currentPlayer.getAttackName() + " for " );
                    opponent.hitpoints -= damage;
                    break;
                case 2:
                    if (currentPlayerClass.equals("Mage") || (currentPlayerClass.equals("Warrior") && currentPowAttCount < 2)) {
                        damage = currentPlayer.secAttack();
                        System.out.println(currentPlayerName + " (" + currentPlayerClass + ") attacked with " + currentPlayer.getAttackName() + " for ");
                        opponent.hitpoints -= damage;
                        currentPowAttCount++;
                    } else {
                        System.out.println("Powerful attack is not available.");
                    }
                    break;
                default:
                    System.out.println("You got two options and still managed to fuck it up, so enjoy your nothing you retarded monkey");
                    System.out.println("---------------------------------------");
            }
            System.out.println();

            // Swap players and classes for the next turn
            Character temp = currentPlayer;
            currentPlayer = opponent;
            opponent = temp;
            String tempClass = currentPlayerClass;
            currentPlayerClass = opponentClass;
            opponentClass = tempClass;
            String tempName = currentPlayerName;
            currentPlayerName = opponentName;
        }

        if (fighter1.hitpoints <= 0)
        {
            System.out.println(fighter2.name + " wins!");
        } else {
            System.out.println(fighter1.name + " wins!");
        }

        scanner.close();
    }
}
