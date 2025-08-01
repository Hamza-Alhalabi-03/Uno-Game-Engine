package UnoGameEngine;

import java.util.List;

public class BasicPointsCalculation implements PointsCalculationStrategy {
    @Override
    public int calculatePoints(List<Player> players, Player winner) {
        int points = 0;
        for (Player player : players) {
            if(player.equals(winner))continue;

            for(Card card : player.getCards()){
                points += calculateCardPoints(card);
            }
        }
        return points;
    }

    private int calculateCardPoints(Card card) {
        if(card.getType() == CardType.NUMBER){
            NumberedCard numberedCard = (NumberedCard) card;
            return numberedCard.getNumber();
        } else if (card.getType() == CardType.DRAW_TWO ||
                card.getType() == CardType.SKIP ||
                card.getType() == CardType.REVERSE) {
            return 20;
        } else {
            return 50; // WILD cards
        }
    }
}
