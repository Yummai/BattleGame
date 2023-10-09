package Items.EffectsOverTime.Effects;

import Characters.Character;
import Items.EffectsOverTime.Interafaces.EffectOverTime;

public class Healing extends EffectOverTime {
    private int duration;

    private int min_health;

    private int max_health;

    public Healing(Character ch, int duration, int min_health, int max_health) {
        super(ch, duration);
        this.min_health = min_health;
        this.max_health = max_health;
        setName("Healing potion");
    }

    /**
     * Make character heal portion of HP
     */
    public void makeEffect() {
        setDuration(getDuration() - 1);
        getCharacter().setHitpoints(getCharacter().getHitpoints() + (rand.nextInt(max_health - min_health) + min_health));
    }

}
