package UnoGameEngine;

import java.util.List;
import java.util.Random;

public class BasicCardsDealing implements CardsDealingStrategy {
    public void dealCards(List<Card> cards, List<Player> players) {
        int numOfStartCards = 7;
        Random random = new Random();

        for(Player player : players){
            for(int i = 1; i <= numOfStartCards; i++){
                if (cards.isEmpty()) {
                    throw new IllegalStateException("Cannot draw a card from an empty list");
                }
                int randomIndex = random.nextInt(cards.size());
                player.addCard(cards.remove(randomIndex));
            }
        }

    }
}
