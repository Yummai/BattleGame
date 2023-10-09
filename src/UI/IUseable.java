package UI;

import Characters.Character;

/**
 * Class for usable items
 */
public interface IUseable {
    /**
     * Abstract method - Getter for item name
     *
     * @return Item name
     */
    String getName();


    /**
     * Abstract method - Checks if Item can be used
     *
     * @return Boolean true / false
     */
    boolean canBeUsed(Character character);


    /**
     * Abstract method - Uses item
     */
    void use(Character ch);

}
