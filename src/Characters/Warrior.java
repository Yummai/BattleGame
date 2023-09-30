package Characters;

import java.util.ArrayList;

import Attacks.Attack;

/**
 * Class representing a Warrior
 */
public class Warrior extends Character {
    ArrayList<Attack> list = new ArrayList<>();

    /**
     * Constuctor for Warrior
     *
     * @param name Name of Warrior
     */
    public Warrior(String name) {
        super(name, 50);
        list.add(new Attack("Sword Slash", 3, 5));
        list.add(new Attack("Spear Throw", 3, 10, 2));
        setList_of_attacks(list);
    }
}
