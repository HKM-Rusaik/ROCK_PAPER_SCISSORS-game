package org.rusaik.gesturegames.engine.game;

import org.rusaik.gesturegames.engine.Gesture;
import org.rusaik.gesturegames.engine.exception.UnknownGameStatusException;

import java.util.List;

public interface Game {
    enum GameStatus {
        WIN,
        LOSS,
        DRAW
    }

    GameStatus userWinningStatus(Gesture userGesture, Gesture computerGesture) throws UnknownGameStatusException;
    List<Gesture> getGestures();
    String name();
}
