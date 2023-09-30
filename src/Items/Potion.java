package Items;

import Characters.Character;

public class Potion extends Item {

    /**
     * Getter for item name
     *
     * @return Item name
     */
    @Override
    public String getName() {
        return "Healing bottle";
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
