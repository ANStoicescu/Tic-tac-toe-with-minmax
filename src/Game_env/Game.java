package Game_env;

import Player_interface.*;

import java.util.Scanner;

public class Game {
    Board board_ctrl;

    public void play(Player player1, Player player2) {
        board_ctrl.printBoard();
        while (true) {
            player1.computeMove();
            board_ctrl.printBoard();
            switch (board_ctrl.checkWin()) {
                case 0 -> {
                    System.out.println("O wins");
                    return;
                }
                case 1 -> {
                    System.out.println("X wins");
                    return;
                }
                case 2 -> {
                    System.out.println("draw");
                    return;
                }
            }
            player2.computeMove();
            board_ctrl.printBoard();
            switch (board_ctrl.checkWin()) {
                case 0 -> {
                    System.out.println("O wins");
                    return;
                }
                case 1 -> {
                    System.out.println("X wins");
                    return;
                }
                case 2 -> {
                    System.out.println("draw");
                    return;
                }
            }
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            Player player1 = null, player2 = null;
            String input = scanner.nextLine();
            String[] parameters = input.split(" ", 3);
            switch (parameters[0]) {
                case "start" -> {
                    if (parameters.length < 3) {
                        System.out.println("Bad parameters!");
                        continue;
                    }
                    this.board_ctrl = new Board();
                    switch (parameters[1]) {
                        case "user" -> player1 = new Human(board_ctrl);
                        case "easy" -> player1 = new Easy(board_ctrl);
                        case "medium" -> player1 = new Medium(board_ctrl);
                        case "hard" -> player1 = new Hard(board_ctrl);
                        default -> {
                            System.out.println("Bad parameters!");
                            continue;
                        }
                    }
                    switch (parameters[2]) {
                        case "user" -> player2 = new Human(board_ctrl);
                        case "easy" -> player2 = new Easy(board_ctrl);
                        case "medium" -> player2 = new Medium(board_ctrl);
                        case "hard" -> player2 = new Hard(board_ctrl);
                        default -> {
                            System.out.println("Bad parameters!");
                            continue;
                        }
                    }
                    play(player1, player2);
                }
                case "exit" -> {
                    done = true;
                }
                default -> {
                    System.out.println("Bad parameters!");
                    continue;
                }
            }
        }
    }
}
