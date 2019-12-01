package main;

import engine.Input;
import engine.InputLoader;
import engine.PlayGame;

public final class Main {
    private Main() {
      // just to trick checkstyle
    }

    public static void main(final String[] args) {
        InputLoader inputLoader = new InputLoader(args[0], args[1]);
        Input input = inputLoader.load();
        PlayGame playGame = new PlayGame();
        playGame.preparation(input);
        playGame.fight();
        playGame.computeOutput(args[0], args[1]);
    }
}
