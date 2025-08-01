package UnoGameEngine;

import java.util.ArrayList;
import java.util.List;

public class BasicCardsInitialization implements CardsInitializationStrategy {

    @Override
    public List<Card> initializeCards(CardFactory cardFactory){
        List<Card> cards = new ArrayList<>();

        for (Color color : Color.values()) {
            if (color != Color.WILD) {
                for (int i = 0; i <= 9; i++) {
                    cards.add(cardFactory.createNumberedCard(color, i));
                    if(i != 0){
                        cards.add(cardFactory.createNumberedCard(color, i));
                    }
                }
                for(int k = 1; k <= 2; k++) {
                    cards.add(cardFactory.createActionCard(color, CardType.SKIP));
                    cards.add(cardFactory.createActionCard(color, CardType.REVERSE));
                    cards.add(cardFactory.createActionCard(color, CardType.DRAW_TWO));
                }
            }
        }
        for(int j = 1; j <= 4; j++) {
            cards.add(cardFactory.createWildCard(CardType.WILD));
            cards.add(cardFactory.createWildCard(CardType.WILD_DRAW_FOUR));
        }
        return cards;
    }
}
