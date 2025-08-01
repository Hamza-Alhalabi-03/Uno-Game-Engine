package UnoGameEngine;

import java.util.Objects;

public class NumberedCard extends Card{
    private final int number;

    public int getNumber() {
        return number;
    }

    public NumberedCard(Color color, CardType type, int number) {
        super(color, type);
        this.number = number;
    }

    @Override
    public String toString() {
        return super.toString() + ", "+
                "number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NumberedCard card)) return false;
        return getColor() == card.getColor() && getType() == card.getType() && getNumber() == card.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumber());
    }
}













