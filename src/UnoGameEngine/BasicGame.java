package UnoGameEngine;

import java.util.Scanner;

public class BasicGame extends Game{

    public BasicGame() {
        super(4,
                500,
                new BasicCardFactory(),
                new BasicCardsInitialization(),
                new BasicPlayersInitialization(),
                new BasicCardsDealing(),
                new BasicPointsCalculation(),
                new BasicCardPlaying(),
                new BasicCardAction()
        );
    }

    @Override
    public void playTurn() {
        Card temp = this.topCard;
        Card playedCard= cardPlaying.playCard(cards, topCard, topColor, players.get(currentPlayerIndex));
        if (playedCard != null) {
            if (playedCard.getType() == CardType.WILD || playedCard.getType() == CardType.WILD_DRAW_FOUR) {
                System.out.println("This is WILD card, you have to choose a color:");
                int index = 1;
                for (Color color : Color.values()) {
                    if (color == Color.WILD) break;
                    System.out.println(index + "- "+ color);
                    index++;
                }
                System.out.println("Enter a color index: ");
                Scanner scanner = new Scanner(System.in);
                int colorIndex;
                while (true){
                    colorIndex = scanner.nextInt();
                    if(colorIndex >= 1 && colorIndex <= 4) break;
                }
                this.topColor = Color.values()[colorIndex - 1];
            }
            this.topCard = playedCard;
            actionApplied = false;
            cards.add(temp);
        }
    }

    @Override
    public void applyCardAction() {
        if(actionApplied) return;
        actionApplied = true;
        if(topCard.getType() == CardType.NUMBER || topCard.getType() == CardType.WILD) return;

        switch (topCard.getType()){
            case SKIP:
                moveToNextPlayer();
                System.out.println("Skip " + players.get(currentPlayerIndex).getName() + "'s turn!");
                break;
            case REVERSE:
                isNormalTurnOrder = !isNormalTurnOrder;
                System.out.println("Reverse turn order!");
                if (numOfPlayers == 2) moveToNextPlayer();
                break;
            case DRAW_TWO:
                moveToNextPlayer();
                cardActionStrategy.drawCards(cards,players.get(currentPlayerIndex), 2);
                break;
            case WILD_DRAW_FOUR:
                moveToNextPlayer();
                cardActionStrategy.drawCards(cards,players.get(currentPlayerIndex), 4);
                break;
            default:
                break;
        }
    }
}
