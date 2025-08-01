package UnoGameEngine;


public abstract class CardFactory {

    public abstract Card createNumberedCard(Color color, int number);

    public abstract Card createActionCard(Color color, CardType type);

    public abstract Card createWildCard(CardType type);
}
