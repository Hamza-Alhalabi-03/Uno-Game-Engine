package UnoGameEngine;

import java.util.List;

public interface CardsDealingStrategy {
    void dealCards(List<Card> cards, List<Player> players);
}
