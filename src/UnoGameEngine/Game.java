package UnoGameEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Game {
    protected List<Player> players;
    protected int numOfPlayers;
    protected List<Card> cards = new ArrayList<>();
    protected int pointsLimit;
    protected int currentPlayerIndex = 0;
    protected boolean isNormalTurnOrder = true;
    protected boolean actionApplied = false;
    protected Card topCard;
    protected Color topColor; // for WILD card chosen color
    protected CardFactory cardFactory;
    protected CardsInitializationStrategy cardsInitialization;
    protected PlayersInitializationStrategy playersInitialization;
    protected CardsDealingStrategy cardsDealing;
    protected PointsCalculationStrategy pointsCalculation;
    protected CardPlayingStrategy cardPlaying;
    protected CardActionStrategy cardActionStrategy;
    protected Player winner;

    public Game(int numOfPlayers,
                int pointsLimit,
                CardFactory cardFactory,
                CardsInitializationStrategy cardsInitialization,
                PlayersInitializationStrategy playersInitialization,
                CardsDealingStrategy cardsDealing,
                PointsCalculationStrategy pointsCalculation,
                CardPlayingStrategy cardPlaying,
                CardActionStrategy cardActionStrategy
    ) {
        this.numOfPlayers = numOfPlayers;
        this.pointsLimit = pointsLimit;
        this.cardFactory = cardFactory;
        this.cardsInitialization = cardsInitialization;
        this.playersInitialization = playersInitialization;
        this.cardsDealing = cardsDealing;
        this.pointsCalculation = pointsCalculation;
        this.cardPlaying = cardPlaying;
        this.cardActionStrategy = cardActionStrategy;
    }

    public final void play(){
        initializePlayers();
        do {
            initializeCards();
            initializeTopCard();
            dealCards();

            while (!playerWon()){ // Every time a player put a card
                playTurn();
                applyCardAction();
                moveToNextPlayer();
            }
            calculateRoundPoints();
        }
        while(!reachedPointsLimit()); // Every round
        announceWinner();
    }

    public void initializeCards() {
        cards.clear();
        this.cards = cardsInitialization.initializeCards(cardFactory);
    }

    protected void initializeTopCard(){
        Random random = new Random();
        List<Card> numberedCards = cards.stream()
                .filter(card -> card.getType().equals(CardType.NUMBER))
                .toList();
        int randomIndex = random.nextInt(numberedCards.size());
        this.topCard = numberedCards.get(randomIndex);
        this.topColor = topCard.getColor();
        cards.remove(this.topCard);
    }

    public void initializePlayers() {
        System.out.println("The game has started!");
        this.players = playersInitialization.initializePlayers(this.numOfPlayers);
    }

    public void dealCards() {
        cardsDealing.dealCards(this.cards, this.players);
    }

    public boolean playerWon(){
        for (Player player : players){
            if(player.hasWonRound()){
                winner = player;
                return true;
            }
        }
        return false;
    }

    public abstract void playTurn();

    public abstract void applyCardAction();

    public void moveToNextPlayer() {
        if(isNormalTurnOrder){
            currentPlayerIndex = (currentPlayerIndex + 1) % numOfPlayers;
        }
        else {
            currentPlayerIndex = (currentPlayerIndex - 1 + numOfPlayers) % numOfPlayers;
        }
    }

    public void calculateRoundPoints() {
        winner.addPoints(pointsCalculation.calculatePoints(players, winner));
        System.out.println("The round has finished!");
        System.out.println(winner.getName() + " won the round. They have " + winner.getPoints() + " points.");
        for (Player player : players){
            player.getCards().clear();
        }
    }

    public boolean reachedPointsLimit(){
        for (Player player : players){
            if(player.getPoints() >= pointsLimit){
                winner = player;
                return true;
            }
        }
        return false;
    }

    public void announceWinner() {
        System.out.println("\n\n\n\n\n");
        System.out.println("Congratulations " + winner.getName() + "!");
        System.out.println(winner.getName() + " won the game by achieving " + pointsLimit + " points!");
        System.out.println("\n\n\n\n\n");
    }

}
