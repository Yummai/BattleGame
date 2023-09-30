package Attacks;

import java.util.Random;

/**
 * Class representing a special or basic attack
 */
public class Attack {

    private final String name;
    private final int damage;
    private final int random_damage;
    private final Random rand = new Random();
    private int castCapacity = -1; // -1 as basic attack, special attacks use second constructor
    private int attackUsed = 0;

    /**
     * Constructor for basic attack - no need for settings max casts
     *
     * @param name          - Name of attack
     * @param damage        - Minimum damage
     * @param random_damage - Random damage in addition to minimum damage
     */
    public Attack(String name, int damage, int random_damage) {
        this.name = name;
        this.damage = damage;
        this.random_damage = random_damage;
    }

    /**
     * Constructor for special attack with cooldown
     *
     * @param name          - Name of attack
     * @param damage        - Minimum damage
     * @param random_damage - Random damage in addition to minimum damage
     * @param attackUsage   - How many casts can be used before disabling
     */
    public Attack(String name, int damage, int random_damage, int attackUsage) {
        this.name = name;
        this.damage = damage;
        this.random_damage = random_damage;
        this.castCapacity = attackUsage;
    }

    /**
     * Getter for name of attack
     *
     * @return Name of attack
     */
    public String getName() {
        return this.name;
    }

    /**
     * Checks if attack can be used in turn
     *
     * @return If attack can be used in turn
     */
    public boolean canBeUsed() {
        if (castCapacity == -1) return true;
        return attackUsed < castCapacity;
    }

    /**
     * Generate a damage and increase the number of used attacks
     *
     * @return Damage
     */
    public int useAttack() {
        if (castCapacity == -1) return rand.nextInt(random_damage) + damage;
        if (attackUsed <= castCapacity) {
            attackUsed++;
            return rand.nextInt(random_damage) + damage;
        }
        return 0;
    }
}
