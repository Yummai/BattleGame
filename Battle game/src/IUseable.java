public interface IUseable {
    String getName();
    boolean canBeUsed(Character target);
    void use();

}
