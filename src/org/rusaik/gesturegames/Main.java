package org.rusaik.gesturegames;

import org.rusaik.gesturegames.engine.GameFactory;
import org.rusaik.gesturegames.engine.Gesture;
import org.rusaik.gesturegames.engine.exception.UnknownGameStatusException;
import org.rusaik.gesturegames.engine.game.Game;
import org.rusaik.gesturegames.util.Randomiser;

import java.util.List;
import java.util.Scanner;

public class Main {
    final static Randomiser randomiser = new Randomiser();

    public static void main(String[] args) {
        boolean gameNotCompleted = true;
        final Game game = (Game) GameFactory.getGame(GameFactory.AvailableGames.ROCK_PAPER_SCISSORS).orElseThrow();
        final List<Gesture> validGestures = game.getGestures();

        final Scanner scanner = new Scanner(System.in);

        System.out.println( "\n" + "\n" + "===========================================");
        System.out.println("Welcome to play " + game.name());
        System.out.println("===========================================" + "\n");

        System.out.println("Pick your gesture:");

        validGestures.forEach(gesture -> System.out.println(gesture.getName()));

        do {
            System.out.print("\n" + "Type your input:");
            String userInput = scanner.nextLine();

            try {
                final Gesture computerGesture = computerGesture(validGestures);
                final Game.GameStatus gameStatus = validGestures.stream()
                        .filter(userGesture -> userGesture.getName().equals(userInput.trim().toUpperCase()))
                        .map(userGesture -> game.userWinningStatus(userGesture, computerGesture))
                        .findFirst()
                        .orElseThrow(() -> new UnknownGameStatusException(String.format("Invalid user input : %s", userInput)));

                if (gameStatus.equals(Game.GameStatus.DRAW)) {
                    System.out.println("Game is a " + Game.GameStatus.DRAW.name() + ". Lets play again !!!");
                }
                else {
                    System.out.println("Computer played: " + computerGesture.getName());
                    System.out.println("Game status is: " + gameStatus.name());
                    gameNotCompleted = false;
                }

            } catch (UnknownGameStatusException exp) {
                System.out.println("Error occurred while game play: " + exp.getMessage() + ". Please try again" + "\n");
            }
        } while (gameNotCompleted);
    }

    private static Gesture computerGesture(List<Gesture> validGestures) {
        final int randomIndex = randomiser.getRandomNumber(validGestures.size());
        return validGestures.get(randomIndex);
    }
}