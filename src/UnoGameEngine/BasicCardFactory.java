package UnoGameEngine;

public class BasicCardFactory extends CardFactory{
    @Override
    public Card createNumberedCard(Color color, int number) {
        if(number < 0 || number > 9){
            throw new IllegalArgumentException("Card number should be between 0 and 9");
        }
        return new NumberedCard(color, CardType.NUMBER, number);
    }

    @Override
    public Card createActionCard(Color color, CardType type) {
        if(type == CardType.NUMBER || type == CardType.WILD || type == CardType.WILD_DRAW_FOUR){
            throw new IllegalArgumentException("Action card type should be a suitable type");
        }
        return new ActionCard(color, type);
    }

    @Override
    public Card createWildCard(CardType type) {
        if(type == CardType.WILD || type == CardType.WILD_DRAW_FOUR){
            return new WildCard(Color.WILD, type);
        }
        throw new IllegalArgumentException("Wild card type should be a suitable type");
    }
}
