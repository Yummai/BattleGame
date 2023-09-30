import java.util.Random;

public class Mage extends Character {
    private int secAttackCount;
    public Mage(String name) {
        super(name, "Arcane Bolt","Arcane Blast", 50);
        secAttackCount = 0;
    }

    @Override
    public String getAttackName(){
        return "Arcane Bolt";
    }
    @Override
    int attack() {
        return new Random().nextInt(8) + 1;
    }

    @Override
    public String getSecAttackName(){
        return "Arcane Blast";
    }
    @Override
    protected int secAttack() {
        if (secAttackCount < 2) {
            secAttackCount++;
            return new Random().nextInt(15) + 1;
        } else {
            System.out.println(name + " cant use "+ getSecAttackName() + " anymore !!");
            return 0;
        }
    }
}