package UnoGameEngine;

import java.util.Objects;

public abstract class Card {
    private final Color color;
    private final CardType type;

    protected Card(Color color, CardType type) {
        this.color = color;
        this.type = type;
    }

    // Copy constructor
    public Card(Card other) {
        this.color = other.color;
        this.type = other.type;
    }

    public Color getColor() {
        return color;
    }

    public CardType getType() {
        return type;
    }


    @Override
    public String toString() {
        return "Card{" +
                "color=" + color +
                ", type=" + type;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Card card)) return false;
        return getColor() == card.getColor() && getType() == card.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getType());
    }
}











