package org.rusaik.gesturegames.engine.game;

import org.rusaik.gesturegames.engine.Gesture;
import org.rusaik.gesturegames.engine.exception.UnknownGameStatusException;

import java.util.Arrays;
import java.util.List;

public class RockPaperScissors implements Game {

    private final String ROCK = "ROCK";
    private final String PAPER = "PAPER";
    private final String SCISSORS = "SCISSORS";
    private final List<Gesture> gesture;

    public RockPaperScissors() {
        final Gesture rock = new Gesture(ROCK);
        final Gesture paper = new Gesture(PAPER);
        final Gesture scissors = new Gesture(SCISSORS);

        this.gesture = Arrays.asList(rock, paper, scissors);
    }

    public GameStatus userWinningStatus(Gesture userGesture, Gesture computerGesture) {
        switch (userGesture.getName()){
            case ROCK:
                switch (computerGesture.getName()) {
                    case ROCK:
                        return GameStatus.DRAW;
                    case PAPER:
                        return GameStatus.LOSS;
                    case SCISSORS:
                        return GameStatus.WIN;
                }

            case PAPER:
                switch (computerGesture.getName()){
                    case ROCK:
                        return GameStatus.WIN;
                    case PAPER:
                        return GameStatus.DRAW;
                    case SCISSORS:
                        return GameStatus.LOSS;
                }

            case SCISSORS:
                switch (computerGesture.getName()){
                    case ROCK:
                        return GameStatus.LOSS;
                    case PAPER:
                        return GameStatus.WIN;
                    case SCISSORS:
                        return GameStatus.DRAW;
                }
        }
        throw new UnknownGameStatusException(
                String.format("Game engine failed to execute. User played: %5, Computer played: %s",userGesture.getName(), computerGesture.getName()));
    }

    public List<Gesture> getGestures() {
        return gesture;
    }

    public String name() {
        return "ROCK PAPER SCISSORS";
    }
}
