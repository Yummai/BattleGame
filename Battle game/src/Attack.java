import java.util.Random;
public class Attack {

    private String nazev;
    private int damage;
    private int random_damage;
    private Random rand = new Random();
    private int attackUsage;
    private int attackedUsed = 0;

    public Attack(String nazev, int damage, int random_damage, int attackUsage) {
        this.nazev = nazev;
        this.damage = damage;
        this.random_damage = random_damage;
        this.attackUsage = attackUsage;
    }

    public int getDamage() {
        return this.damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getRandom_damage() {
        return this.random_damage;
    }
    public void setRandom_damage(int damage) {
        this.damage = random_damage;
    }
    public String getNazev() {
        return this.nazev;
    }
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }
    public int dealDamage() {
        if(attackedUsed < attackUsage) {
            attackedUsed++;
            return rand.nextInt(random_damage) + damage;
        }
        if(attackUsage == 0) {
            return rand.nextInt(random_damage) + damage;
        }
            return 0;
    }
}
