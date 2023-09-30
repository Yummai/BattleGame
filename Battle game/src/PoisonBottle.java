public class PoisonBottle extends Item {

    @Override
    public String getName() {
        return "Bottle of Poison";
    }

    @Override
    public boolean canBeUsed(Character target) {
        return false;
    }
}
