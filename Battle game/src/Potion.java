public class Potion extends Item {

    public String getName(){
        return "Healing Potion";
    }

    @Override
    public boolean canBeUsed(Character target) {
        return false;
    }


}
