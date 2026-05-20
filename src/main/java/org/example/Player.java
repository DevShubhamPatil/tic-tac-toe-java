package org.example;

import java.util.Scanner;

public class Player {

    private String name;
    private String symbol;

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }


    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", symbol=" + symbol +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void play(TicTacToe game, Scanner sc) throws InvalidMoveException {
        System.out.print(getName()+" Your Move: ");
        game.handleInput(sc.nextInt(),this);
    }
}
