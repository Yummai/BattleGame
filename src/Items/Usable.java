package Items;

public interface Usable {
    String getName();

    boolean canBeUsed();

    void use(Character ch);
}
