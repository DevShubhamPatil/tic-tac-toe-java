package org.example;

import java.util.Random;
import java.util.Scanner;

public class Bot extends Player{
    public Bot(String symbol) {
        super("Jarvis", symbol);
    }

    @Override
    public void play(TicTacToe game, Scanner sc) throws InvalidMoveException {
        Random random = new Random();
        int input = game.getPositions().get(random.nextInt(game.getPositions().size()));
        game.handleInput(input,this);
        System.out.println("jarvis takes "+input);
    }
}
