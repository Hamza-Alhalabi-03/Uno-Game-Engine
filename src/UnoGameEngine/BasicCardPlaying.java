package UnoGameEngine;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BasicCardPlaying implements CardPlayingStrategy{

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    protected Scanner scanner = new Scanner(System.in);

    @Override
    public Card playCard(List<Card> cards, Card topCard, Color topColor, Player player) {
        List<Card> playerCards = player.getCards();
        System.out.println("\n\n"+player.getName() + "! it's your turn");
        System.out.println("This is the card on top:  "+ GREEN + topCard + RESET);
        System.out.println("Choose a card if you have a playable one: ");
        int numPlayableCards = 0;
        int index = 1;
        for (Card card : playerCards) {
            if (canPlayOnTop(card, topColor, topCard)) {
                numPlayableCards++;
                System.out.println(GREEN + index + "- " + card + RESET);
            }
            else {
                System.out.println(RED + index + "- " + card + RESET);
            }
            index++;
        }

        if(numPlayableCards == 0)return drawCards(cards, playerCards);

        return playerCards.remove(chosenCardIndex(playerCards,topColor, topCard));
    }

    @Override
    public boolean canPlayOnTop(Card card, Color topColor, Card topCard){
        if(card.getType() == CardType.WILD || card.getType() == CardType.WILD_DRAW_FOUR) return true;
        if(topCard.getType() == CardType.NUMBER && card.getType() == CardType.NUMBER){
            NumberedCard topNumber = (NumberedCard) topCard;
            NumberedCard cardNumber = (NumberedCard) card;
            if(topNumber.getNumber() == cardNumber.getNumber()) return true;
        }
        return topColor == card.getColor();
    }

    @Override
    public Card drawCards(List<Card> cards, List<Card> playerCards){
        System.out.println(RED + "No playable cards!" + RESET);
        System.out.println("You will draw one card");
        Random random = new Random();
        playerCards.add(cards.get(random.nextInt(cards.size())));
        return null;
    }


    private int chosenCardIndex(List<Card> playerCards, Color topColor, Card topCard) {
        System.out.println("Enter the card index that you would like to play: ");
        int cardIndex = 0;
        while (true){
            cardIndex = scanner.nextInt();
            if((cardIndex >= 1 && cardIndex <= playerCards.size())
                    && canPlayOnTop(playerCards.get(cardIndex - 1), topColor, topCard))
                break;
        }
        return cardIndex - 1;
    }
}