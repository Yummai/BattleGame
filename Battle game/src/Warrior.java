import java.util.Random;

public class Warrior extends Character {

    public Warrior() {
        super(
                "Válečník",
                new Attack("Sword Slash",  3, 5, 0),
                new Attack("Spear Throw", 3, 10, 2),
                50
        );
    }
}
