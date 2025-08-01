package UnoGameEngine;

public class WildCard extends Card{
    public WildCard(Color color, CardType type) {
        super(color, type);
    }

    @Override
    public String toString() {
        return super.toString() + '}';
    }
}
