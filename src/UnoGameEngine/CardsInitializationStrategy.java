package UnoGameEngine;

import java.util.List;

public interface CardsInitializationStrategy {
    List<Card> initializeCards(CardFactory cardFactory);
}
