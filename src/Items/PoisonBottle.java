package Items;

import Characters.Character;

public class PoisonBottle extends Item {

    /**
     * Getter for item name
     *
     * @return Item name
     */
    @Override
    public String getName() {
        return "Poison bottle";
    }

    /**
     * Checks if Item can be used
     *
     * @return Boolean true / false
     */
    @Override
    public boolean canBeUsed(Character character) {
        return false;
    }
}
