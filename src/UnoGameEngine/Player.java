package UnoGameEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private ArrayList<Card> cards = new ArrayList<>();
    private int cardCount = 0;
    private int points = 0;
    private final String name;
    
    public Player(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        cards.add(card);
        cardCount++;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", cards=" + cards +
                ", cardCount=" + cardCount +
                ", points=" + points +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player player)) return false;
        return cardCount == player.cardCount && points == player.points
                && Objects.equals(cards, player.cards)
                && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cards, cardCount, points);
    }

    public boolean hasWonRound() {
        return cards.isEmpty();
    }

    public int getCardCount() {
        return cardCount;
    }

    public void addPoints(int addedPoints) {
        points += addedPoints;
    }
}
