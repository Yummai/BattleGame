package Items.EffectsOverTime.Effects;

import Characters.Character;
import Items.EffectsOverTime.Interafaces.EffectOverTime;

public class Poision extends EffectOverTime {

    private String name = "Poision";
    private int duration;
    private int min_health;
    private int max_health;

    public Poision(Character ch, int duration, int min_health, int max_health) {
        super(ch, duration);
        this.min_health = min_health;
        this.max_health = max_health;
        setName("Poision potion");
    }

    /**
     * Make character lose a portion of HP
     */
    public void makeEffect() {
        setDuration(getDuration() - 1);
        getCharacter().setHitpoints(getCharacter().getHitpoints() - (rand.nextInt(max_health - min_health) + min_health));
    }
}
