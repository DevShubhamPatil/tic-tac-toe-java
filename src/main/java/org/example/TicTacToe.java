package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class TicTacToe {
    private Player p1;
    private Player p2;
    private String[][] grid;
    List<Integer> positions;
    private boolean isGameOver;
    private Player winner;
    private boolean turnFlag;

    public TicTacToe(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.grid = new String[3][3];
        this.isGameOver = false;
        this.winner = null;
        this.turnFlag = true;
        positions = new LinkedList<>(List.of(0, 1, 2, 10, 11, 12, 20, 21, 22));
    }

    public TicTacToe() {
        this.grid = new String[3][3];
        this.isGameOver = false;
        this.winner = null;
        positions = new LinkedList<>(List.of(0, 1, 2, 10, 11, 12, 20, 21, 22));
    }

    public List<Integer> getPositions() {
        return positions;
    }

    public void setPositions(List<Integer> positions) {
        this.positions = positions;
    }

    public boolean turnFlag() {
        return turnFlag;
    }

    private void setTurnFlag(boolean turnFlag) {
        this.turnFlag = turnFlag;
    }

    public String[][] getGrid() {
        return grid;
    }

    public void setGrid(String[][] grid) {
        this.grid = grid;
    }

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "TicTacToe{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", isGameOver=" + isGameOver +
                ", winner='" + winner + '\'' +
                '}';
    }

    private void checkGameStatus(int row, int col, Player player) {
        if(getPositions().size() > 5)
        {
            return;
        }
        if (
                Arrays.stream(grid[row]).allMatch(s -> s != null && s.equals(player.getSymbol()))
                ||
                Stream.of(grid[0][col], grid[1][col], grid[2][col]).allMatch(s -> s != null && s.equals(player.getSymbol()))
        ) {
            setGameOver(true);
            setWinner(player);
        }
        if (
                row == col
                &&
                Stream.of(grid[0][0], grid[1][1], grid[2][2]).allMatch(s -> s != null && s.equals(player.getSymbol()))
                ||
                Stream.of(grid[0][2], grid[1][1], grid[2][0]).allMatch(s -> s != null && s.equals(player.getSymbol()))
        ) {
            setGameOver(true);
            setWinner(player);
        }
    }

    public void handleInput(int input, Player player) throws InvalidMoveException {
        if (getPositions().contains(input)) {
        int row = input / 10;
        int col = input % 10;
            grid[row][col] = player.getSymbol();
            checkGameStatus(row, col, player);
            setTurnFlag(!turnFlag());
            getPositions().remove(Integer.valueOf(input));
        } else {
            throw new InvalidMoveException(input + " is Not a valid move please try again.");
        }
    }

    public void printGrid() {
        System.out.println("\n   0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(this.grid[i][j] == null ? "_ | " : grid[i][j] + " | ");
            }
            System.out.println("\b\b");
        }
        System.out.println();
    }
}
