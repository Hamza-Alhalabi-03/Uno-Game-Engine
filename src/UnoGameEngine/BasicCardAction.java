package UnoGameEngine;

import java.util.List;
import java.util.Random;

public class BasicCardAction implements CardActionStrategy {
    @Override
    public void drawCards(List<Card> cards, Player player, int numOfCards) {
        Random random = new Random();
        for (int i = 1; i <= numOfCards; i++) {
            int randomIndex = random.nextInt(cards.size());
            player.addCard(cards.remove(randomIndex));
        }
        System.out.println("Player " + player.getName() + " draws " + numOfCards + " cards");
    }
}
