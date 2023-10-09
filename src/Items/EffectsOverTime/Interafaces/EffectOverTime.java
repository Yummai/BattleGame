package Items.EffectsOverTime.Interafaces;

import java.util.Random;

import Characters.Character;

public abstract class EffectOverTime {
    private String name;
    private int duration;

    private Character character;

    public Random rand = new Random();

    public EffectOverTime(Character character, int duration) {
        this.duration = duration;
        this.character = character;
    }

    /**
     * Make an effect that is supposed to happen
     */
    public void makeEffect() {
        setDuration(getDuration() - 1);
    }

    /**
     * Getter for name
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for duration
     *
     * @return duration
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * Setter for duration
     *
     * @param duration duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Setter for name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for character - player
     *
     * @param ch Character
     */
    public void setCharacter(Character ch) {
        this.character = ch;
    }

    /**
     * Getter for character
     *
     * @return Character
     */
    public Character getCharacter() {
        return this.character;
    }
}
