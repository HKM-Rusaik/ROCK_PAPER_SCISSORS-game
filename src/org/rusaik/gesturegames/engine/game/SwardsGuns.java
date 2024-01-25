package org.rusaik.gesturegames.engine.game;


import org.rusaik.gesturegames.engine.Gesture;
import org.rusaik.gesturegames.engine.exception.UnknownGameStatusException;

import java.util.Arrays;
import java.util.List;

public class SwardsGuns implements Game {
    private final String SWORD = "SWORD";
    private final String GUN = "GUN";
    private final List<Gesture> gestures;

    public SwardsGuns() {
        final Gesture sward = new Gesture(SWORD);
        final Gesture gun = new Gesture(GUN);
        this.gestures = Arrays.asList(sward, gun);
    }

    @Override
    public GameStatus userWinningStatus(Gesture userGesture, Gesture computerGesture) throws UnknownGameStatusException {
        switch (userGesture.getName()) {
            case SWORD:
                switch (computerGesture.getName()) {
                    case SWORD:
                        return GameStatus.DRAW;
                    case GUN:
                        return GameStatus.LOSS;
                }
            case GUN:
                switch (computerGesture.getName()) {
                    case SWORD:
                        return GameStatus.WIN;
                    case GUN:
                        return GameStatus.DRAW;
                }
        }

        throw new UnknownGameStatusException(
                String.format("Game engine failed to execute. User played: %s, Computer played: %s", userGesture.getName(),computerGesture.getName()));
    }

    @Override
    public List<Gesture> getGestures() {
        return gestures;
    }

    @Override
    public String name() {
        return "Swards and Guns";
    }
}