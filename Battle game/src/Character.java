import java.util.Random;
import java.util.Scanner;
abstract class Character {
    String name;
    int hitpoints;
    Attack basic_attack;
    Attack special_attack;

    public Character (String name, Attack basic_attack, Attack special_attack, int hitpoints)
    {
        this.name = name;
        this.basic_attack = basic_attack;
        this.special_attack = special_attack;
        this.hitpoints = hitpoints;
    }
    public String getName() {
        return name;
    };
    public int getHitpoints(){
        return hitpoints;
    }
}
