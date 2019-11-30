package main;

import engine.Input;
import engine.InputLoader;
import engine.PlayGame;

public class Main {

    public static void main(String[] args){
        InputLoader inputLoader = new InputLoader(args[0], args[1]);
        Input input = inputLoader.load();
    




    }
}
