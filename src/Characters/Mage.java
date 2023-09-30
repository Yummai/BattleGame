package Characters;

import java.util.ArrayList;

import Attacks.Attack;

/**
 * Class representing a Mage
 */
public class Mage extends Character {
    ArrayList<Attack> list = new ArrayList<>();

    /**
     * Constuctor for Mage
     *
     * @param name Name of Mage
     */
    public Mage(String name) {
        super(name, 50);
        list.add(new Attack("Arcane Bolt", 1, 8));
        list.add(new Attack("Arcane Blast", 1, 15, 2));
        setList_of_attacks(list);
    }
}