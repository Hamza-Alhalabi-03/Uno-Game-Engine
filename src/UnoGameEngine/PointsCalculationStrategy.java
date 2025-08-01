package UnoGameEngine;

import java.util.List;

public interface PointsCalculationStrategy {
    int calculatePoints(List<Player> players, Player winner);
}
