package Items;

import UI.IUseable;

/**
 * Sheet for creating an item
 */
abstract class Item implements IUseable {

    int itemCountLeft;

    /**
     * Getter for item name
     *
     * @return Item name
     */
    public String getName() {
        return null;
    }

    /**
     * Checks if Item can be used
     *
     * @return Boolean true / false
     */
    public boolean canBeUsed() {
        return false;
    }

    /**
     * Uses item
     */
    public void use() {
        System.out.println("In progress");
    }
}