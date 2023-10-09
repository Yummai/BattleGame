package BattleEngine;

import Attacks.Attack;
import Characters.Character;
import Items.EffectsOverTime.Effects.Healing;
import Items.EffectsOverTime.Effects.Poision;
import Items.EffectsOverTime.Interafaces.EffectOverTime;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * Class simulating and handling a battle between two fighters
 */
public class Engine {
    private Character current_player;
    private Character opponent;
    private int current_attack = 1;
    private final Scanner scanner = new Scanner(System.in);

    public static LinkedList<EffectOverTime> effects = new LinkedList<>();

    /**
     * Constructor for battle between two players
     *
     * @param fighter1 First fighter
     * @param fighter2 Second fighter
     */
    public Engine(Characters.Character fighter1, Characters.Character fighter2) {
        this.current_player = fighter1;
        this.opponent = fighter2;
    }
    public void makeEffects() {
        effects.add(new Poision(current_player, 2, 3, 4));
        /* Iterate through all effects and make them happen  */
        Iterator<EffectOverTime> it = effects.iterator();
        while (it.hasNext()) {
            EffectOverTime e = it.next();
            e.makeEffect();
        }
    }
    /**
     * Starts battle between two fighters
     *
     * @param currentPlayerClass Class of first fighter
     * @param opponentClass      Class of second fighter
     */
    public void start(String currentPlayerClass, String opponentClass) {
        System.out.println("Let the battle begin!");

        /* While for battle until death */
        while (current_player.getHitpoints() > 0 && opponent.getHitpoints() > 0) {
            makeEffects();

            System.out.println("<=-=-=-=-=>HP<=-=-=-=-=>");
            System.out.println(current_player.getName() + " (" + currentPlayerClass + ") HP: " + current_player.getHitpoints());
            System.out.println(opponent.getName() + " (" + opponentClass + ") HP: " + opponent.getHitpoints());
            System.out.println("<=-=-=-=-=>**<=-=-=-=-=>");
            System.out.println("Actions for " + current_player.getName() + ":");

            /* Printing all attack that are available */
            for (Attack a : current_player.getList_of_attacks()) {
                if (a.canBeUsed()) {
                    System.out.println(current_attack + ".) " + a.getName());
                    current_attack++;
                }
            }

            /* Input protection of choosing attack */
            while (true) {
                try {
                    int choice = scanner.nextInt();
                    /* If choice is chosen wrongly, user will have to choose again. */
                    if (choice > 0 && current_player.getList_of_attacks().get(choice - 1) != null && current_player.getList_of_attacks().get(choice - 1).canBeUsed()) {
                        Attack curr = current_player.getList_of_attacks().get(choice - 1);
                        /* If Attack can be used, execute him */
                        if (curr.canBeUsed()) {
                            int damage = curr.useAttack();
                            System.out.println(current_player.getName() + " attacked with " + curr.getName() + " for " + damage);
                            opponent.setHitpoints(opponent.getHitpoints() - damage);
                            break;
                        }
                        /* If attack cant be used, send a message */
                        else {
                            System.out.println("Attacks " + curr.getName() + " is not available");
                        }
                    } else {
                        System.out.println("This attack does not exists, try one that exists ;)");
                    }
                } catch (Exception e) {
                    /* If user tries to write anything else than number */
                    System.out.println("Please, dont try to shut this program down :(");
                }
            }
            System.out.println();
            /* Switch fighers position - attacker becomes attacked. */
            Characters.Character temp = current_player;
            current_player = opponent;
            opponent = temp;
            current_attack = 1;
        }
        /* Check for winner */
        if (current_player.getHitpoints() <= 0) {
            System.out.println(opponent.getName() + " wins!");
        } else {
            System.out.println(current_player.getName() + " wins!");
        }
        scanner.close();
    }
}
