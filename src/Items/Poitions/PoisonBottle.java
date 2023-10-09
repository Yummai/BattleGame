package Items.Poitions;

import BattleEngine.Engine;
import Characters.Character;
import Items.EffectsOverTime.Effects.Poision;
import Items.EffectsOverTime.Interafaces.EffectOverTime;
import Items.Item;

public class PoisonBottle extends Item {
    private String name = "Poision bottle";
    private boolean canBeUsed = true;

    /**
     * Getter for item name
     *
     * @return Item name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Checks if Item can be us
     *
     * @return Boolean true / false
     */
    @Override
    public boolean canBeUsed(Character character) {
        return canBeUsed;
    }

    /**
     * Will call a function to simulate use of potion
     *
     * @param character Character this effect will belong to
     */
    @Override
    public void use(Character character) {
        applyPoision(character);
    }

    /**
     * Apply poision to character
     *
     * @param character Character this effect will belong to
     */
    public void applyPoision(Character character) {
        Engine.effects.add(new Poision(character, 3, 2, 4));
    }
}
