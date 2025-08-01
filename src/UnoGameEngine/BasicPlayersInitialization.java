package UnoGameEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicPlayersInitialization implements PlayersInitializationStrategy {
    @Override
        public List<Player> initializePlayers(int numOfPlayers) {
            List<Player> players = new ArrayList<Player>();
            Scanner scanner = new Scanner(System.in);

            for (int j = 0; j < numOfPlayers; j++) {
                System.out.println("Enter the name of player " + (j + 1));
                String name = scanner.nextLine();
                players.add(new Player(name));
            }

            return players;
    }
}
