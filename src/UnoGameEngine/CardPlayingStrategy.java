package UnoGameEngine;

import java.util.List;

public interface CardPlayingStrategy {
    Card playCard(List<Card> cards, Card topCard, Color topColor, Player player);
    boolean canPlayOnTop(Card card, Color topColor, Card topCard);
    Card drawCards(List<Card> cards, List<Card> playerCards);
}
