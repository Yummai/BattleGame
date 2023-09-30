package Characters;

import java.util.ArrayList;

import Attacks.Attack;

/**
 * Class representing a sheet for classes
 */
abstract public class Character {
    String name;
    private int hitpoints;
    ArrayList<Attack> list_of_attacks;

    /**
     * Constructor for creating a player - They have name based on their input
     *
     * @param name      - Their special name
     * @param hitpoints - Healthpoints
     */
    public Character(String name, int hitpoints) {
        this.name = name;
        this.hitpoints = hitpoints;
    }

    /**
     * Constructor for creating an enemy - They have name based on their class name.
     * Maybe not usefull right now, but could be used later for fighting AI
     *
     * @param hitpoints - Healthpoints
     */
    public Character(int hitpoints) {
        this.name = this.getClass().getName();
        this.hitpoints = hitpoints;
    }

    /**
     * Getter for name of character
     *
     * @return Name of character
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for Health Points of character
     *
     * @return Health Points
     */
    public int getHitpoints() {
        return hitpoints;
    }

    /**
     * Setter for Health Points
     *
     * @param hitpoints New health
     */
    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    /**
     * Getter for all atacks of a character
     *
     * @return ArrayList of attacks
     */
    public ArrayList<Attack> getList_of_attacks() {
        return list_of_attacks;
    }

    /**
     * Setter for list of attacks
     *
     * @param list_of_attacks new ArrayList of attacks
     */
    public void setList_of_attacks(ArrayList<Attack> list_of_attacks) {
        this.list_of_attacks = list_of_attacks;
    }
}
