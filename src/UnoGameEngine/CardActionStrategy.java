package UnoGameEngine;

import java.util.List;

public interface CardActionStrategy {
    void drawCards(List<Card> cards, Player player, int numOfCards);
}
