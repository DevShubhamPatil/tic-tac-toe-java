package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("======= Welcome to TIK-TAC_TOE =======\n\topptions:\n\t 1. Single Player\n\t 2. Double Player\n\t");
        int humans = sc.nextInt();
        sc.nextLine();
        Player p1 = new Player();
        System.out.print("Player1: Enter Your Name: ");
        p1.setName(sc.nextLine());
        System.out.print(p1.getName() + ": Choose Your Symbol X or O: ");
        p1.setSymbol(sc.nextLine().toUpperCase());

        Player p2 = new Player();
        if (humans == 2) {
            System.out.print("Player2, Enter Your Name: ");
            p2.setName(sc.nextLine());
            p2.setSymbol(p1.getSymbol().equals("X") ? "O" : "X");
            System.out.print(p2.getName() + ": Your Symbol is: " + p2.getSymbol());

        } else {
            p2.setName("PC");
            p2.setSymbol(p1.getSymbol().equals("X") ? "O" : "X");
        }
        TicTacToe game = new TicTacToe(p1, p2);

//==================================================== Game Logic starts =================================================================
        System.out.println("\n\n============== LET'S BEGIN.! ==============\n");
        while (!game.isGameOver()) {
            game.printGrid();
            try {
                if (game.turnFlag()) {
                    p1.play(game,sc);
                } else {
                    p2.play(game,sc);
                }
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("something went Wrong try again:\n"+ e.getCause());
            }
        }
//==================================================== Game Logic Ends =================================================================
        sc.close();
        game.printGrid();
        System.out.println("\n================= AND THE WINNER IS: " + game.getWinner().getName() + " =================");

    }
}