package org.rusaik.gesturegames.engine;

import org.rusaik.gesturegames.engine.game.RockPaperScissors;
import org.rusaik.gesturegames.engine.game.SwardsGuns;

import java.util.Optional;

public class GameFactory {
    public enum AvailableGames {
        ROCK_PAPER_SCISSORS,
        SWORDS_AND_GUNS,
        ODD_AND_EVEN,
    }

    public static Optional<Object> getGame(AvailableGames game) {
        if(game == AvailableGames.ROCK_PAPER_SCISSORS) {
            return Optional.of(new RockPaperScissors());
        }
        else if(game == AvailableGames.SWORDS_AND_GUNS) {
            return Optional.of(new SwardsGuns());
        }

        return Optional.empty();
    }
}
